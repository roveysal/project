package org.example.service;

import jdk.dynalink.linker.LinkerServices;
import org.example.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User get(long chatId);
    User update(User user, long chatId);
    User delete(long chatId);

    List<User> getAll();
}
