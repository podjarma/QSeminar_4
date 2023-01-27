package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public void createTask(int id, String summary) throws IllegalAccessException {
        if(summary == null || summary.isEmpty()){
            throw new IllegalAccessException("Входные данные не валидны");
        }
        arrayList.add(new Task(id, summary));
    }

    public Task getTask(String summary) throws IllegalAccessException {
        for (Task n: arrayList) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalAccessException("Задачи не найдены");
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: arrayList) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        return list;
    }

}