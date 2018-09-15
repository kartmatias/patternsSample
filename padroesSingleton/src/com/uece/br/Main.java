package com.uece.br;

import com.uece.br.chain.*;
import com.uece.br.decorator.Cobertura;
import com.uece.br.decorator.FrozenBase;
import com.uece.br.decorator.IFrozenItem;
import com.uece.br.decorator.Topo;
import com.uece.br.factoryMethod.DecodedImage;
import com.uece.br.factoryMethod.IVisualizador;
import com.uece.br.factoryMethod.VisualizadorBmp;
import com.uece.br.factoryMethod.VisualizadorJpg;
import com.uece.br.singleton.Logger;
import com.uece.br.strategy.LoggerEventViewer;
import com.uece.br.strategy.StrategyContext;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // 1. Singleton
        System.out.println(ConsoleColors.RED + "EXEMPLO SINGLETON" + ConsoleColors.RESET + " =");
        Ex01Singleton();

        // 2. Strategy
        System.out.println(ConsoleColors.GREEN + "EXEMPLO STRATEGY" + ConsoleColors.RESET + " =");
        Ex02Strategy();

        // 3. Factoryethod
        System.out.println(ConsoleColors.YELLOW + "EXEMPLO FACTORY METHOD" + ConsoleColors.RESET + " =");
        Ex03FactoryMethod("foto.bmp");
        Ex03FactoryMethod("foto.jpg");

        //4. Decorator
        System.out.println(ConsoleColors.BLUE + "EXEMPLO DECORATOR" + ConsoleColors.RESET + " =");
        Ex04Decorator();

        //5. Chain
        System.out.println(ConsoleColors.CYAN + "EXEMPLO CHAIN" + ConsoleColors.RESET + " =");
        Ex05Chain();

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

    public static void Ex03FactoryMethod(String image){
        DecodedImage decodedImage;
        IVisualizador visualizador = null;
        String formato = image.substring(image.indexOf('.')+1, image.length());
        if (formato.equals("jpg")){
            visualizador = new VisualizadorJpg(image);
        }
        if (formato.equals("bmp")){
            visualizador = new VisualizadorBmp(image);
        }
        if (visualizador == null) throw new AssertionError();
        decodedImage = visualizador.getDecodeImage();
        System.out.println(decodedImage);
    }

    public static void Ex04Decorator(){
        IFrozenItem frozen = new FrozenBase("yogurte de frutas", 15);
        frozen = new Topo("castanha",8,frozen);
        frozen = new Topo("frutas cristalizadas",6,frozen);
        frozen = new Cobertura("chocolate", 5, frozen);
        System.out.println(frozen.getNome());
        System.out.println(frozen.getPreco());

    }

    public static  void Ex05Chain(){
        CedulaChain cedulas = new CedulaUm();
        cedulas.setNext(new CedulaCinco());
        cedulas.setNext(new CedulaDez());

        try {
            cedulas.pagamento(IdCedulas.um);
            cedulas.pagamento(IdCedulas.dez);
            cedulas.pagamento(IdCedulas.cinco);
            cedulas.pagamento(IdCedulas.um);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
