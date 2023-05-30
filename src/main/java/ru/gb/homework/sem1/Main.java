package ru.gb.homework.sem1;

import ru.gb.homework.sem1.decoration.TuningAll;
import ru.gb.homework.sem1.decoration.TuningBodyKit;
import ru.gb.homework.sem1.decoration.TuningEnginePower;
import ru.gb.homework.sem1.model.Car;
import ru.gb.homework.sem1.model.impl.BusinessClass;
import ru.gb.homework.sem1.model.impl.Jeep;
import ru.gb.homework.sem1.model.impl.Sport;

/**
 * Основной класс приложения.
 * Здесь мы сможем описать его основное назначение и способы взаимодействия с ним.
 */
public class Main {

    /**
     * Точка входа в программу. С нее всегда начинается.
     * @param args - массив строк.
     */
    public static void main(String[] args) {

        Car businessCar = new BusinessClass("Мерседес", "Седан",
                "Black", "Бизнес", "A");
        Car sportCar = new Sport("Porsche", "Спорткар",
                "Yellow", "Спорткар", 320);
        Car jeepCar = new Jeep("Jeep", "Хэчбэк", "Red", "Внедорожник", 650);

        Car carTuningEnginePower = new TuningEnginePower(businessCar);
        Car carTuningBodyKit = new TuningBodyKit(sportCar);
        Car carTuningAll = new TuningAll(jeepCar);

        System.out.println(businessCar);
        System.out.println(carTuningEnginePower);
        System.out.println();
        System.out.println(sportCar);
        System.out.println(carTuningBodyKit);
        System.out.println();
        System.out.println(jeepCar);
        System.out.println(carTuningAll);
    }

}