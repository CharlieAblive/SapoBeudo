package com.app.sapobeudo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SapoController {
    @FXML
    private Label titulo;

    @FXML
    protected void onHelloButtonClick() {
        titulo.setText("Sapo Beudo!");


    }
}
