package tech.poorguy.demospringbatch;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.*;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobConfigIntegrationTest {
    @Autowired
    private Job job;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobOperator jobOperator;
    @Autowired
    private JobExplorer jobExplorer;

    @Test
    @Disabled
    @DisplayName("jobShouldBuilt")
    void jobShouldBuilt() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, InterruptedException, NoSuchJobExecutionException, JobExecutionNotRunningException, NoSuchJobException {
        JobParameters jobParameters = new JobParametersBuilder().addDate("start", new Date()).toJobParameters();
        new Thread(() -> {
            try {
                jobLauncher.run(job, jobParameters);
            } catch (JobExecutionAlreadyRunningException e) {
                e.printStackTrace();
            } catch (JobRestartException e) {
                e.printStackTrace();
            } catch (JobInstanceAlreadyCompleteException e) {
                e.printStackTrace();
            } catch (JobParametersInvalidException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000L);
        Optional<JobExecution> jobOpt = jobExplorer.findRunningJobExecutions("job").stream().findFirst();
        if (jobOpt.isPresent()) {
            Thread.sleep(13*1000);
            System.out.println("try to stop");
            jobOperator.stop(jobOpt.get().getId());
            Thread.sleep(5*1000);
            jobOperator.restart(jobOpt.get().getId());
        }
    }

}