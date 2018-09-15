package com.uece.br.singleton;

public class Logger {
    public static Logger logger;
    private boolean ativo = false;

    protected Logger(){

    }

    public static Logger getInstance(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void log(String s) {
        if (this.ativo) {
            System.out.println("Log:"+s);
        }
    }

    public void setAtivo(boolean b){
        this.ativo = b;
    }

}



