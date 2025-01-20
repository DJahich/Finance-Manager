package financemanager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();

        while (true) {
            System.out.println("\n1. Регистрация\n2. Вход\n3. Установить общий доход\n4. Добавить транзакцию\n5. Установить бюджет\n6. Посмотреть общий бюджет\n7. Выйти из профиля\n8. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();
                    manager.register(username, password);
                }
                case 2 -> {
                    System.out.print("Введите имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();
                    manager.login(username, password);
                }
                case 3 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Пожалуйста, сначала выполните вход в систему.");
                        break;
                    }
                    System.out.print("Введите общий доход: ");
                    double income = scanner.nextDouble();
                    user.getWallet().setIncome(income);
                }
                case 4 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Пожалуйста, сначала выполните вход в систему.");
                        break;
                    }
                    System.out.print("Введите категорию: ");
                    String category = scanner.nextLine();
                    System.out.print("Введите сумму: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Это доход? (true/false): ");
                    boolean isIncome = scanner.nextBoolean();
                    user.getWallet().addTransaction(category, amount, isIncome);
                }
                case 5 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Пожалуйста, сначала выполните вход в систему.");
                        break;
                    }
                    System.out.print("Введите категорию: ");
                    String category = scanner.nextLine();
                    System.out.print("Введите бюджет: ");
                    double budget = scanner.nextDouble();
                    user.getWallet().setBudget(category, budget);
                }
                case 6 -> {
                    User user = manager.getCurrentUser();
                    if (user == null) {
                        System.out.println("Пожалуйста, сначала выполните вход в систему.");
                        break;
                    }
                    user.getWallet().printSummary();
                }
                case 7 -> manager.logout();
                case 8 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}
