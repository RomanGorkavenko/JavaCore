package ru.gb.homework.sem1.model.impl;

import ru.gb.homework.sem1.model.Car;

/**
 * Класс спортивного автомобиля.
 * Наследует класс {@link CarBase}
 */
public class Sport extends CarBase {

    /**
     * Поле Максимальна скорость.
     */
    private int maxSpeed;

    /**
     * Конструктор - создание нового объекта
     * с параметрами наследуемого класса {@link CarBase#CarBase(String, String, String, String)}.
     * И расширяющим параметром:
     * @param maxSpeed - Максимальная скорость.
     * @see CarBase
     */
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

    /**
     * Переопределение метода {@link CarBase#getEnginePower()}
     * @return - возвращает целое значение типа int.
     * @see Car#getEnginePower()
     */
    @Override
    public int getEnginePower() {
        return super.getEnginePower() + 300;
    }

    /**
     * Переопределение стандартного метода {@link String#toString()}
     * @return - возвращает строку.
     */
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
