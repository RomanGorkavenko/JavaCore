package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

public class TuningBodyKit extends Tuning{

    public TuningBodyKit(Car tuningCar) {
        super(tuningCar);
    }

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
