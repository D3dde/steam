package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import steam.*;

public class Login {

    private static Platform steam = App.steam;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label errors;

    @FXML
    private CheckBox publisher;

    @FXML
    protected void signUp() throws IOException {
        if (User.passwordValidator(password.getText()) && User.usernameValidator(username.getText())){
            if (Platform.exist(username.getText())) {
                errors.setText("Error: this user alredy exist");
            }else{
                if (publisher.isSelected()){
                    steam.addUser(new Publisher(username.getText(),password.getText()));
                    App.currentUser=steam.getIndex(username.getText());
                    App.setRoot("publisher");
                }else{
                    steam.addUser(new Player(username.getText(),password.getText()));
                    App.currentUser=steam.getIndex(username.getText());
                    App.setRoot("player");
                }
            }
        }else{
            errors.setText("Error: username or password too simple");
        }
    }
    @FXML
    protected void login() throws IOException {
        if (User.usernameValidator(username.getText()) && User.passwordValidator(password.getText())) {
            if (Platform.validateUser(new User(username.getText(), password.getText()))) {
                if(steam.getUser(steam.getIndex(username.getText())) instanceof Publisher){
                    App.currentUser=steam.getIndex(username.getText());
                    System.out.println("++++++++++++++++++++++++++++++++++");
                    App.setRoot("publisher");
                }else{
                    App.currentUser=steam.getIndex(username.getText());
                    System.out.println("------------------------------------");
                    App.setRoot("player");
                }
            } else {
                errors.setText("Error: this user does not exist");
            }
        } else {
            errors.setText("Error: username or password unavailable");
        }
    }
}
