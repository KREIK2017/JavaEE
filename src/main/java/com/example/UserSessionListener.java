package com.example;

import com.example.beans.UserCounterBean;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.inject.Inject;

public class UserSessionListener implements HttpSessionListener {

    @Inject
    private UserCounterBean userCounterBean;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        userCounterBean.incrementUserCount();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        userCounterBean.decrementUserCount();
    }
}
