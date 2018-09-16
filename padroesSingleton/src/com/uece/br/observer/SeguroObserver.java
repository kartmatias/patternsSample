package com.uece.br.observer;

public class SeguroObserver extends Observer{

    public SeguroObserver(Alarme alarme){
        this.alarme = alarme;
        this.alarme.add(this);
    }

    public void update(){
        System.out.println(" Seguro Observando...");
    }
}
