package com.example.tasks;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Task1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Task1 виконується асинхронно");
        try {
            Thread.sleep(3000); // Симуляція виконання завдання
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task1 завершено");
    }
}
