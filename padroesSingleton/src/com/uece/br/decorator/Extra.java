package com.uece.br.decorator;

public abstract class Extra implements IFrozenItem {

    protected IFrozenItem frozen;
    protected String nome;
    protected  double preco;

    public  Extra(String nome, double preco, IFrozenItem frozen){
        this.nome = nome;
        this.preco = preco;
        this.frozen = frozen;
    }

    public abstract double getPreco();

    public String getNome(){
        return frozen.getNome()+" + "+this.nome;
    }
}
