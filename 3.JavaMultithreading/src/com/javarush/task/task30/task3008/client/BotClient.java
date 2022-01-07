package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client{

    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%.0f", Math.random()*100);
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] datamessage = message.split(": ");
            if (datamessage.length == 2){
                if (datamessage[1].equals("дата")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("день")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("месяц")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("год")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("время")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("час")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("минуты")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
                else if (datamessage[1].equals("секунды")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s");
                    sendTextMessage(String.format("Информация для %s: %s", datamessage[0], simpleDateFormat.format(new Date())));
                }
            }
        }
    }
}
