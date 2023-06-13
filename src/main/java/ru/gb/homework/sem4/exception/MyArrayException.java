package ru.gb.homework.sem4.exception;

/**
 * Базовый абстрактный класс исключений.
 */
public abstract class MyArrayException extends Exception{

    /**
     * Поле массив строк.
     */
    private String[][] array;

    /**
     * Поле индекс строк
     */
    private int indexRow;

    /**
     * Поле индекс столбцов
     */
    private int indexColumn;

    /**
     * Поле значение.
     */
    private String value;

    public MyArrayException(String message, String[][] array, int indexRow, int indexColumn, String value) {
        super(message);
        this.array = array;
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
        this.value = value;
    }

    public MyArrayException(String message, String[][] array, int indexColumn) {
        super(message);
        this.array = array;
        this.indexColumn = indexColumn;
    }

    public MyArrayException(String message, int indexRow, int indexColumn, String value) {
        super(message);
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
        this.value = value;
    }

    public String[][] getArray() {
        return array;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexColumn() {
        return indexColumn;
    }

    public String getValue() {
        return value;
    }
}
