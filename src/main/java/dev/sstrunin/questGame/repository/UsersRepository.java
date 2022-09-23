package dev.sstrunin.questGame.repository;

import dev.sstrunin.questGame.entity.User;

import java.util.HashMap;

public class UsersRepository {
    private static UsersRepository instance = new UsersRepository();

    private HashMap<String, User> users;

    public static UsersRepository getInstance() {
        return instance;
    }

    private UsersRepository() {
        users = new HashMap<>();
    }

    public User addUser(String username) {
        User user = new User(username);
        users.put(username, user);
        return user;
    }

    public boolean isUsernameExist(String name) {
        return users.containsKey(name);
    }

    public User getUserByName(String username) {
        return users.get(username);
    }

}
