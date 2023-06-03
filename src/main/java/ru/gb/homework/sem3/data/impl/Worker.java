package ru.gb.homework.sem3.data.impl;

import ru.gb.homework.sem3.data.SortWorker;

import java.text.DecimalFormat;
import java.util.Comparator;

public abstract class Worker implements SortWorker {

    private String title;
    private String firstname;
    private String lastname;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public Worker(String title, String firstname, String lastname) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public abstract double monthlySalary();

    @Override
    public int compareTo(Worker o) {
        return Comparator.comparing(Worker::getTitle)
                .thenComparing(Worker::getLastname)
                .thenComparing(Worker::monthlySalary)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return title + ": " +
                "фамилия: " + lastname +
                ", имя: " + firstname +
                ", зарплата: " + decimalFormat.format(monthlySalary()) +
                " ₽.";
    }

}
