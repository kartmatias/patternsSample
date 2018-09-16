package com.uece.br.observer;

import java.util.ArrayList;
import java.util.List;

public class Alarme {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void add(Observer o){
        observers.add(o);
    }

    public int getState(){
        return state;
    }

    public void setState(int value){
        this.state = value;
    }

    public void execute(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
