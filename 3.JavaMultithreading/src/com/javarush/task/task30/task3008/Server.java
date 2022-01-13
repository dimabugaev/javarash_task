package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {

        ConsoleHelper.writeMessage("введите порт сервера:");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("сервер запущен...");


        try{
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }catch (Exception e){
            ConsoleHelper.writeMessage("ошибка соединения..." + e.getMessage());
            serverSocket.close();
        }

        
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            if (socketAddress != null)
                ConsoleHelper.writeMessage("соединение установлено: "+ socketAddress);
            else
                return;
            //getRemoteSocketAddress()
            try(Connection connection = new Connection(socket);){
                //SocketAddress socketAddress = connection.getRemoteSocketAddress();

                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                ConsoleHelper.writeMessage("соединение установлено: "+ socketAddress);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

            } catch (IOException e) {
                //e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message nameRequest = new Message(MessageType.NAME_REQUEST);

            while (true) {
                connection.send(nameRequest);
                Message answer = connection.receive();
                if (answer.getType() != MessageType.USER_NAME) continue;

                String recivedName = answer.getData();
                if (recivedName != null && !recivedName.equals("")){
                    if (!connectionMap.containsKey(recivedName)) {
                        connectionMap.put(recivedName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return recivedName;
                    }
                }

            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (String user:
                    connectionMap.keySet()) {
                if (user.equals(userName))
                    continue;

                connection.send(new Message(MessageType.USER_ADDED, user));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message answer = connection.receive();
                if (answer.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + answer.getData()));
                }else{
                    ConsoleHelper.writeMessage("ошибка - сообщение не является текстом");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connection:
                connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            }catch (IOException e){

            }
        }
    }
}
