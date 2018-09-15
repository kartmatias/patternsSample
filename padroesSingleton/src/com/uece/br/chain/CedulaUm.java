package com.uece.br.chain;

public class CedulaUm extends CedulaChain {

    public CedulaUm(){
        super(IdCedulas.um);
    }

    @Override
    protected void realizaPagamento() {
        System.out.println("Pago R$ 1,00");
    }
}
