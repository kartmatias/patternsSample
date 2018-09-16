package com.uece.br.abstractFactory;

public class PizzaioloTerQuiSab implements PizzaioloFactory {

    @Override
    public Pizza criarPizza() {

        return new PizzaPresunto();
    }

}