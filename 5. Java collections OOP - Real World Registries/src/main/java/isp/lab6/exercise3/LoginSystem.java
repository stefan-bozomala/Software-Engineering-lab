package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private Set<User> users;
    private OnlineStore store;

    public LoginSystem(OnlineStore store) {
        this.users = new HashSet<>();
        this.store = store;
    }

    public void register(String username, String password) {
        User newUser = new User(username, password);
        if (!users.contains(newUser)) {
            users.add(newUser);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                store.addSession(username);
                return true;
            }
        }
        return false;
    }

    public boolean logout(String username) {
        store.removeSession(username);
        return true;
    }
}
