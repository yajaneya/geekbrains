package ru.geekbrains.java2.dz_2.dz8.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientHandler {
    
    //Служебный класс, которому сервер передаст сокет
    //По сокету будет происходить общение с подключившимся клиентом
   
    private MServer server; //ссылка на сервер для клиента
    private Socket socket;
    private DataInputStream  in; //поток ввода, используется UTF-кодировка
    private DataOutputStream out;//поток вывода, используется UTF-кодировка
    private String nickname;
    
    public ClientHandler(MServer server, Socket socket)
    {
       try{
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

                 //Множество клиентов потребует множество потоков обработки
                 new Thread(()-> { 

                 //Попробуйте сделать то же самое, но через реализацию Runnable()!    
                         try
                         {
                            boolean authOK = false;
                            long t = System.currentTimeMillis();
                            long timeout = 120000; //устанавливаем таймаут для авторизации
                            while(timeout >= 0)//цикл авторизации - пока не закончился таймаут
                            {
                                /*
                                /auth login password
                                */
                                timeout=timeout-(System.currentTimeMillis()-t); //уменьшаем таймаут на время, прошедшее за оборот цикла
                                t = System.currentTimeMillis(); //запоминаем текущий момент
                                if (timeout<=0) { //если время вышло - выходим из авторизации
                                    break;
                                }else{//если время не вышло, ставим таймаут сокета по остатку таймаута авторизации
                                    socket.setSoTimeout((int)timeout);
                                }
                                String str="";
                                try {
                                    str = in.readUTF();
                                } catch (SocketTimeoutException e) { // если таймаут прозошел во время ввода
                                        break; //вышли из цикла авторизации - кто не успел, тот опоздал. (
                                }

                                String[] tokens = str.split("\\s");//разбиваем входящее сообщение по частям, считая пробелы разделителями
                                
                                if(tokens[0].equals("/auth"))//от клиента пришёл запрос на авторизацию 
                                {
                                  String nickFromDB = SQLHandler.getNickByLogPass(tokens[1], tokens[2]);

                                  if(nickFromDB != null)
                                  {
                                     sendMsg("/authok");//если клиент авторизовался, послать ему уведомление 
                                     server.add_client(this);
                                     authOK = true;
                                     break;//вышли из цикла авторизации
                                  }

                                }
                            }
                             if (!authOK) System.out.println("Клиент не успел авторизоваться"); //сообщаем, что клиент пытался но не успел авторизоваться

                            while(true & authOK)//цикл общения с клиентом начинается, если была успешной авторизация, иначе, будут освобождены ресурсы
                            {
                                socket.setSoTimeout(0);
                                String str = in.readUTF();//блокирующая операция!!! Читаем то, что пришло от клиента


                                System.out.println("A message from a client: " + str);
                                
                                   if(str.equalsIgnoreCase("/end")) 
                                   {
                                      break;
                                   }
                                
                                server.broadcastMsg(str);//Cервер разослал сообщение String str = in.readUTF() ВСЕМ подключенным клиентам
                                   
                                out.flush();
                            }
                         }
                          catch(IOException ex)
                         {
                            ex.printStackTrace();
                         }
                         finally//освобождаем ресурсы
                         {
                             closeSocket();

                            server.remove_client(this);//Клиент отключился и больше не активен
                            
                         }//finally
                     
                 }).start();
       
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

    private void closeSocket() {
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
    }

}//class ClientHandler
