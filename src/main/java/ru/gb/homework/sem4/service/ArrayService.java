package ru.gb.homework.sem4.service;

import ru.gb.homework.sem4.exception.MyArrayDataException;
import ru.gb.homework.sem4.exception.MyArraySizeException;

/**
 * Класс реализует метод подсчета суммы элементов массива.
 * С генерацией исключений: {@link MyArrayDataException}, {@link MyArraySizeException}
 */
public class ArrayService {

    /**
     * Метод подсчета суммы элементов массива.
     * @param array принимает массив строк.
     * @return возвращает сумму элементов массива.
     * @throws MyArraySizeException исключение размерности массива.
     * @throws MyArrayDataException исключение некорректного значения.
     */
    public int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Размерность массива должна быть 4х4", array, i);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("Значение не является числом", i, j, array[i][j]);
                }
            }
        }
        return sum;
    }

}
