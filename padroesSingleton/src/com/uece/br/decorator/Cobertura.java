package com.uece.br.decorator;

public class Cobertura extends Extra{

    public Cobertura(String nome, double preco, IFrozenItem frozen){
        super(nome, preco, frozen);
    }

    @Override
    public double getPreco(){
        return this.preco + frozen.getPreco();
    }

    @Override
    public String getNome() {
        return frozen.getNome()+" com cobertura de "+this.nome;
    }

}
