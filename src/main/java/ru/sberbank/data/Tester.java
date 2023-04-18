package ru.sberbank.data;

public class Tester {
    private int id;
    private boolean isFree;
    private Task currentTask;
    private String firstName;
    private String secondName;

    public Tester(int id, String firstName, String secondName){
        this.id = id;
        this.isFree = true;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean equ(Tester d){
        if(this.id == d.id){
            if(this.firstName.equalsIgnoreCase(d.firstName) && this.secondName.equalsIgnoreCase(d.secondName)) {
                return true;
            }
        }
        return false;
    }

    public boolean AddTask(Task t){
        if (this.isFree == true && this.currentTask == null){
            this.currentTask = t;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task CheckTask(){
        if(this.currentTask != null && this.currentTask.isDeveloped == true){
            this.currentTask.isTested = true;
        }
        return this.currentTask;
    }

    public void Release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", isFree=" + isFree +
                ", currentTask=" + currentTask +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
