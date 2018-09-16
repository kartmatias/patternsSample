package com.uece.br.abstractFactory;

public class PizzaioloDom implements PizzaioloFactory{

    @Override
    public Pizza criarPizza() {
        return new PizzaDomingo();
    }

}