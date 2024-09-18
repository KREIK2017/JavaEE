package com.example.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBean {
    private String currentDate;

    public DateBean() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        currentDate = formatter.format(new Date());
    }

    public String getCurrentDate() {
        return currentDate;
    }
}
