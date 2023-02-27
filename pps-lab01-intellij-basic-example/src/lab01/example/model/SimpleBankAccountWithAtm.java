package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private final BankAccount account;

    public SimpleBankAccountWithAtm(AccountHolder holder, final double amount) {
        this.account = new SimpleBankAccount(holder, amount);
    }
    @Override
    public AccountHolder getHolder() {
        return this.account.getHolder();
    }

    @Override
    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.account.deposit(userID, withDepositFee(amount));
    }

    private double withDepositFee(final double amount) {
        return amount - ATM_FEE;
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.account.withdraw(userID, withWithdrawalFee(amount));
    }

    private double withWithdrawalFee(final double amount) {
        return amount + ATM_FEE;
    }
}
