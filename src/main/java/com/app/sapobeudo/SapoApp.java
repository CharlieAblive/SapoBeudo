package com.app.sapobeudo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SapoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //VISUAIS
        FXMLLoader fxmlLoader = new FXMLLoader(SapoApp.class.getResource("sapo-visuais.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Sapo Beudo!");
        stage.setScene(scene);
        stage.show();

        //LISTA DENTRO DE LISTA DENTRO DE LISTA DENTRO DE LISTA DENTRO DE..............
        List<Desafio> desafios = new ArrayList<>();
        List<Pergunta> perguntas = new ArrayList<>();
        List<Itens> tudo = new ArrayList<>();
        tudo.addAll(desafios);
        tudo.addAll(perguntas);
        InputStream inputDesafio = SapoApp.class.getResourceAsStream("desafios.txt");
        InputStream inputPergunta = SapoApp.class.getResourceAsStream("perguntas.txt");

        //bug handler
        if (inputDesafio == null || inputPergunta == null) {
            throw new IOException("desafios.txt/perguntas.txt não foi encontrado.");
        }

        //LENDO desafios.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputDesafio))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split("\\|", -1);
                //bug handler
                if (parts.length != 2) {
                    System.out.println("Pulando linha inválida: " + line);
                    continue;
                }
                String textoDesafio = parts[0];
                String comentarioDesafio = parts[1];
                desafios.add(new Desafio(textoDesafio, comentarioDesafio));
            }
        }
        //LENDO perguntas.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputPergunta))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split("\\|", -1);
                //bug handler
                if (parts.length != 2) {
                    System.out.println("Pulando linha inválida: " + line);
                    continue;
                }
                String textoPergunta = parts[0];
                String comentarioPergunta = parts[1];
                perguntas.add(new Pergunta(textoPergunta, comentarioPergunta));
            }
        }
        //RANDOMIZER
        Random random = new Random();
        if (tudo.isEmpty()) {
            System.out.println("Não tem nada aqui :(");
        } else {
            Itens escolhaFinal =
                    tudo.get(random.nextInt(tudo.size()));
        }
    }
}