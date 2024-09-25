package com.example.demo1;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;


@Named
@SessionScoped
public class VariableBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message = "Default Message";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String updateMessage() {
        return "setVariable";  // Повертає ту ж саму сторінку для перезавантаження
    }
}
