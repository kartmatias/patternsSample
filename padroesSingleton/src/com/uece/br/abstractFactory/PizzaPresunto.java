package com.uece.br.abstractFactory;

public class PizzaPresunto implements Pizza {

    @Override
    public String montaPizza() {
        String ingredientes = "queijo + presunto + tomate";
        return ingredientes;
    }

}
