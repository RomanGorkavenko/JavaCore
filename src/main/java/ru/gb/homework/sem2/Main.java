package ru.gb.homework.sem2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * Количество клеток для победы.
     */
    private static int winCount;

    /**
     * Символ игрока.
     */
    private static final char CELL_HUMAN = 'X';

    /**
     * Символ компьютера.
     */
    private static final char CELL_AI = 'O';

    /**
     * Символ пустой ячейки.
     */
    private static final char CELL_EMPTY = '•';

    /**
     * Инициализация сканера.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Массив символов - игровое поле.
     */
    private static char[][] field;

    /**
     * Инициализация класса {@link Random}
     */
    private static final Random random = new Random();

    /**
     * Размер вложенного массива.
     */
    private static int fieldSizeX;

    /**
     * Размер массива.
     */
    private static int fieldSizeY;

    /**
     * Количество столбцов в игровом поле.
     */
    private static int numberOfColumnsXField;

    /**
     * Количество строк в игровом поле.
     */
    private static int numberOfRowsYField;

    /**
     * Метод запуска игры.
     * @param args массив строк.
     */
    public static void main(String[] args) {
        initialize();
        printField();
        while (true) {
            if (humanTurn()) {
                System.out.println("Победил игрок");
                printField();
                break;
            }
            printField();
            if (checkDraw()) {
                System.out.println("Ничья!");
                break;
            }
            if (aiTurn()) {
                System.out.println("Победил компьютер");
                printField();
                break;
            }
            printField();
            if (checkDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    /**
     * Метод инициализации параметров игры и заполнения игрового поля символами пустой ячейки.
     * @see Main#numberOfColumnsXField
     * @see Main#numberOfRowsYField
     * @see Main#field
     * @see Main#winCount
     * @see Main#fieldSizeX
     * @see Main#fieldSizeY
     */
    private static void initialize() {
        fieldSizeX = 8;
        fieldSizeY = 5;

        numberOfColumnsXField = fieldSizeX * 2 + 2;
        numberOfRowsYField = fieldSizeY + 2;

        if (fieldSizeX < 5 || fieldSizeY < 5) {
            if (fieldSizeX < fieldSizeY) {
                winCount = fieldSizeX;
            } else {
                winCount = fieldSizeY;
            }
        } else {
            winCount = 4;
        }

        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = CELL_EMPTY;
            }
        }
    }

    /**
     * Метод печати игрового поля в консоль.
     * @see Main#numberOfColumnsXField
     * @see Main#numberOfRowsYField
     * @see Main#field
     */
    private static void printField() {

        int y = 0;
        int indexLineX = 0;

        for (int x = 0; x <= numberOfColumnsXField && y < numberOfRowsYField; x++) {
            if (x != numberOfColumnsXField) {
                if (y == 0) {
                    System.out.print((x == 0) ? "+" : (x % 2 != 0) ? "-" : x / 2);
                } else if (y == numberOfRowsYField - 1) {
                    System.out.print("-");
                } else {
                    System.out.print((x == 0) ? y : (x % 2 != 0) ? "|" : field[y - 1][indexLineX++]);
                }
            } else {
                System.out.println();
                x = -1;
                indexLineX = 0;
                y++;
            }
        }
    }

    /**
     * Метод реализующий ход игрока.
     * В методе запрашиваются у пользователя координаты,
     * проверяются на валидность и на символ пустой ячейки.
     * Обращается к методам:
     * {@link Main#checkWin(char, int, int, int)},
     * {@link Main#isCellEmpty(int, int)},
     * {@link Main#isCellValid(int, int)}.
     * @see Main#CELL_HUMAN
     * @see Main#winCount
     * @return возвращает true или false.
     */
    private static boolean humanTurn() {
        int y, x;

        do {
            System.out.printf("Введите координаты хода X (от 1 до %d) и Y (от 1 до %d) через пробел >>> ", fieldSizeX, fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = CELL_HUMAN;
        return checkWin(CELL_HUMAN, x, y, winCount);
    }

    /**
     * Метод реализующий ход компьютера.
     * В методе первым циклом реализуется анализ сделанных игроком ходов
     * и в случае если игрок может победить, победный ход игрока блокируется.
     * Вторым циклом анализируются сделанные ходы компьютером
     * и в случае возможной победы она реализуется.
     * Если возможность победы или установки символа рядом с уже установленным отсутствует,
     * символ устанавливается по случайным координатам с проверкой на символ пустой ячейки.
     * Обращается к методам:
     * {@link Main#checkWin(char, int, int, int)}, {@link Main#isCellEmpty(int, int)}.
     * @see Main#CELL_AI
     * @see Main#CELL_HUMAN
     * @see Main#CELL_EMPTY
     * @see Main#winCount
     * @return возвращает true или false.
     */
    private static boolean aiTurn() {
        int x, y;

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(j, i)) {
                    field[i][j] = CELL_HUMAN;
                    if (checkWin(CELL_HUMAN, j, i, winCount)) {
                        field[i][j] = CELL_AI;
                        return checkWin(CELL_AI, j, i, winCount);
                    } else {
                        field[i][j] = CELL_EMPTY;
                    }
                }
            }
        }

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellEmpty(j, i)) {
                    field[i][j] = CELL_AI;
                    if (checkWin(CELL_AI, j, i, 2)) {
                        field[i][j] = CELL_AI;
                        return checkWin(CELL_AI, j, i, winCount);
                    } else {
                        field[i][j] = CELL_EMPTY;
                    }
                }
            }
        }

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));

        field[y][x] = CELL_AI;
        return checkWin(CELL_AI, x, y, winCount);
    }

    /**
     * Метод проверки на то, что ячейка по заданным координатам имеет символ пустой ячейки.
     * @see Main#CELL_EMPTY
     * @param x координата X.
     * @param y координата Y.
     * @return возвращает true или false.
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == CELL_EMPTY;
    }

    /**
     * Метод проверки на корректность координат введенных пользователем.
     * @param x координата X.
     * @param y координата Y.
     * @return возвращает true или false.
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Метод проверки на победу по всем направлениям.
     * Обращается к методам:
     * {@link Main#checkWinHorizontal(char, int, int, int)},
     * {@link Main#checkWinVertical(char, int, int, int)},
     * {@link Main#checkWinDiagonal(char, int, int, int)}.
     * @param c символ {@link Main#CELL_HUMAN} или {@link Main#CELL_AI}.
     * @param x координата X.
     * @param y координата Y.
     * @param winCount {@link Main#winCount}.
     * @return возвращает true или false.
     */
    static boolean checkWin(char c, int x, int y, int winCount) {
        if (checkWinHorizontal(c, x, y, winCount)) {
            return true;
        } else if (checkWinVertical(c, x, y, winCount)) {
            return true;
        } else return checkWinDiagonal(c, x, y, winCount);
    }

    /**
     * Метод проверки на победу по горизонтали.
     * Начинает отсчет указанного символа от полученных координат
     * по горизонтали вправо затем влево
     * (не считая символ в полученных координатах).
     * Считает только идущие подряд символы
     * @param c символ {@link Main#CELL_HUMAN} или {@link Main#CELL_AI}.
     * @param x координата X.
     * @param y координата Y.
     * @param winCount {@link Main#winCount}.
     * @return возвращает true или false.
     */
    static boolean checkWinHorizontal(char c, int x, int y, int winCount) {
        int count = 0;

        for (int j = x; j < fieldSizeX; j++) {
            if (field[y][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        for (int j = x - 1; j >= 0; j--) {
            if (field[y][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }
        return count >= winCount;
    }

    /**
     * Метод проверки на победу по вертикали.
     * Начинает отсчет указанного символа от полученных координат
     * по вертикали вниз затем вверх
     * (не считая символ в полученных координатах).
     * Считает только идущие подряд символы
     * @param c символ {@link Main#CELL_HUMAN} или {@link Main#CELL_AI}.
     * @param x координата X.
     * @param y координата Y.
     * @param winCount {@link Main#winCount}.
     * @return возвращает true или false.
     */
    static boolean checkWinVertical(char c, int x, int y, int winCount) {
        int count = 0;

        for (int j = y; j < fieldSizeY; j++) {
            if (field[j][x] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        for (int j = y - 1; j >= 0; j--) {
            if (field[j][x] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        return count >= winCount;
    }

    /**
     * Метод проверки на победу по диагоналям.
     * Начинает отсчет указанного символа от полученных координат
     * по диагонали вверх вправо затем вниз влево
     * (не считая символ в полученных координатах),
     * затем повторяет зеркально.
     * Считает только идущие подряд символы
     * @param c символ {@link Main#CELL_HUMAN} или {@link Main#CELL_AI}.
     * @param x координата X.
     * @param y координата Y.
     * @param winCount {@link Main#winCount}.
     * @return возвращает true или false.
     */
    static boolean checkWinDiagonal(char c, int x, int y, int winCount) {
        int count = 0;

        for (int i = y, j = x; i < fieldSizeY && j < fieldSizeX; i++, j++) {
            if (field[i][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
            if (field[i][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        if (count >= winCount) return true;
        count = 0;

        for (int i = y, j = x; i < fieldSizeY && j >= 0; i++, j--) {
            if (field[i][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        for (int i = y - 1, j = x + 1; i >= 0 && j < fieldSizeX; i--, j++) {
            if (field[i][j] == c) {
                count++;
            } else {
                if (count >= winCount) {
                    return true;
                }
                break;
            }
        }

        return count >= winCount;
    }

    /**
     * Метод проверки на "Ничью".
     * @return возвращает true или false.
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }
}