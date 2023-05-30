package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

/**
 * Класс модификации мощности двигателя автомобиля.
 * Наследует класс {@link Tuning}
 * @see Tuning#getEnginePower()
 * @see Tuning#equipment()
 */
public class TuningEnginePower extends Tuning {

    /**
     * Конструктор - создание нового объекта с параметрами наследуемого класса:
     * @param tuningCar - модифицированный автомобиль.
     * @see Tuning#Tuning(Car)
     */
    public TuningEnginePower(Car tuningCar) {
        super(tuningCar);
    }

    /**
     * Переопределение метода {@link Tuning#getEnginePower()}
     * @return - возвращает целое значение типа int.
     * @see Car#getEnginePower()
     */
    @Override
    public int getEnginePower() {
        return super.getEnginePower() + 100;
    }

    /**
     * Переопределение стандартного метода {@link String#toString()}
     * @return - возвращает строку.
     */
    @Override
    public String toString() {
        return tuningCar +
                " Модификация: " +
                "Мощность двигателя увеличена до " + getEnginePower() +
                " л/с" +
                ".";
    }
}
