package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import steam.*;

public class PublisherSection {

    Platform steam = App.steam;
    Publisher publisher = (Publisher) steam.getUser(App.currentUser);

    @FXML
    private TextField name;

    @FXML
    private TextField description;

    @FXML
    private TextField price;

    @FXML
    private Label user;

    @FXML
    private Label errors;
    
    @FXML
    protected void initialize(){
        user.setText(publisher.getUsername());
    }

    @FXML
    protected void logOut() throws IOException {
        App.setRoot("login");
    }

    @FXML
    protected void addGame(){
        if (!name.getText().equals("") && !description.getText().equals("") && !price.getText().equals("")){
            steam.addGame(new Game(name.getText(),description.getText(),publisher.getUsername(),Integer.parseInt(price.getText())));
        }else{
            errors.setText("Error: one field is empty");
        }
    }

}