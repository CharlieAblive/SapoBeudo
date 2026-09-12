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

    }
}