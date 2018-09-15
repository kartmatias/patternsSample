package com.uece.br.factoryMethod;

public class DecodedImage {
    private String image;

    public DecodedImage(String image){
        this.image = image;
    }

    @Override
    public String toString(){
        return image + ": visualizada";
    }
}

