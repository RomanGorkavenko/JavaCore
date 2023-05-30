package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

/**
 * Класс модификации кузова автомобиля.
 * Наследует класс {@link Tuning}
 * @see Tuning#getEnginePower()
 * @see Tuning#equipment()
 */
public class TuningBodyKit extends Tuning{

    /**
     * Конструктор - создание нового объекта с параметрами наследуемого класса:
     * @param tuningCar - модифицированный автомобиль.
     * @see Tuning#Tuning(Car)
     */
    public TuningBodyKit(Car tuningCar) {
        super(tuningCar);
    }

    /**
     * Переопределение метода {@link Tuning#equipment()}
     * @return - возвращает целое значение типа int.
     * @see Car#equipment()
     */
    @Override
    public String equipment() {
        return "Установлен расширяющий обвес";
    }

    @Override
    public String toString() {
        return tuningCar +
                " Модификация: " +
                "Комплектация " + equipment() +
                ".";
    }
}
