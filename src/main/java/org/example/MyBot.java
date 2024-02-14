package org.example;

import org.example.service.ButtonService;
import org.example.service.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot(String botToken){
        super(botToken);
    }
   private final ButtonService buttonService = new ButtonService();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        User user  = userService.get(chatId);
        if (update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();

            if (text.equals("/start")){
                if(userService.get(chatId) == null){
                    userService.create(
                            new User(
                                    chatId,
                                    update.getMessage().getFrom().getFirstName(),
                                    update.getMessage().getFrom().getUserName(),
                                    BotState.START
                            )
                    );
                }
                SendMessage message = new SendMessage();
                message.setText("Tilni tanlang");
                message.setReplyMarkup(buttonService.setLang());
                message.setChatId(chatId);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else {
                switch (user.getState()){
                    case MAIN_MENU -> {
                        user.setState(BotState.MAIN_MENU);
                        userService.update(user, chatId);
                        SendMessage message1 = new SendMessage();
                        message1.setText("Quyidagi menyulardan birini tanlang");
                        message1.setReplyMarkup(buttonService.mainMenuUz());
                        message1.setChatId(chatId);

                        try {
                            execute(message1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case REGISTER -> {

                    }
                    case PDF_BOOKS -> {

                    }
                    case START -> {
                        SendMessage message = new SendMessage();
                        message.setText("Tilni tanlang");
                        message.setReplyMarkup(buttonService.setLang());
                        message.setChatId(chatId);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            long callBackId = update.getCallbackQuery().getMessage().getChatId();
            if (data.equals("uz")){
                user.setState(BotState.MAIN_MENU);
                EditMessageText text = new EditMessageText();
                text.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                text.setChatId(callBackId);
                text.setText("Quyidagi menyulardan birini tanlang");
                try {
                    execute(text);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    @Override
    public String getBotUsername() {
        return "https://t.me/pdp_practiceBot";
    }
}
