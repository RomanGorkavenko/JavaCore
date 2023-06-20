package ru.gb.homework.sem5;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Tree.print(
                new File("./src/main/java/ru/gb/homework/sem4"), "", true, false);

        backup("./src/main/java/ru/gb/homework/sem5", "./src/main/java/ru/gb/homework/sem5/backup");

        int[] num = new int[]{2, 1, 1, 0, 2, 1, 3, 1, 1};
        writeFileThreeBytes(num);
        System.out.println("Массив входящий: " + Arrays.toString(num));
        System.out.println("Массив считанный с файла: " + Arrays.toString(extractedFileThreeBytes()));
        System.out.println("Массивы равны? -> " + (Arrays.equals(num, extractedFileThreeBytes()) ? "Да" : "Нет"));
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

    private static void writeFileThreeBytes(int[] num) throws IOException {
        try(FileOutputStream fos=new FileOutputStream("ThreeBytes.txt"))
        {
            StringBuilder builder = new StringBuilder();
            int count = 0;
            for (int n: num) {
                if (count != 0 || n != 0) {
                    builder.append(n);
                }
                count++;
                if (count == 3) {
                    int result = Integer.parseInt(builder.toString());
                    byte write = 0;
                    if (result > 127) {
                        write = (byte) (result - 256);
                    } else {
                        write = (byte) result;
                    }
                    fos.write(write);
                    count = 0;
                    builder.setLength(0);
                }
            }
        }
    }

    private static int[] extractedFileThreeBytes() throws IOException {
        StringBuilder builder = new StringBuilder();
        try(FileInputStream in = new FileInputStream("ThreeBytes.txt")) {
            byte c;
            while ((c = (byte) in.read()) != -1) {
                if (c < 30 && c > 0) {
                    builder.append("0").append(c);
                } else if (c < 0 || (c > 30 && c < 100)) {
                    int temp = c + 256;
                    builder.append(temp);
                } else if (c == 0) {
                    builder.append("00").append(c);
                } else {
                    builder.append(c);
                }
            }
        }
        int[] resultArray = new int[builder.length()];
        for (int i = 0; i < builder.length(); i++) {
            resultArray[i] = Integer.parseInt(String.valueOf(builder.charAt(i)));
        }
        return resultArray;
    }

}
