package financemanager;

import java.util.*;

class FinanceManager {
    private Map<String, User> users;
    private User currentUser;

    public FinanceManager() {
        this.users = new HashMap<>();
        this.currentUser = null;
    }

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Пользователь уже существует.");
            return;
        }
        users.put(username, new User(username, password));
        System.out.println("Пользователь успешно зарегестрирован.");
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.checkPassword(password)) {
            System.out.println("Неверные логин или пароль.");
            return;
        }
        currentUser = user;
        System.out.println("Вход успешно выполнен. Добро пожаловать, " + username + "!");
    }

    public void logout() {
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Выход успешно выполнен.");
        } else {
            System.out.println("Ни один пользователь не выполнил вход.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
