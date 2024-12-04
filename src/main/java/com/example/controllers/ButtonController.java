package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ButtonController {

    public void action() {
        System.out.println("Primary button clicked.");
    }

    public void info() {
        System.out.println("Secondary button clicked.");
    }

    public void delete() {
        System.out.println("Delete confirmed.");
    }
}
