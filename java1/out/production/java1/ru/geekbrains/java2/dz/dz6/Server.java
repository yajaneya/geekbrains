package ru.geekbrains.java2.dz_2.dz6;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main (String[] args) {

        // объявляем переменные для нужных нам объектов
        ServerSocket serv = null;
        Socket sock = null;
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            // создаем и устанавливаем сокет, ждем подключения
            serv = new ServerSocket(9121);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");

            // подключаем прослушку входящих сообщений от клиента
            new ServerListen(sock);

            // настраиваем прием сообщений для отправки клиенту с сервера
            sc = new Scanner(System.in);
            pw = new PrintWriter(sock.getOutputStream());

            // получаем сообщения и отправляем их клиенту
            while (true) {
                String mess = sc.nextLine();
                if (mess.equalsIgnoreCase("end")) break;
                pw.println(mess);
                pw.flush();
            }

        // это соломка, чтоб серверу мягче было падать
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            // ну и в завершение
            try {
                serv.close();  // закрываем двери
                System.exit(1); // и ложимся спать
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
