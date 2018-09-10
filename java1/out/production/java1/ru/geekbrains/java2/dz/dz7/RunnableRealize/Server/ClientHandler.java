package ru.geekbrains.java2.dz_2.dz7.RunnableRealize.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    
    //Служебный класс, которому сервер передаст сокет
    //По сокету будет происходить общение с подключившимся клиентом
   
    private MServer server; //ссылка на сервер для клиента
    private Socket socket;
    private DataInputStream  in; //поток ввода, используется UTF-кодировка
    private DataOutputStream out;//поток вывода, используется UTF-кодировка
    private String name; // имя клиента
    Thread c; // ссылка на поточный объект
    
    public ClientHandler(MServer server, Socket socket)
    {
       try{
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            c = new Thread(this); // создание поточного объекта
            c.start(); //запуск потока
       }
       catch(IOException ex)
       {
          ex.printStackTrace();
       }
    }//public ClientHandler
    
    //если нужно послать сообщение клиенту
    public void sendMsg(String msg)
    {
       try
       {
         out.writeUTF(msg);//отослать сообщение клиенту
       }
       catch(IOException ex)
       {
         ex.printStackTrace();
       }
    }


    @Override
    public void run() {
        // Через реализацию Runnable()!
        try
        {
            while(true)
            {
                String stro;
                String str = in.readUTF();//блокирующая операция!!! Читаем то, что пришло от клиента

                if(str.equalsIgnoreCase("/name")) //проверка на вход в чат клиента
                {
                    // получение имени клиента и формирование сообщения в чаты о его присоединении
                    name = in.readUTF();
                    stro = "Сервер: " + name + " присоединился к чату!";
                } else {
                    // формирование сообщения клиента в чаты
                    stro = name + ": " + str;
                }

                if(str.equalsIgnoreCase("/end")) //проверка на выход клиента из чата
                {
                    //отправка сообзения о выход из цикла ожидания сообщений
                    System.out.println("Сервер: " + name + " покинул чат.");
                    stro = "Сервер: " + name + " ушол из чату! :(";
                    server.broadcastMsg(stro);
                    out.flush();
                    break;
                }

                System.out.println(stro);
                server.broadcastMsg(stro);//Cервер разослал сообщение String str = in.readUTF() ВСЕМ подключенным клиентам

                out.flush();

                // ответ на приветствие
                if((str.equalsIgnoreCase("привет")|str.equalsIgnoreCase("привет!")))
                {
                    stro = "Сервер: Привет, " + name + "!";
                    out.writeUTF(stro);
                    out.flush();
                    System.out.println(stro);
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally//освобождаем ресурсы
        {
            try
            {
                in.close();
                //out.close();   //в отдельный блок try - catch
                //socket.close();//в отдельный блок try - catch
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

            server.remove_client(this);//Клиент отключился и больше не активен

        }//finally

    }
}//class ClientHandler
