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
            if (publisher.isSelected()){
                Platform.addUser(new Publisher(username.getText(),password.getText()));
                //App.setRoot("publisher");
            }else{
                Platform.addUser(new Player(username.getText(),password.getText()));
                //App.setRoot("player");
            }
        }else{
            errors.setText("error, username or password unavailable");
        }
    }

    protected void login() throws IOException {
        if (User.usernameValidator(username.getText()) && User.passwordValidator(password.getText())) {
            if (Platform.validateUser(new User(username.getText(), password.getText()))) {
                if(new User(username.getText(), password.getText()) instanceof Publisher){
                    //App.setRoot("publisher");
                }else{
                    //App.setRoot("player");
                }
            } else {
                errors.setText("Invalid username or password.");
            }
        } else {
            errors.setText("Error: username or password unavailable");
        }
    }
}
