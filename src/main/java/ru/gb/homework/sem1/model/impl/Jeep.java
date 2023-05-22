package ru.gb.homework.sem1.model.impl;

/**
 * Класс Внедорожника.
 * Наследует класс {@link CarBase}
 */
public class Jeep extends CarBase {

    /**
     * Поле Высота колеса.
     */
    private int wheelHeight;

    /**
     * Конструктор - создание нового объекта
     * с параметрами наследуемого класса {@link CarBase#CarBase(String, String, String, String)}.
     * И расширяющим параметром:
     * @param wheelHeight - Высота колеса.
     * @see CarBase
     */
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

    /**
     * Переопределение стандартного метода {@link String#toString()}
     * @return - возвращает строку.
     */
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
