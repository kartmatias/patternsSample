package com.uece.br.templateMethod;

import java.util.Scanner;

public abstract class TransformaStringTemplate {
    public abstract String transformaString(String palavra);

    private String leString() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com uma palavra: ");
        return  ler.next();

    }

    public void imprimeString() {

        String lida = leString();
        String transformada = transformaString(lida);
        System.out.println(transformada);
    }
}