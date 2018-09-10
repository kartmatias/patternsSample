package com.uece.br;

public class VisualizadorBmp extends FactoryVisualizador {

    @Override
    public IVisualizador ExibeImagem(String nomeImagem) {
        return new ImagemBmp();
    }

}
