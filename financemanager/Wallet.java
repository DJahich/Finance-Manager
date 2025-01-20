package financemanager;

import java.util.*;

public class Wallet {
    private double totalIncome; // Новый атрибут для общего дохода
    private double balance; // Текущий баланс
    private List<Transaction> transactions;
    private Map<String, BudgetCategory> budgetCategories;

    public Wallet() {
        this.totalIncome = 0;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.budgetCategories = new HashMap<>();
    }

    public void setIncome(double income) {
        this.totalIncome = income;
        this.balance = income; // Устанавливаем баланс равным доходу
        System.out.println("Общий доход установлен: " + income);
    }

    public void addTransaction(String category, double amount, boolean isIncome) {
        transactions.add(new Transaction(category, amount, isIncome)); 
        balance += isIncome ? amount : -amount;

        if (!budgetCategories.containsKey(category)) {
            budgetCategories.put(category, new BudgetCategory(category));
        }
        budgetCategories.get(category).addTransaction(amount, isIncome);
    }

    public void setBudget(String category, double budget) {
        budgetCategories.putIfAbsent(category, new BudgetCategory(category));
        budgetCategories.get(category).setBudget(budget);
    }

    public double getBalance() {
        return balance;
    }

    public void printSummary() {
        System.out.println("Текущий баланс: " + balance);
        System.out.println("Транзакции:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        System.out.println("Бюджеты:");
        for (BudgetCategory category : budgetCategories.values()) {
            System.out.println(category);
        }
    }
}
