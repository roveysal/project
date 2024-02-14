package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>();
    private FileService fileService = new FileServiceImpl();
    private final String fileName = "users.txt";
    @Override
    public User create(User user) {
        if (get(user.getChatId()) == null) {
            User newUser = new User(
                    user.getChatId(),
                    user.getFullName(),
                    user.getUsername(),
                    user.getState()
            );
            boolean add = users.add(user);
            if (add){
                String dataFromFile = fileService.getDataFromFile(fileName);
                ObjectMapper mapper = new ObjectMapper();
                try {
                    List<User> list = mapper.readValue(dataFromFile, List.class);
                    list.add(user);
                    Gson gson = new Gson();
                    String json = gson.toJson(list);
                    fileService.writeDateToFile(json, fileName);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return user;
    }

    @Override
    public User get(long chatId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getChatId() == chatId){
                return users.get(i);
            }
        }
        return null;
    }
    @Override
    public List<User> getAll() {
        return users;
    }
    @Override
    public User update(User user, long chatId) {
        User oldUser = get(chatId);
        for (int i = 0; i < users.size(); i++) {
            if (oldUser.getChatId() == chatId){
                oldUser.setState(user.getState());
                users.set(i, oldUser);
            }
        }
        return oldUser;
    }

    @Override
    public User delete(long chatId) {
        return null;
    }


}
