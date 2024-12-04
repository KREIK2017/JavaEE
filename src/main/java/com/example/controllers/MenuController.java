package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MenuController {

    public void option1() {
        System.out.println("Option 1 selected.");
    }

    public void option2() {
        System.out.println("Option 2 selected.");
    }

    public void settings() {
        System.out.println("Settings selected.");
    }
}
