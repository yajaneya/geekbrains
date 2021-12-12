package ru.geekbrains.java2.dz_2.dz7.ThreadRealize.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// без существенных изменений
public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDoc.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Чат, однако!");
        stage.show();
    }


    public static void main (String[] args) {
        launch(args);
    }
}
