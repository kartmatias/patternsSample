package com.uece.br.chain;

public class CedulaCinco extends CedulaChain {

    public CedulaCinco(){
        super(IdCedulas.cinco);
    }

    @Override
    protected void realizaPagamento() {
        System.out.println("Pago R$ 5,00");
    }
}
