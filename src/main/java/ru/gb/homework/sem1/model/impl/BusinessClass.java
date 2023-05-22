package ru.gb.homework.sem1.model.impl;

public class BusinessClass extends CarBase {

    private String classBusiness;

    public BusinessClass(String model, String body, String color, String type, String classBusiness) {
        super(model, body, color, type);
        this.classBusiness = classBusiness;
    }

    public String getClassBusiness() {
        return classBusiness;
    }

    public void setClassBusiness(String classBusiness) {
        this.classBusiness = classBusiness;
    }

    @Override
    public String toString() {
        return "Машина бизнес класса: " +
                "Модель: " + getModel() +
                ", Кузов: " + getBody() +
                ", Цвет: " + getColor() +
                ", Тип: " + getType() +
                ", Класс: " + classBusiness +
                ", Мощность двигателя: " + getEnginePower() +
                " л/с" +
                ", Комплектация: " + equipment() +
                ".";
    }
}
