package ru.gb.homework.sem3.data.impl;

public class WorkerWithHourlyPay extends Worker {

    private double salaryPerHour;

    public WorkerWithHourlyPay(String firstname, String lastname, double salaryPerHour) {
        super("Работник (по часовая ставка)", firstname, lastname);
        this.salaryPerHour = salaryPerHour;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public double monthlySalary() {
        return 20.8 * 8 * getSalaryPerHour();
    }
}
