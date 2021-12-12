package ru.geekbrains.java2.dz_2.dz7.RunnableRealize.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Socket socket;     //чтобы общаться с серваком

    private DataInputStream  in; //поток ввода, используется UTF-кодировка
    private DataOutputStream out;//поток вывода, используется UTF-кодировка
    private boolean inChat; //состояние клиента - в чате

    @FXML
    private HBox vhodBox, msgBox;

    @FXML
    private VBox chatBox;

    @FXML
    private Label nameClient, chatNameClient;

    @FXML
    private TextField vNameClient, TextField;

    @FXML
    private Button btnChat, sendButton;

    @FXML
    private TextArea TextArea;

    @FXML // Вход в чат (inChat - false) - выход из чата (inChat - true)
    private void addChat(ActionEvent event) {
        if (!inChat) { // вход в чат
            if (vNameClient.getText().isEmpty()) { //если нет имени, то намек на его ввод
                vNameClient.requestFocus();
            } else {
                // установка имени в окне чата
                String nc = vNameClient.getText();
                chatNameClient.setText(nc);
                // отправка имени на сервер
                try {
                    out.writeUTF("/name");
                    out.writeUTF(nc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // перестройка окна в рабочий режим чата
                vNameClient.clear();
                nameClient.setVisible(false);
                vNameClient.setVisible(false);
                btnChat.setText("Выход из чата");
                inChat = true;
                msgBox.setVisible(true);
                chatBox.setVisible(true);
            }
        } else { // выход из чата (почему-то завершается выбросом исключения - до причин и принятия решения не добрался)
            // перестройка окна под вид входа в чат
            TextField.clear();
            TextArea.clear();
            nameClient.setVisible(true);
            vNameClient.setVisible(true);
            btnChat.setText("Войти в чат");
            inChat = false;
            msgBox.setVisible(false);
            chatBox.setVisible(false);
            // отправка на сервер инфы о завершении чата
            String str = "/end";
            try {
                out.writeUTF(str);//сообщение пошло на сервер
            } catch (IOException ex) {
                ex.getStackTrace();
            }
            // попытка позакрывать потоки и сокет (по ходу не удачная)
            try {
                in.close();
            } catch (SocketException e) {
                System.out.println("Входящий поток закрыт.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (SocketException e) {
                System.out.println("Исходящий поток закрыт.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (SocketException e) {
                System.out.println("Сокет закрыт.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0); // неудачная попытка закрыть окно чата
        }
    }

    // тут без измений...
    @FXML
    private void sendMsg(ActionEvent event) {

        String str = TextField.getText();

        try
        {
            out.writeUTF(str);//сообщение пошло на сервер
            TextField.clear();
            TextField.requestFocus();//фокус ввода на поле ввода сообщения
        }
        catch (IOException ex)
        {
            ex.getStackTrace();
        }
    }

    @Override//будет выполняться при запуске приложения
    public void initialize(URL url, ResourceBundle rb) {
        //URL              - доступ к удалённому *.fxml
        //ResourceBundle   - доступ к ресурсам, упакованным в jar, если они есть
        try
        {
            //Три кита при работе в сети:
            socket = new Socket("localhost", 12345);
            in  = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            //получить эхо-ответ от сервера
           /*Так делать нельзя. Мы никогда не выйдем из цикла.
             Поток исполнения будет заблокирован методом in.readUTF()
               while(true)
               {
                  String str = in.readUTF();
                  TextArea.appendText(str + "\n");
               }
           */
            //Так сообщения от сервера будут обрабатываться в параллельном потоке
            //сразу после инициализации приложения.
            //Не забывайте вызвать метод start() для new Thread!
            new Thread(() -> {
                try {

                    while(true)
                    {
                        String str = in.readUTF();
                        //System.out.println(str);
                        TextArea.appendText(str + "\n");
                    }
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }).start();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
