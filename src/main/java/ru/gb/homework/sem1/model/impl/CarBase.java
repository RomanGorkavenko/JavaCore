package ru.gb.homework.sem1.model.impl;

import ru.gb.homework.sem1.model.Car;

public abstract class CarBase implements Car {

    private String model;
    private String body;
    private String color;
    private String type;

    public CarBase(String model, String body, String color, String type) {
        this.model = model;
        this.body = body;
        this.color = color;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getBody() {
        return body;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getEnginePower() {
        return 100;
    }

    @Override
    public String equipment() {
        return "Базовая";
    }

}
