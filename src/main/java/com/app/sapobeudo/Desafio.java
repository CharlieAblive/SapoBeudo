package com.app.sapobeudo;

public class Desafio implements Itens {

    private final String texto;
    private final String comentario;

    public Desafio(String texto, String comentario){
        this.texto = texto;
        this.comentario = comentario;
    }

    @Override
    public String getTexto(){
        return texto;
    }

    @Override
    public String getComentario(){
        return comentario;
    }


}
