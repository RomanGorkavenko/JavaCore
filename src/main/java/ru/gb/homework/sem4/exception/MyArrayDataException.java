package ru.gb.homework.sem4.exception;

/**
 * Класс исключения на некорректное значение в массиве.
 */
public class MyArrayDataException extends MyArrayException{

    public MyArrayDataException(String message, int indexRow, int indexColumn, String value) {
        super(message, indexRow, indexColumn, value);
    }

}
