package com.uece.br;

public class VisualizadorJpg extends FactoryVisualizador {

    @Override
    public IVisualizador ExibeImagem(String nomeImagem) {
        return new ImagemJpg();
    }
}
