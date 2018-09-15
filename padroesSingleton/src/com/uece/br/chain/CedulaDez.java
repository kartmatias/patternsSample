package com.uece.br.chain;

public class CedulaDez extends CedulaChain {

    public CedulaDez(){
        super(IdCedulas.dez);
    }

    @Override
    protected void realizaPagamento() {
        System.out.println("Pago R$ 10,00");
    }
}
