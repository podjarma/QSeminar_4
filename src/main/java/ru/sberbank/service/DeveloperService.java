package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService {
    public ArrayList<Developer> list;

    public DeveloperService() {
        this.list = new ArrayList<>();
    }

    public void createDeveloper(int id, String firstName, String secondName) throws IllegalAccessException {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalAccessException("Входные данные не валидны");
        }
        list.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) throws IllegalAccessException {
        for (Developer t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        throw new IllegalAccessException("Разработчики не найдены");
    }

    public ArrayList<Developer> getFreeDevelopers() {
        ArrayList<Developer> freeTester = new ArrayList<>();
        for (Developer n: list) {
            if(n.isFree) {
                freeTester.add(n);
            }
        }
        return freeTester;
    }

}