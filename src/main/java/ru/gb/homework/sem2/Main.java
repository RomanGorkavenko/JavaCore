package ru.gb.homework.sem2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int winCount;
    private static final char CELL_HUMAN = 'X';
    private static final char CELL_AI = 'O';
    private static final char CELL_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field;

    private static final Random random = new Random();

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int numberOfColumnsXField;
    private static int numberOfRowsYField;

    public static void main(String[] args) {

    }

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

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == CELL_EMPTY;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }
}