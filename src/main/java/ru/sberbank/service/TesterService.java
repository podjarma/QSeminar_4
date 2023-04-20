package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> {

    public TesterService(){
        super();
    }

    public boolean CreateTester(String firstName, String secondName){
        if((firstName == null && firstName.isEmpty()) || (secondName == null && firstName.isEmpty())){
            throw new IllegalArgumentException("Фамилия или имя пустые");
        }
        int id = list.size();
        Tester t = new Tester(++id, firstName, secondName);
        list.add(t);
        return true;
    }

    public Tester GetTester(String firstName, String secondName){
        for (Tester t: list) {
            if(firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())){
                return t;
            }
        }
        throw new IllegalStateException("Тестер не найден");
    }

    public ArrayList<Tester> GetFreeTesters(){
        ArrayList<Tester> t = new ArrayList<>();
        for(Tester tester: list){
            if (tester.isFree() == true){
                t.add(tester);
            }
        }
        return t;
    }
}
