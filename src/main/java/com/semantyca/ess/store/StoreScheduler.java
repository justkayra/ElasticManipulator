package com.semantyca.ess.store;

import com.boots.dataimport.common.config.YamlPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("storeScheduler")
@EnableScheduling
@PropertySource(factory = YamlPropertyFactory.class, value = "classpath:application.yml")
public class StoreScheduler {
    private Job job;
    private JobLauncher jobLauncher;

    private static final Logger LOG = LoggerFactory.getLogger(StoreScheduler.class);

    @Autowired
    public StoreScheduler(JobLauncher jobLauncher, @Qualifier("storeJob") Job job){
        this.job = job;
        this.jobLauncher = jobLauncher;
    }

    @Scheduled(cron = "${dataimport.scheduler.store.expression}")
    public void runJob(){
        LOG.info("MedicineScheduler started");
        launch();
    }

    public void launch(){
        LOG.info("Starting the batch job");
        try {
            JobParameters jobParameters =
                    new JobParametersBuilder()
                            .addLong("time",System.currentTimeMillis()).toJobParameters();
            final JobExecution execution = jobLauncher.run(job, jobParameters);
            LOG.info("Job Status : " + execution.getStatus());
            LOG.info("Job succeeded");
        } catch (final Exception e) {
            LOG.error("Job failed", e);
        }
    }
}