/*
 */
package ru.geekbrains.java2.dz_2.dz4.var1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class MainClass extends Application {
    
     public static void main(String[] args) {
        Application.launch(args);
    }
        
    @Override
    public void start(Stage stage) {
         
        // Создаем телефонный справочник
        TelefonSprav tf = new TelefonSprav();
        tf.add("Иванов", "+79784532343");
        tf.add("Петров", "+79784358765");
        tf.add("Иванов", "+79789807646");
        tf.add("Карпов", "+79789345646");
        tf.add("Лодкина", "+79789805432");
        tf.add("Петрова", "+79789434425");
        tf.add("Лодкина", "+79784542235");
        tf.add("Иванов", "+79789834532");

        // Создаем и оформляем поле для списка телефонов
        TextArea text = new TextArea("Номера телефонов:");
        text.setLayoutX(200);   // установка положения надписи по оси X
        text.setLayoutY(0);   // установка положения надписи по оси Y
        text.setMaxSize(200, 200);

        // Создаем КомбоБокс и Заполняем его фамилиями из справочника
        ObservableList<String > cmbl = FXCollections.observableArrayList(tf.getabons());

        Label lbl = new Label("Фамилия абонента:");
        lbl.setLayoutX(0);
        lbl.setLayoutY(0);

        ComboBox cmb = new ComboBox();
        cmb.setLayoutY(20);
        cmb.setMinWidth(120);
        cmb.setMaxWidth(200);
        cmb.setItems(cmbl);
        cmb.setVisibleRowCount(5);

        // Ставим прослушку на выбор фамилии
        // При выборе фамилии в текстовую область выводим все номера телефонов из справочника
        // для выбранной фамилии
        cmb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String abon = cmb.getValue().toString();
                text.setText("Номера телефонов:\n"+tf.gettel(abon));
            }
        });

        Group group = new Group(cmb, text, lbl);  // группируем весь реквизит для сцены

        // Оформляем сцену и подмостки
        Scene scene = new Scene(group); // создание сцены
        stage.setScene(scene);          // установка сцены для объекта Stage
        stage.setTitle("Телефонный справочник");
        stage.setWidth(400);
        stage.setHeight(200);

        // Шоу начинается
        stage.show();
    }
}
