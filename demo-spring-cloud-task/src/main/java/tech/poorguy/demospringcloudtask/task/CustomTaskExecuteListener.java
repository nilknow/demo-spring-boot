package tech.poorguy.demospringcloudtask.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@Slf4j
public class CustomTaskExecuteListener implements TaskExecutionListener {
    @Override
    public void onTaskStartup(TaskExecution taskExecution) {
        log.info("task-{} named {} start",taskExecution.getExecutionId(),taskExecution.getTaskName());
    }

    @Override
    public void onTaskEnd(TaskExecution taskExecution) {
        log.info("task-{} finished",taskExecution.getExecutionId());
    }

    @Override
    public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {

    }
}
