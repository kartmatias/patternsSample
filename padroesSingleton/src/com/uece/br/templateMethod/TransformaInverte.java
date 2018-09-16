package com.uece.br.templateMethod;

public class TransformaInverte extends TransformaStringTemplate{

    @Override
    public String transformaString(String palavra) {

        String  invertida = new StringBuffer(palavra).reverse().toString();
        return invertida;
    }

}