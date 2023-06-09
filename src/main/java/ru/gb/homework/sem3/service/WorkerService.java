package ru.gb.homework.sem3.service;

import ru.gb.homework.sem3.data.impl.Worker;
import ru.gb.homework.sem3.data.impl.WorkerWithFixedPay;
import ru.gb.homework.sem3.data.impl.WorkerWithHourlyPay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkerService {

    public List<Worker> createWorkersList(int numberOfWorkers) {
        String[] firstNames = new String[]{"Иван", "Наталья", "Пётр", "Роман", "Инга", "Тимур",
                "Анна", "Юрий", "Надежда", "Андрей", "Евгения", "Сергей", "Яна"};
        String[] lastNames = new String[]{"Буртасов", "Кутявин", "Курлаев", "Храмушин", "Брагин",
                "Ступаков", "Суслов", "Основин", "Волков", "Калинин"};
        List<Worker> workers = new ArrayList<>();

        for (int i = 0; i < numberOfWorkers; i++) {
            int indexFirstname = ThreadLocalRandom.current().nextInt(firstNames.length);
            int indexLastNames = ThreadLocalRandom.current().nextInt(lastNames.length);
            double fixedSalary = ThreadLocalRandom.current().nextDouble(30_000, 150_001);
            double salaryPerHour = ThreadLocalRandom.current().nextDouble(250, 1_001);
            int indexWorkers = ThreadLocalRandom.current().nextInt(2);
            String firstname = firstNames[indexFirstname];
            String lastname = lastNames[indexLastNames];
            if (firstname.charAt(firstname.length() - 1) == 'а' || firstname.charAt(firstname.length() - 1) == 'я') {
                lastname = lastname + "a";
            }
            if (indexWorkers == 0) {
                workers.add(new WorkerWithFixedPay(firstname, lastname, fixedSalary));
            } else {
                workers.add(new WorkerWithHourlyPay(firstname, lastname, salaryPerHour));
            }
        }
        return workers;
    }
}
