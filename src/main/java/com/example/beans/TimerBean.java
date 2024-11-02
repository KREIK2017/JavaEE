package com.example.beans;

import jakarta.ejb.Singleton;
import java.util.Timer;
import java.util.TimerTask;

@Singleton
public class TimerBean {

    private Timer timer;
    private boolean isRunning = false;

    public void startTimer() {
        if (!isRunning) {
            timer = new Timer(true);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Таймер: Повідомлення виведено у консоль.");
                }
            }, 0, 30000); // Запускається кожні 30 секунд
            isRunning = true;
            System.out.println("Таймер запущений.");
        } else {
            System.out.println("Таймер вже працює.");
        }
    }

    public void stopTimer() {
        if (isRunning && timer != null) {
            timer.cancel();
            isRunning = false;
            System.out.println("Таймер зупинено.");
        } else {
            System.out.println("Таймер вже зупинений.");
        }
    }
}
