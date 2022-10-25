package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class JavaBot extends TelegramLongPollingBot {
    private final String Token="5699816726:AAEzmF2NhHg4CwhYRuc7XjPgLahx0Af8-Ig";
    private final String Username="java_alpha_bot";
    @Override
    public String getBotToken(){
        return this.Token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()&&update.getMessage().hasText()){
            String messaggio= update.getMessage().getText();
            System.out.println(messaggio);
            
        }
    }

    @Override
    public String getBotUsername(){
        return this.Username;
    }
}
