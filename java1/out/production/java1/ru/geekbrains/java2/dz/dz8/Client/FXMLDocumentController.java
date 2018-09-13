/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.java2.dz_2.dz8.Client;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {
    
    private boolean authorized;
    
    public void setAthorized(boolean authorized)
    {
        this.authorized = authorized;
        if(authorized)//���� ������������
        {
          authPanel.setVisible(false);
          authPanel.setManaged(false);
          msgPanel.setVisible(true);
          msgPanel.setManaged(true);
        }
        else
        {
          authPanel.setVisible(true);
          authPanel.setManaged(true);
          msgPanel.setVisible(false);
          msgPanel.setManaged(false);
        }
    }
    
    private Socket socket;     //����� �������� � ��������
    
    private DataInputStream  in; //����� �����, ������������ UTF-���������
    private DataOutputStream out;//����� ������, ������������ UTF-���������
    
    @FXML
    private Button sendButton, connectBtn;
    
    @FXML
    private TextArea TextArea;
    
    @FXML
    private TextField TextField, loginField;
   
    @FXML
    private PasswordField passwordField;
    
    @FXML
    HBox authPanel, msgPanel;
    
    @FXML
    AnchorPane MainAnchorPane;
    
    
    
    public void sendMsg() {//������� ��������� �� ������
       
        try 
        {
            String str = TextField.getText();
            out.writeUTF(str);//��������� ����� �� ������
            TextField.clear();
            TextField.requestFocus();//����� ����� �� ���� ����� ���������
        } 
        catch (IOException ex) 
        {
            ex.getStackTrace();
        }
       
    }
    
    public void sendMsg(String msg) {//������� ��������� �� ������
       
        try 
        {
            out.writeUTF(msg);//��������� ����� �� ������
        } 
        catch (IOException ex) 
        {
            ex.getStackTrace();
        }
    }
    
    public void sendAuth() {//������� ������ �� ����������� � ������� �������
      
        connect();
        sendMsg("/auth " + loginField.getText() + " " + passwordField.getText());
        loginField.clear();
        passwordField.clear();
    }
    
    public void connect()
    {
       if(socket==null || socket.isClosed())//����� ������������, ���� ����� null ��� ������!
       {
        try
        {
          //��� ���� ��� ������ � ����:
          socket = new Socket("localhost", 12345);
          in  = new DataInputStream(socket.getInputStream());
          out = new DataOutputStream(socket.getOutputStream());
          
          new Thread(new Runnable(){
          
          @Override 
          public void run()
          {
                 try {
                        while(true)
                        {
                            System.out.println("� ����� �����������");    
                         
                            String str = in.readUTF();
                                if(str.equals("/authok"))
                                {
                                    setAthorized(true);//��������������
                                    break;
                                }
                        }
                        while(true)
                        {
                                String str = in.readUTF();
                                TextArea.appendText(str);
                                TextArea.appendText("\n");
                        }
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
                 finally//����������� �������
                         {
                            try
                            {
                                in.close();
                                //out.close();   //� ��������� ���� try - catch
                                //socket.close();//� ��������� ���� try - catch
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            try
                            {
                               out.close();
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            try
                            {
                                socket.close();
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            
                            setAthorized(false);//�� ������������ ��� ������� ����������
                            
                         }//finally
          }
          }).start();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
       }//if
    }//public void connect()
    
    
    @Override//����� ����������� ��� ������� ����������
    public void initialize(URL url, ResourceBundle rb) {
        //URL              - ������ � ��������� *.fxml
        //ResourceBundle   - ������ � ��������, ����������� � jar, ���� ��� ����
        setAthorized(false);
        
            Platform.runLater(() -> {
                
                ((Stage)MainAnchorPane.getScene().getWindow()).setOnCloseRequest(new EventHandler<WindowEvent>(){
                    
                    @Override
                    public void handle(WindowEvent t)//����� ��������� ��, ��� ���������� ��� �������� ����������
                    {
                        sendMsg("/end");
                        Platform.exit();
                        System.exit(0);
                    }
                });
        } //run
        );// Platform.runLater 
            
    }//public void initialize    
    
}//public class FXMLDocumentController
