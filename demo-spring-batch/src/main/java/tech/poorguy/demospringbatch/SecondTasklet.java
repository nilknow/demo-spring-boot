package tech.poorguy.demospringbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.StoppableTasklet;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class SecondTasklet implements StoppableTasklet {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                log.info("start second task");
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("end second task");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void stop() {
        executor.shutdownNow();
    }
}
