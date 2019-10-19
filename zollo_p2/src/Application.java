public class Application {
    public static void main(String[] args) {
        // Initialize the 2 SavingsAccount objects and print their starting balances.
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        System.out.printf("saver1 initial balance: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("saver2 initial balance: $%.2f\n", saver2.getSavingsBalance());

        // Sets interest rate to 0.04 and loops through 12 months of interest for both accounts, printing the balance afterwards.
        SavingsAccount.modifyInterestRate(0.04);
        for(int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.printf("saver1 balance after 12 months at 0.04 annual interest rate: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("saver2 balance after 12 months at 0.04 annual interest rate: $%.2f\n", saver2.getSavingsBalance());

        // Sets interest rate to 0.05 and adds one month of interest to both accounts, then prints the new balances.
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("saver1 balance after another month at 0.05 annual interest rate: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("saver2 balance after another month at 0.05 annual interest rate: $%.2f\n", saver2.getSavingsBalance());
        return;
    }
}
