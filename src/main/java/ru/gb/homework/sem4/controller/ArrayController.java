package ru.gb.homework.sem4.controller;

import ru.gb.homework.sem4.exception.MyArrayDataException;
import ru.gb.homework.sem4.exception.MyArraySizeException;
import ru.gb.homework.sem4.service.ArrayService;

/**
 * Класс реализует объект класса {@link ArrayService}.
 * Реализует метод обрабатывающий пробрасываемые медом {@link ArrayService#sumArrayElements(String[][])} исключения,
 * печатает результат в консоль.
 */
public class ArrayController {

    /**
     * Поле {@link ArrayService}
     */
    private final ArrayService arrayService;

    /**
     * Конструктор класса.
     * Инициализирует объект класса {@link ArrayService}
     */
    public ArrayController() {
        this.arrayService = new ArrayService();
    }

    /**
     * Метод обрабатывает пробрасываемые медом {@link ArrayService#sumArrayElements(String[][])} исключения.
     * Печатает результат в консоль.
     * @param array принимает массив строк.
     */
    public void sumController(String[][] array){

        int result;

        try {
            result = arrayService.sumArrayElements(array);
            System.out.println("Сумма всех элементов массива = " + result);
        } catch (MyArraySizeException exception) {
            System.out.printf("Ошибка размерности массива. " +
                            "Размер массива = %d, размер вложенного массива с индексом %d = %d\n%s\n",
                    exception.getArray().length,
                    exception.getIndexColumn(),
                    exception.getArray()[exception.getIndexColumn()].length,
                    exception.getMessage());
        } catch (MyArrayDataException exception) {
            System.out.printf("Ошибка в значении: %s, в ячейке: строка %d, столбец %d\n%s\n",
                    exception.getValue(), exception.getIndexRow(), exception.getIndexColumn(), exception.getMessage());
        }
    }
}
