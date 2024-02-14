package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyBot("6983207014:AAG44102eY_k_1Q8-NQqHwsuQaSzIMdtPkQ"));
        }catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}