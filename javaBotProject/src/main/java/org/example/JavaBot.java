package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
            int caso=0;

            String messaggioRicevuto= update.getMessage().getText();
            System.out.println(messaggioRicevuto);
            String chatId= update.getMessage().getChatId().toString();
            System.out.println(chatId);

            SendMessage sendMessage=new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());

            if(messaggioRicevuto.equals("/start")){
                caso=1;
            }
                switch (caso){
                    case 1:                                       //caso /start
                            sendMessage.setText("Benvenuto su JavaBot! Questo è un piccolo EchoBot, ossia ripete i messaggi ricevuti.");
                            try{
                                execute(sendMessage);
                            }catch(TelegramApiException e){ e.printStackTrace();}
                            sendMessage.setText("Scrivi qualsiasi cosa...");
                            try{
                                execute(sendMessage);
                            }catch(TelegramApiException e){ e.printStackTrace();}   break;
                    default:
                            sendMessage.setText(messaggioRicevuto);
                            try{
                               execute(sendMessage);
                            }catch(TelegramApiException e){ e.printStackTrace();}  break;
                }
        }
    }

    @Override
    public String getBotUsername(){
        return this.Username;
    }
}
