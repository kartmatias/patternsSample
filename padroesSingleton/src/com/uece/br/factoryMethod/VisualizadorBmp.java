package com.uece.br.factoryMethod;

public class VisualizadorBmp implements IVisualizador {
    private DecodedImage decodedImage;

    public VisualizadorBmp(String image){
        decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodeImage(){
        return decodedImage;
    }

}
