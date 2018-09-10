package com.uece.br;

public class LoggerEventViewer implements ILoggerStrategy {
    @Override
    public void Log(String s) {
        System.out.println("log to EventViewer: " + s);
    }
}
