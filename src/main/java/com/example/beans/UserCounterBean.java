package com.example.beans;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class UserCounterBean {

    private int userCount = 0;

    public void incrementUserCount() {
        userCount++;
    }

    public int getUserCount() {
        return userCount;
    }

    public void decrementUserCount() {
        userCount--;
    }
}
