package com.example;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import steam.*;

public class PlayerSection {

    Platform steam = App.steam;
    Player player = (Player) steam.getUser(App.currentUser);

    @FXML
    private TextArea library;

    @FXML
    private Label errors;

    @FXML
    private ComboBox<String> store;

    @FXML
    private Label user;
    
    @FXML
    protected void initialize(){
        user.setText(player.getUsername());
        ObservableList<String> items = FXCollections.observableArrayList(steam.getGames());
        store.setItems(items);
        library.setText(player.getLibrary());
    }

    @FXML
    protected void logOut() throws IOException {
        App.setRoot("login");
    }

    @FXML
    protected void buyGame(){
        if (store.getValue() == null){
            errors.setText("Error: no item selected");
            System.out.println(store.getValue());
        }else{
            if (steam.getGameIndex(store.getValue()) != -1){
                if (player.buyGame(steam.getGame(steam.getGameIndex(store.getValue())))){
                    errors.setText("Game buoght");
                    reloadLibrary();
                }else{
                    errors.setText("Error: you alredy have this game");
                }
            }
        }
    }

    @FXML
    protected void reloadLibrary(){
        library.setText(player.getLibrary());
    }

}