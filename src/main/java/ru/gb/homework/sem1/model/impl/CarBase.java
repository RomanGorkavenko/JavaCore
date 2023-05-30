package ru.gb.homework.sem1.model.impl;

import ru.gb.homework.sem1.model.Car;

/**
 * Базовый абстрактный класс автомобиля.
 * Реализует интерфейс {@link Car}
 * @see Car#getEnginePower()
 * @see Car#equipment()
 */
public abstract class CarBase implements Car {

    /**
     * Поле Модель.
     */
    private String model;

    /**
     * Поле Кузов.
     */
    private String body;

    /**
     * Поле Цвет.
     */
    private String color;

    /**
     * Поле Тип автомобиля.
     */
    private String type;

    /**
     * Конструктор - создание нового объекта с параметрами:
     * @param model - Модель.
     * @param body - Кузов.
     * @param color - Цвет.
     * @param type - Тип.
     */
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

    /**
     * Реализация метода {@link Car#getEnginePower()} интерфейса {@link Car}
     * Для определения базовых параметров автомобиля.
     * @return - возвращает целое число типа int.
     */
    @Override
    public int getEnginePower() {
        return 100;
    }

    /**
     * Реализация метода {@link Car#equipment()} интерфейса {@link Car}
     * Для определения базовых параметров автомобиля.
     * @return - возвращает строку.
     */
    @Override
    public String equipment() {
        return "Базовая";
    }

}
