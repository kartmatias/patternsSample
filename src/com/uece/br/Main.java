package com.uece.br;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // 1. Singleton
        Ex01Singleton();

        // 2. Strategy
        Ex02Strategy();

        // 3. Factoryethod
        Ex03FactoryMethod();

    }

    private static void Ex01Singleton(){
        Logger logger1 = Logger.getInstance();
        logger1.setAtivo(true);
        logger1.log("Primeira mensagem");

        Logger logger2 = Logger.getInstance();
        logger2.log("Segunda mensagem");

    }

    public static void Ex02Strategy(){
        StrategyContext ctx = new StrategyContext();

        ctx.setLoggerStrategy(new LoggerEventViewer());

        ctx.CreateLog("Usando EVENTVIEWER");
    }

    public static void Ex03FactoryMethod(){
       enum TipoImagem {JPG, BMP};
       IVisualizador vs;



    }

}
