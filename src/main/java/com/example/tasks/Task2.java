package com.example.tasks;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Task2 виконується асинхронно");
        try {
            Thread.sleep(2000); // Симуляція виконання завдання
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2 завершено");
    }
}
