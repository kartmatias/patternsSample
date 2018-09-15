package com.uece.br.strategy;

import com.uece.br.strategy.ILoggerStrategy;

public class LoggerEventViewer implements ILoggerStrategy {
    @Override
    public void Log(String s) {
        System.out.println("log to EventViewer: " + s);
    }
}
