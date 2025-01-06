package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

import steam.*;

public class PlayerSection {

    private static Platform steam = App.steam;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }
}