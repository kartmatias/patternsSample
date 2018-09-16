package com.uece.br.command;

public class Joystick {
    private Command commandA;
    private Command commandB;

    public void setCommandA(Command command){
        this.commandA = command;
    }

    public void setCommandB(Command command){
        this.commandB = command;
    }

    public void pressButtonA(){
        commandA.execute();
    }

    public void pressButtonB(){
        commandB.execute();
    }

}
