package financemanager;

public class Transaction {
    private String category;
    private double amount;
    private boolean isIncome;

    public Transaction(String category, double amount, boolean isIncome) {
        this.category = category;
        this.amount = amount;
        this.isIncome = isIncome;
    }

    @Override
    public String toString() {
        return (isIncome ? "Доход" : "Расход") + " - Категория: " + category + ", Сумма: " + amount;
    }
}
