package com.uece.br;

import com.uece.br.abstractFactory.PizzaioloDom;
import com.uece.br.abstractFactory.PizzaioloFactory;
import com.uece.br.abstractFactory.PizzaioloSegQuaSex;
import com.uece.br.abstractFactory.PizzaioloTerQuiSab;
import com.uece.br.chain.*;
import com.uece.br.decorator.Cobertura;
import com.uece.br.decorator.FrozenBase;
import com.uece.br.decorator.IFrozenItem;
import com.uece.br.decorator.Topo;
import com.uece.br.factoryMethod.DecodedImage;
import com.uece.br.factoryMethod.IVisualizador;
import com.uece.br.factoryMethod.VisualizadorBmp;
import com.uece.br.factoryMethod.VisualizadorJpg;
import com.uece.br.observer.Alarme;
import com.uece.br.observer.PoliciaObserver;
import com.uece.br.observer.SeguroObserver;
import com.uece.br.singleton.Logger;
import com.uece.br.strategy.LoggerEventViewer;
import com.uece.br.strategy.StrategyContext;
import com.uece.br.templateMethod.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here

        // 1. Singleton
        System.out.println(ConsoleColors.RED + "EXEMPLO SINGLETON" + ConsoleColors.RESET + " =");
        RunSingleton();

        // 2. Strategy
        System.out.println(ConsoleColors.GREEN + "EXEMPLO STRATEGY" + ConsoleColors.RESET + " =");
        RunStrategy();

        // 3. FactoryMethod
        System.out.println(ConsoleColors.YELLOW + "EXEMPLO FACTORY METHOD" + ConsoleColors.RESET + " =");
        RunFactoryMethod("foto.bmp");
        RunFactoryMethod("foto.jpg");

        // 4. Decorator
        System.out.println(ConsoleColors.BLUE + "EXEMPLO DECORATOR" + ConsoleColors.RESET + " =");
        RunDecorator();

        // 5. Chain
        System.out.println(ConsoleColors.CYAN + "EXEMPLO CHAIN" + ConsoleColors.RESET + " =");
        RunChain();

        // 6. Command
        RunCommand();

        // 7. Observer
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "EXEMPLO OBSERVER" + ConsoleColors.RESET + " =");
        RunObserver();

        // 8. Template Method
        System.out.println(ConsoleColors.RED_BOLD + "EXEMPLO TEMPLATE METHOD" + ConsoleColors.RESET + " =");
        RunTemplateMethod();


        //11. Abstract Factory
        System.out.println(ConsoleColors.PURPLE + "EXEMPLO ABSTRACT FACTORY" + ConsoleColors.RESET + " =");
        RunAbstractFactory();

    }

    private static void RunSingleton(){
        Logger logger1 = Logger.getInstance();
        logger1.setAtivo(true);
        logger1.log("Primeira mensagem");

        Logger logger2 = Logger.getInstance();
        logger2.log("Segunda mensagem");

    }

    public static void RunStrategy(){
        StrategyContext ctx = new StrategyContext();

        ctx.setLoggerStrategy(new LoggerEventViewer());

        ctx.CreateLog("Usando EVENTVIEWER");
    }

    public static void RunFactoryMethod(String image){
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

    public static void RunDecorator(){
        IFrozenItem frozen = new FrozenBase("yogurte de frutas", 15);
        frozen = new Topo("castanha",8,frozen);
        frozen = new Topo("frutas cristalizadas",6,frozen);
        frozen = new Cobertura("chocolate", 5, frozen);
        System.out.println(frozen.getNome());
        System.out.println(frozen.getPreco());

    }

    public static  void RunChain(){
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

    public static void RunCommand(){
        System.out.println("...");
    }

    public static void RunObserver(){
        Alarme ast = new Alarme();

        new PoliciaObserver(ast);
        new SeguroObserver(ast);

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            System.out.println("\nSimule o evento");
            ast.setState(scan.nextInt());
        }

    }

    public static void RunTemplateMethod(){
        TransformaStringTemplate mai = new TransformaMaiuscula();
        mai.imprimeString();

        TransformaStringTemplate min = new TransformaMinuscula();
        min.imprimeString();


        TransformaStringTemplate inverte = new TransformaInverte();
        inverte.imprimeString();

        TransformaStringTemplate duplica = new TransformaDuplicacao();
        duplica.imprimeString();
    }

    public static void RunAbstractFactory() throws ParseException {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com uma data: ");
        String dtRecebida = ler.next();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = df.parse(dtRecebida);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

        PizzaioloFactory pizzaiolo = null;

        if (diaDaSemana == 1) {
            pizzaiolo = new PizzaioloDom();
        } else if (diaDaSemana == 2 || diaDaSemana == 4 || diaDaSemana == 6) {
            pizzaiolo = new PizzaioloSegQuaSex();
        } else {
            pizzaiolo = new PizzaioloTerQuiSab();
        }

        System.out.println(pizzaiolo.criarPizza().montaPizza());

    }

}
