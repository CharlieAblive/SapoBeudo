package com.app.sapobeudo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SapoController {

    @FXML
    private Label textoExibido;

    @FXML
    private Button botaoTextoPrincipal;

    private final Randomizer randomizer = new Randomizer();

    private final List<Desafio> desafios = new ArrayList<>();
    private final List<Pergunta> perguntas = new ArrayList<>();
    private final List<Itens> tudo = new ArrayList<>();

    @FXML
    public void initialize() {
        try {
            carregarArquivos();

            tudo.addAll(desafios);
            tudo.addAll(perguntas);

        } catch (IOException e) {
            System.err.println("Erro crítico ao carregar os arquivos de perguntas/desafios:");
            e.printStackTrace();
            textoExibido.setText("Erro ao carregar os dados do jogo.");
        }
    }

    private void carregarArquivos() throws IOException {
        InputStream inputDesafio = SapoApp.class.getResourceAsStream("desafios.txt");
        InputStream inputPergunta = SapoApp.class.getResourceAsStream("perguntas.txt");

        // bug handler
        if (inputDesafio == null || inputPergunta == null) {
            throw new IOException("Arquivo desafios.txt ou perguntas.txt não foi encontrado nos recursos.");
        }

        // LENDO desafios.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputDesafio))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] parts = line.split("\\|", -1);
                if (parts.length != 2) {
                    System.out.println("Pulando linha inválida em desafios: " + line);
                    continue;
                }
                desafios.add(new Desafio(parts[0], parts[1]));
            }
        }

        // LENDO perguntas.txt
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputPergunta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] parts = line.split("\\|", -1);
                if (parts.length != 2) {
                    System.out.println("Pulando linha inválida em perguntas: " + line);
                    continue;
                }
                perguntas.add(new Pergunta(parts[0], parts[1]));
            }
        }
    }

    @FXML
    protected void escolher() {
        Itens escolhido = randomizer.getRandomEscolha(tudo);

        if (escolhido != null) {
            textoExibido.setText(escolhido.getTexto());
        } else {
            textoExibido.setText("A lista está vazia!");
        }
    }
}
