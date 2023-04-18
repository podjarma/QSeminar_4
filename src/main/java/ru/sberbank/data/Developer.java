package ru.sberbank.data;

import java.util.Objects;

public class Developer {


    private Task currentTask;
    private int id;
    private boolean isFree;
    private String firstName;
    private String secondName;

    public Task getCurrentTask() {
        return currentTask;
    }
    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
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

    public Developer(int id, String firstName, String secondName) {
        this.id = id;
        this.isFree = true;
        this.secondName = secondName;
        this.firstName = firstName;
    }

    public boolean addTask(Task task){
        if(this.isFree && this.currentTask == null){
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task makeTask(){
        if(this.currentTask != null && !this.isFree){
            this.currentTask.isDeveloped = true;
            this.isFree = true;
        }
        return null;
    }

    public void release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id && isFree == developer.isFree && Objects.equals(currentTask, developer.currentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTask, id, isFree);
    }
}
