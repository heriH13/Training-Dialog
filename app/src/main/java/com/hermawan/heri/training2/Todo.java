package com.hermawan.heri.training2;

public class Todo {
    private String name;
    private boolean isDone;

    public Todo(String name, boolean isDone){
        this.name = name;
        this.isDone = isDone;
    }

    public String getName(){
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDone(boolean isDone){
        this.isDone = isDone;
    }
}
