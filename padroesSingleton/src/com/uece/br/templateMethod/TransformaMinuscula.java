package com.uece.br.templateMethod;

public class TransformaMinuscula extends TransformaStringTemplate {

    @Override
    public String transformaString(String palavra) {

        return palavra.toLowerCase();
    }

}
