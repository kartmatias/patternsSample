package com.uece.br.strategy;

import com.uece.br.strategy.ILoggerStrategy;

public class LoggerFile implements ILoggerStrategy {
    @Override
    public void Log(String s) {
        System.out.println("log to File: " + s);
    }
}
