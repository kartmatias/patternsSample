package com.uece.br.command;

public class jogoFutebol {
    private static final int QCMD = 2;

    private Command[] commands;

    public jogoFutebol(){
        commands = new Command[QCMD];


    }

    public void setCommand(int slot, Command command){
        this.commands[slot] = command;
    }

    public void chamaComando(int slot){
        this.commands[slot].execute();

    }

}
