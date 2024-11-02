package com.example.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class TimerController {

    @EJB
    private TimerBean timerBean;

    public void start() {
        timerBean.startTimer();
    }

    public void stop() {
        timerBean.stopTimer();
    }
}
