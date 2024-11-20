package com.example.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculationController {

    @Inject
    private CalculationBean calculationBean;
    private int number;
    private int result = 0;

    @Produces
    @Named("producedCalculationBean")
    public CalculationBean produceCalculationBean() {
        calculationBean.setValue(10); // Початкове значення
        return calculationBean;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    // Метод для додавання
    public void performAddition() {
        calculationBean.add(number);
        result = calculationBean.getValue();
    }

    // Метод для віднімання
    public void performSubtraction() {
        calculationBean.subtract(number);
        result = calculationBean.getValue();
    }

    // Метод для множення
    public void performMultiplication() {
        calculationBean.multiply(number);
        result = calculationBean.getValue();
    }


    public void performDivision() {
        if (number != 0) {
            calculationBean.divide(number);
            result = calculationBean.getValue();
        } else {
            result = -1; // Умовний індикатор помилки
        }
    }

    // Отримує поточне значення з CalculationBean
    public int getCurrentValue() {
        return calculationBean.getValue();
    }

    // Метод для скидання значення до початкового
    public void reset() {
        calculationBean.reset();
        result = calculationBean.getValue();
    }
}
