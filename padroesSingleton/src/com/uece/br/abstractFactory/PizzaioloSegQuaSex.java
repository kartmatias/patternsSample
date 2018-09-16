package com.uece.br.abstractFactory;

public class PizzaioloSegQuaSex implements PizzaioloFactory {

    @Override
    public Pizza criarPizza() {

        return new PizzaCalabresa();
    }


}