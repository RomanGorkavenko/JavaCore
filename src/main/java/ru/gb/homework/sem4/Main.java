package ru.gb.homework.sem4;

import ru.gb.homework.sem4.controller.ArrayController;

/**
 * Класс с запуска программы.
 */
public class Main {

    /**
     * Точка запуска программы.
     * @param args массив строк.
     */
    public static void main(String[] args) {

        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "8g", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] array2 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"}
        };

        String[][] array3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] array4 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        ArrayController arrayController = new ArrayController();

        arrayController.sumController(array);
        System.out.println("=".repeat(50));
        arrayController.sumController(array2);
        System.out.println("=".repeat(50));
        arrayController.sumController(array3);
        System.out.println("=".repeat(50));
        arrayController.sumController(array4);

    }
}
