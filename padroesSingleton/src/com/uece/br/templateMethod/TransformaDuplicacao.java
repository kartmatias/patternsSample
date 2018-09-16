package com.uece.br.templateMethod;

public class TransformaDuplicacao extends TransformaStringTemplate {

    @Override
    public String transformaString(String palavra) {

        return palavra + palavra;
    }

}