package ru.gb.homework.sem1.model.impl;

public class Jeep extends CarBase {

    private int wheelHeight;

    public Jeep(String model, String body, String color, String type, int wheelHeight) {
        super(model, body, color, type);
        this.wheelHeight = wheelHeight;
    }

    public int getWheelHeight() {
        return wheelHeight;
    }

    public void setWheelHeight(int wheelHeight) {
        this.wheelHeight = wheelHeight;
    }

    @Override
    public String toString() {
        return "Внедорожник: " +
                "Модель: " + getModel() +
                ", Кузов: " + getBody() +
                ", Цвет: " + getColor() +
                ", Тип: " + getType() +
                ", Высота колеса: " + wheelHeight + " мм." +
                ", Мощность двигателя: " + getEnginePower() +
                " л/с" +
                ", Комплектация: " + equipment() +
                ".";
    }
}
