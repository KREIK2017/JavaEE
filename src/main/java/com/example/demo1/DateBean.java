package com.example.demo1;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;


@Named
@RequestScoped
public class DateBean implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getCurrentDate() {
        return new Date().toString();
    }
}
