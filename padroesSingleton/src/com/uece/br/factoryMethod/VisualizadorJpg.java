package com.uece.br.factoryMethod;

public class VisualizadorJpg implements IVisualizador {
    private DecodedImage decodedImage;

    public VisualizadorJpg(String image){
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}
