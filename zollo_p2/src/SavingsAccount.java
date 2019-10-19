public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public static void modifyInterestRate(double value) {
        annualInterestRate = value;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * (annualInterestRate / 12.0);
        savingsBalance = savingsBalance + monthlyInterest;
    }

    // Problem statement did not specify how to access the updated savings balance. It was possible to add a return
    // value to calculateMonthlyInterest, but I chose to make a function specifically to get the balance instead.
    public double getSavingsBalance() {
        return savingsBalance;
    }
}
