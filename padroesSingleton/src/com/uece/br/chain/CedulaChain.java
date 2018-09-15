package com.uece.br.chain;

public abstract class CedulaChain {
    protected  CedulaChain next;
    protected IdCedulas cedula;

    public CedulaChain(IdCedulas id){
        next = null;
        cedula = id;
    }

    public void setNext(CedulaChain forma) {
        if (next == null){
            next = forma;
        } else {
            next.setNext(forma);
        }
    }

    public void pagamento(IdCedulas id) throws Exception{
        if (cedula == id){
            realizaPagamento();
        } else {
            if (next == null){
                throw  new Exception("Cedula inexistente");
            }
            next.pagamento(id);
        }
    }

    protected abstract void realizaPagamento();
}
