/*
 */
package ru.geekbrains.java2.dz_2.dz4.var2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        text.setMaxSize(200, 250);

        // Надпись для списка фамилий абонентов
        Label lbl = new Label("Фамилия абонента:");
        lbl.setLayoutX(10);
        lbl.setLayoutY(10);

        // Создаем КомбоБокс и Заполняем его фамилиями из справочника
        ObservableList<String> cmbl = FXCollections.observableArrayList(tf.getabons());

        ComboBox cmb = new ComboBox();
        cmb.setLayoutX(10);
        cmb.setLayoutY(30);
        cmb.setMinWidth(120);
        cmb.setMaxWidth(200);
        cmb.setItems(cmbl);
        cmb.getSelectionModel().selectFirst();
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
        }) ;


        // кнопка добавления абонента
        Button btnAdd = new Button("Добавить");
        btnAdd.setLayoutX(10);
        btnAdd.setLayoutY(70);

        Button btnOkAdd = new Button("ОК");
        Button btnCancelAdd = new Button("Отмена");
        TextField fio = new TextField();
        TextField telN = new TextField();

        // группировка элементов для сцены
        Group group = new Group(cmb, text, lbl, btnAdd);  // группируем весь реквизит для сцены

        // обработка Добавления в телефонный справочник
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fio.clear();
                telN.clear();
                fio.setLayoutX(10);
                fio.setLayoutY(100);
                telN.setLayoutX(10);
                telN.setLayoutY(130);
                btnOkAdd.setLayoutX(10);
                btnOkAdd.setLayoutY(160);
                btnCancelAdd.setLayoutX(60);
                btnCancelAdd.setLayoutY(160);
                group.getChildren().addAll(fio, telN, btnOkAdd, btnCancelAdd);
            }
        });

        // обработка Подтверждения добавления в телефонный справочник
        btnOkAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!fio.getText().isEmpty()&!telN.getText().isEmpty()) {
                    tf.add(fio.getText(), telN.getText());
//                    cmb.getItems().clear();
                    cmb.getItems().removeAll(cmbl); // ??? почему-то эта строка вызывает исключение NullPointerException
                    cmbl.addAll(tf.getabons());
                    cmb.setItems(cmbl);
                    cmb.getSelectionModel().selectFirst();
                };
                group.getChildren().removeAll(fio, telN, btnOkAdd, btnCancelAdd);
            }
        });

        // обработка Отмены добавления в телефонный справочник
        btnCancelAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getChildren().removeAll(fio, telN, btnOkAdd, btnCancelAdd);
            }
        });

        // Оформляем сцену и подмостки
        Scene scene = new Scene(group); // создание сцены
        stage.setScene(scene);          // установка сцены для объекта Stage
        stage.setTitle("Телефонный справочник");
        stage.setWidth(400);
        stage.setHeight(250);

        // Шоу начинается
        stage.show();
    }
}
