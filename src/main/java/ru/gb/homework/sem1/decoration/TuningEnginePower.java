package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

public class TuningEnginePower extends Tuning {

    public TuningEnginePower(Car tuningCar) {
        super(tuningCar);
    }

    @Override
    public int getEnginePower() {
        return super.getEnginePower() + 100;
    }

    @Override
    public String toString() {
        return tuningCar +
                " Модификация: " +
                "Мощность двигателя увеличена до " + getEnginePower() +
                " л/с" +
                ".";
    }
}
