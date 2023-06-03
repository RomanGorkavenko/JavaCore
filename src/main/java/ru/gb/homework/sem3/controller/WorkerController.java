package ru.gb.homework.sem3.controller;

import ru.gb.homework.sem3.data.impl.Worker;
import ru.gb.homework.sem3.service.WorkerService;

import java.util.Collections;
import java.util.List;

public class WorkerController {

    private final WorkerService workerService;

    public WorkerController() {
        this.workerService = new WorkerService();
    }

    public void printWorkers(int numberOfWorkers) {
        List<Worker> workers = workerService.createWorkersList(numberOfWorkers);
        Collections.sort(workers);
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
