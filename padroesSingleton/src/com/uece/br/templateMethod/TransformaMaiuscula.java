package com.uece.br.templateMethod;

public class TransformaMaiuscula extends TransformaStringTemplate {

    @Override
    public String transformaString(String palavra) {

        return palavra.toUpperCase();

    }

}