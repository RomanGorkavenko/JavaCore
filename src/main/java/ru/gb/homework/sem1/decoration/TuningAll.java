package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

public class TuningAll extends Tuning {

    public TuningAll(Car tuningCar) {
        super(tuningCar);
    }

    @Override
    public int getEnginePower() {
        return super.getEnginePower() + 160;
    }

    @Override
    public String equipment() {
        return "Установлены шины для бездорожья, установлена жесткая подвеска, увеличен дорожный просвет";
    }

    @Override
    public String toString() {
        return tuningCar +
                " Модификация: " +
                "Мощность двигателя увеличена до " + getEnginePower() +
                " л/с" +
                ", Комплектация " + equipment() +
                ".";
    }

}
