package ru.gb.homework.sem5;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Tree.print(
                new File("./src/main/java/ru/gb/homework/sem4"), "", true, false);
    }
}
