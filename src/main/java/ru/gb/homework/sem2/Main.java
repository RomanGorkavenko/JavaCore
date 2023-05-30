package ru.gb.homework.sem2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final char CELL_HUMAN = 'X';
    private static final char CELL_AI = 'O';
    private static final char CELL_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field;

    private static final Random random = new Random();

    private static int fieldSizeX;
    private static int fieldSizeY;

    public static void main(String[] args) {

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