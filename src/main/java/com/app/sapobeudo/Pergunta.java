package com.app.sapobeudo;

public class Pergunta implements Itens{

    private final String texto;
    private final String comentario;

    public Pergunta(String texto, String comentario){
        this.texto = texto;
        this.comentario = comentario;
    }

    public String getTexto(){
        return texto;
    }

    public String getComentario(){
        return comentario;
    }
}
