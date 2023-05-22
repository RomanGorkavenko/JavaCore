package ru.gb.homework.sem1.model;

/**
 * Интерфейс Car.
 * Определяет базовые методы для реализации.
 */
public interface Car {

    /**
     * Определяет мощность двигателя.
     * @return - возвращает целое значение типа int.
     */
    int getEnginePower();

    /**
     * Определяет комплектацию автомобиля.
     * @return - возвращает строку.
     */
    String equipment();

}
