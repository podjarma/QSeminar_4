package ru.sberbank.data;

public class Tester extends TeamMember {

    public Tester(int id, String firstName, String secondName){
        super(id, firstName, secondName);
    }

    public Task CheckTask(){
        if(this.getCurrentTask() != null && this.getCurrentTask().isDeveloped == true){
            this.getCurrentTask().isTested = true;
        }
        return this.getCurrentTask();
    }

}
