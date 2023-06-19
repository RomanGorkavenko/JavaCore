package ru.gb.homework.sem5;

import java.io.File;

public class Tree {

    public static void print(File file, String indent, boolean isLast, boolean color) {
        // ├─ └─ │ ─
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (color) {
            System.out.println((char)27 + "[36m" + file.getName() + (char)27 + "[0m");
        } else {
            System.out.println((char)27 + "[33m" + file.getName() + (char)27 + "[0m");
        }

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        int subTotal = 0;
        for (int i = 0; i < files.length; i++) {
            subTotal++;
        }

        int subCounter = 0;
        for (File value : files) {
            print(value, indent, subCounter == subTotal - 1, value.isFile());
            subCounter++;
        }
    }
}
