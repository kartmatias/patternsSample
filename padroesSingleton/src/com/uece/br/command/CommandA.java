package com.uece.br.command;

public class CommandA implements Command{
    Joystick joystick;
    public CommandA(Joystick joystick){
        this.joystick = joystick;
    }

    public void execute(){
        joystick = null;
    }
}
