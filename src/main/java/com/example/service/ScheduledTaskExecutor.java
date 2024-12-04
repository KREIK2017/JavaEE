package com.example.service;

import com.example.tasks.ScheduledTask;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.concurrent.TimeUnit;

@Named
@ApplicationScoped
public class ScheduledTaskExecutor {

    @Resource
    private ManagedScheduledExecutorService scheduledExecutorService;

    @Inject
    private ScheduledTask scheduledTask;

    public void startScheduledTask() {
        scheduledExecutorService.scheduleAtFixedRate(scheduledTask, 0, 10, TimeUnit.SECONDS);
        System.out.println("Scheduled task started!");
    }
}
