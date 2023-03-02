import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountTest extends AbstractSimpleBankAccountTest {

    private static final int WRONG_USER_ID = 2;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAWAL_AMOUNT = 70;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Kel", "Vin", 1);
        this.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(WRONG_USER_ID, DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAWAL_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAWAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(WRONG_USER_ID, WITHDRAWAL_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}