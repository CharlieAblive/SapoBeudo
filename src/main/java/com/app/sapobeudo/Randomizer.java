package com.app.sapobeudo;

import java.util.List;
import java.util.Random;

public class Randomizer {


    public Itens getRandomEscolha(List<Itens> tudo){
        Random random = new Random();

        if (tudo.isEmpty()) {
            System.out.println("Não tem nada aqui :(");
            return null; // Retorna nulo se não houver nada na lista
        } else {
            // Sorteia e já retorna o item diretamente
            return tudo.get(random.nextInt(tudo.size()));
        }
    }
}