package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import steam.*;

public class PlayerSection {

    Platform steam = App.steam;
    Player player = (Player) steam.getUser(App.currentUser);

    @FXML
    private Label user;
    
    @FXML
    protected void initialize(){
        user.setText(player.getUsername());
    }

    @FXML
    protected void logOut() throws IOException {
        App.setRoot("login");
    }

}