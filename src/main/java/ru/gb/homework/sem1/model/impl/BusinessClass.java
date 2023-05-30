package ru.gb.homework.sem1.model.impl;

/**
 * Класс машины премиум класса.
 * Наследует класс {@link CarBase}
 */
public class BusinessClass extends CarBase {

    /**
     * Поле Тип бизнес класса.
     */
    private String classBusiness;

    /**
     * Конструктор - создание нового объекта
     * с параметрами наследуемого класса {@link CarBase#CarBase(String, String, String, String)}.
     * И расширяющим параметром:
     * @param classBusiness - Тип бизнес класса.
     * @see CarBase
     */
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

    /**
     * Переопределение стандартного метода {@link String#toString()}
     * @return - возвращает строку.
     */
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
