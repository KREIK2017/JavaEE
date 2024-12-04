package com.example.tasks;

import jakarta.enterprise.context.Dependent;

@Dependent
public class ScheduledTask implements Runnable {

    @Override
    public void run() {
        System.out.println("ScheduledTask виконується за розкладом");
    }
}
