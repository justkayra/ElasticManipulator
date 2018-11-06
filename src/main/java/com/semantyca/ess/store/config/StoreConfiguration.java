package com.semantyca.ess.store.config;

import com.boots.dataimport.common.exception.BatchApplicationException;
import com.boots.dataimport.common.exception.BatchApplicationExceptionType;
import com.boots.dataimport.config.AbstractDataImportConfiguration;
import com.boots.dataimport.domain.ImportedDataRow;
import com.boots.dataimport.domain.store.StoreDataDescriptor;
import com.boots.dataimport.domain.store.model.Location;
import com.boots.dataimport.steps.ESWriter;
import com.boots.dataimport.steps.MultiTypeFilePartitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class StoreConfiguration extends AbstractDataImportConfiguration {

    @Autowired
    private StoreDataDescriptor dataDescriptor;

    private static final Logger LOG = LoggerFactory.getLogger(StoreConfiguration.class);


    @Bean(name = "storeJob")
    public Job importDataJob() throws UnexpectedInputException, BatchApplicationException {
        return jobs.get("storeJob")
                .start(partitionStep())
                .build();
    }

    @Bean("storeStep")
    public Step partitionStep() throws UnexpectedInputException, BatchApplicationException {
        return steps.get("storeStep")
                .partitioner("slaveStep", partitioner())
                .step(slaveStep())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step slaveStep() throws UnexpectedInputException {
        return steps.get("slaveStep")
                .<ImportedDataRow, ImportedDataRow>chunk(1)
                .reader(itemReader(null))
                .writer(itemWriter(null))
                .build();
    }



    public MultiTypeFilePartitioner partitioner() throws BatchApplicationException {
        MultiTypeFilePartitioner partitioner = new MultiTypeFilePartitioner();
        try {
            partitioner.addResources(Arrays.asList(resoursePatternResolver.getResources("file:" + dataDescriptor.getFileSetFolder() + File.separator + "*.xml")), dataDescriptor.getTypeName());
        } catch (IOException e) {
            throw new BatchApplicationException(BatchApplicationExceptionType.RUNTIME_ERROR, e);
        }
        return partitioner;
    }


    @Bean("storeReader")
    @StepScope
    public StaxEventItemReader<Location> itemReader(@Value("#{stepExecutionContext[fileName]}") String filename) throws UnexpectedInputException{
        StaxEventItemReader<Location> staxEventItemReader = new StaxEventItemReader<>();
        System.out.println("filename = [" + filename + "]");
        staxEventItemReader.setResource(new PathResource(dataDescriptor.getFileSetFolder() + File.separator + filename));
        staxEventItemReader.setFragmentRootElementName("Location");
        Jaxb2Marshaller unMarshaller = new Jaxb2Marshaller();
        unMarshaller.setClassesToBeBound(Location.class);
        staxEventItemReader.setUnmarshaller(unMarshaller);
        return staxEventItemReader;
    }

    @Bean("storeWriter")
    @StepScope
    public ESWriter itemWriter(@Value("#{stepExecutionContext[fileName]}") String filename) throws UnexpectedInputException {
        return new ESWriter(esServerClient.get(), dataDescriptor);
    }


}
