package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

/**
 * Базовый абстрактный класс модификации автомобиля.
 * Реализует интерфейс {@link Car}
 * @see Car#getEnginePower()
 * @see Car#equipment()
 */
public abstract class Tuning implements Car {

    /**
     * Поле Модификация автомобиля.
     * Тип поля {@link Car}
     */
    protected Car tuningCar;

    /**
     * Конструктор - создание нового объекта с параметрами:
     * @param tuningCar - модифицированный автомобиль.
     */
    public Tuning(Car tuningCar) {
        this.tuningCar = tuningCar;
    }

    /**
     * Переопределение метода {@link Car#getEnginePower()} интерфейса {@link Car}
     * Для расширения базовых параметров автомобиля.
     * @return - возвращает целое число типа int.
     */
    public int getEnginePower() {
        return tuningCar.getEnginePower();
    }

    /**
     * Переопределение метода {@link Car#equipment()} интерфейса {@link Car}
     * Для расширения базовых параметров автомобиля.
     * @return - возвращает строку.
     */
    public String equipment() {
        return tuningCar.equipment();
    }

}
