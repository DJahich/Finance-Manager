package financemanager;

class BudgetCategory {
    private String name;
    private double budget;
    private double totalExpenses;

    public BudgetCategory(String name) {
        this.name = name;
        this.budget = 0;
        this.totalExpenses = 0;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void addTransaction(double amount, boolean isIncome) {
        if (!isIncome) {
            totalExpenses += amount;
        }
    }

    public double getRemainingBudget() {
        return budget - totalExpenses;
    }

    @Override
    public String toString() {
        return "Категория: " + name + ", Бюджет: " + budget + ", Общие Траты: " + totalExpenses + ", Остаток: " + getRemainingBudget();
    }
}
