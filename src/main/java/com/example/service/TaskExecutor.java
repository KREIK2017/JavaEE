package com.example.service;

import com.example.tasks.Task1;
import com.example.tasks.Task2;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class TaskExecutor {

    @Resource
    private ManagedExecutorService executorService;

    @Inject
    private Task1 task1;

    @Inject
    private Task2 task2;

    public void executeTasks() {
        executorService.execute(task1);
        executorService.execute(task2);
    }
}
