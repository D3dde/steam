package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

import steam.*;

public class PublisherSection {

    private static Platform steam = App.steam;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("login");
    }
}