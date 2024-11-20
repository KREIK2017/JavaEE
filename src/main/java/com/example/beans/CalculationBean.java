package com.example.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CalculationBean implements Serializable {

    private int value;

    public CalculationBean() {
        this.value = 10; // Початкове значення
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Додавання
    public void add(int number) {
        this.value += number;
    }

    // Віднімання
    public void subtract(int number) {
        this.value -= number;
    }

    // Множення
    public void multiply(int number) {
        this.value *= number;
    }

    // Ділення
    public void divide(int number) {
        if (number != 0) {
            this.value /= number;
        }
    }

    // Скидання значення
    public void reset() {
        this.value = 0;
    }
}
