package com.semantyca.ess.store;


/* in accordance to https://confluence.tools.boots.com/pages/viewpage.action?spaceKey=DEVOPS&title=Product*/


import com.boots.dataimport.common.config.YamlPropertyFactory;
import com.boots.dataimport.domain.MetadataDescriptor;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(factory = YamlPropertyFactory.class, value = "classpath:application.yml")
public class StoreDataDescriptor implements MetadataDescriptor {

    @Value("${dataimport.source.csv.store.datafolder}")
    private String fileSetFolder;
    private String indexName = "store";
    private String typeName = "store";

    public void setFileSetFolder(String fileSetFolder) {
        this.fileSetFolder = fileSetFolder;
    }

    public String getFileSetFolder() {
        return fileSetFolder;
    }

    public String getIndexName() {
        return indexName;
    }

    public String getTypeName() {
        return typeName;
    }

    public String[] getCsvRowTokens() {
        return null;
    }

    @Override
    public FieldSetMapper getFieldSetMapper() {
        return null;
    }
}
