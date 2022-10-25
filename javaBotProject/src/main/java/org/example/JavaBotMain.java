package org.example;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class JavaBotMain {
    public static void main(String[] args) {

        try {
            TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
            botApi.registerBot(new JavaBot());
        }catch(TelegramApiException e){
            System.out.println("TelegramApiException Catched");
            e.printStackTrace();
        }
    }
}