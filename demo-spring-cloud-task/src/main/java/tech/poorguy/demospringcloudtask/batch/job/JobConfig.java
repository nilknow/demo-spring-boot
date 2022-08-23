//package com.nilknow.demospringcloudtask.batch.job;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.task.listener.TaskExecutionListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.nilknow.demospringcloudtask.task.CustomTaskExecuteListener;
//
//@Configuration
//public class JobConfig {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public TaskExecutionListener taskExecutionListener(){
//        return new CustomTaskExecuteListener();
//    }
//
//    @Bean
//    public Job sayHiJob(){
//        return jobBuilderFactory.get("sayHiJob")
//                .start(sayHiStep())
//                .build();
//    }
//
//    @Bean
//    public Step sayHiStep(){
//        return stepBuilderFactory.get("sayHiStep")
//                .tasklet(sayHiTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet sayHiTasklet(){
//        return (stepContribution, chunkContext) -> {
//            System.out.println("tasklet say hi");
//            return RepeatStatus.FINISHED;
//        };
//    }
//}
