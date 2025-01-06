package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

import steam.*;

public class Player {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }
}