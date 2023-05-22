package ru.gb.homework.sem1.model.impl;

public class Sport extends CarBase {

    private int maxSpeed;

    public Sport(String model, String body, String color, String type, int maxSpeed) {
        super(model, body, color, type);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int getEnginePower() {
        return super.getEnginePower() + 300;
    }

    @Override
    public String toString() {
        return "Спорткар: " +
                "Модель: " + getModel() +
                ", Кузов: " + getBody() +
                ", Цвет: " + getColor() +
                ", Тип: " + getType() +
                ", Максимальная скорость: " + maxSpeed + "км/ч" +
                ", Мощность двигателя: " + getEnginePower() +
                " л/с" +
                ", Комплектация: " + equipment() +
                ".";
    }
}
