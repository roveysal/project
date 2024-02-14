package org.example.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonService {
    public InlineKeyboardMarkup setLang(){
      InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("\uD83C\uDDFA\uD83C\uDDFFO'zbek tili");
        button.setCallbackData("uz");

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83C\uDDFA\uD83C\uDDF8English");
        button1.setCallbackData("eng");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("\uD83C\uDDF7\uD83C\uDDFAРусский язык");
        button2.setCallbackData("ru");

        row1.add(button);
        row2.add(button1);
        row3.add(button2);

        rowlist.add(row1);
        rowlist.add(row2);
        rowlist.add(row3);

        markup.setKeyboard(rowlist);
        return markup;
    }

    public ReplyKeyboardMarkup mainMenuUz(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("Ro'yxatdan o'tish\uD83E\uDDFE");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("PDF kitoblar\uD83D\uDCDA");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Quiz testlar to'plami\uD83D\uDD87");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Anime multfilmlar\uD83C\uDFA5");

        row.add(button);
        row1.add(button1);
        row2.add(button2);
        row3.add(button3);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);

        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }
    public ReplyKeyboardMarkup pdfBooksUz(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("Lug'at\uD83D\uDCD5");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Grammatika\uD83D\uDCD7");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("IELTS materiallari\uD83D\uDCD9");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Badiiy adabiyotlar\uD83D\uDCDA");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Orqaga\uD83D\uDD19");

        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        row.add(button);
        row.add(button1);
        row1.add(button2);
        row2.add(button3);
        row3.add(button4);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);

        markup.setKeyboard(rowList);
        markup.setSelective(true);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);

        return markup;
    }
    public ReplyKeyboardMarkup pdfBooksRu(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("Словарь\uD83D\uDCD5");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Грамматика\uD83D\uDCD7");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Материалы IELTS\uD83D\uDCD9");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83D\uDCDA");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Orqaga\uD83D\uDD19");

        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        row.add(button);
        row.add(button1);
        row1.add(button2);
        row2.add(button3);
        row3.add(button4);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);

        markup.setKeyboard(rowList);
        markup.setSelective(true);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);

        return markup;
    }
}
