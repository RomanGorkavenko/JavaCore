package ru.gb.homework.sem3;

import ru.gb.homework.sem3.controller.WorkerController;

public class Main {
    public static void main(String[] args) {
        WorkerController workerController = new WorkerController();
        workerController.printWorkers(10);
    }
}
