package ru.gb.homework.sem4.exception;

/**
 * Класс исключения на размерность массива.
 */
public class MyArraySizeException extends MyArrayException{

    public MyArraySizeException(String message, String[][] array, int indexColumn) {
        super(message, array, indexColumn);
    }

}
