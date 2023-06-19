package ru.gb.homework.sem5;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Tree.print(
                new File("./src/main/java/ru/gb/homework/sem4"), "", true, false);

        backup("./src/main/java/ru/gb/homework/sem5", "./src/main/java/ru/gb/homework/sem5/backup");
    }

    private static void backup(String source, String dest) throws IOException {

        if (!new File(dest).exists()) {
            new File(dest).mkdir();
        }

        File[] files = new File(source).listFiles();

        for (File f : files) {
            if (f.isFile()) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(dest + "/" + f.getName())) {
                    int c;
                    try (FileInputStream fileInputStream = new FileInputStream(source + "/" + f.getName())) {
                        while ((c = fileInputStream.read()) != -1) {
                            fileOutputStream.write(c);
                        }
                    }
                }
            }
        }
    }
}
