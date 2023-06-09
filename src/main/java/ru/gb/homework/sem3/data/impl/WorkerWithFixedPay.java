package ru.gb.homework.sem3.data.impl;

public class WorkerWithFixedPay extends Worker {

    private double fixedSalary;

    public WorkerWithFixedPay(String firstname, String lastname, double fixedSalary) {
        super("Работник (оклад)", firstname, lastname);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double monthlySalary() {
        return getFixedSalary();
    }
}
