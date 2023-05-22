package ru.gb.homework.sem1.decoration;

import ru.gb.homework.sem1.model.Car;

public abstract class Tuning implements Car {

    protected Car tuningCar;

    public Tuning(Car tuningCar) {
        this.tuningCar = tuningCar;
    }

    public int getEnginePower() {
        return tuningCar.getEnginePower();
    }

    public String equipment() {
        return tuningCar.equipment();
    }

}
