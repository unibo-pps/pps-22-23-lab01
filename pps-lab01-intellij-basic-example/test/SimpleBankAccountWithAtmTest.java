import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest {

    private static final int ATM_FEE = 1;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAWAL_AMOUNT = 50;
    public static final int WRONG_USER_ID = 2;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Kel", "Vin", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        this.bankAccount.deposit(WRONG_USER_ID, DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        this.bankAccount.withdraw(accountHolder.getId(), WITHDRAWAL_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE - (WITHDRAWAL_AMOUNT + ATM_FEE), this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        this.bankAccount.withdraw(WRONG_USER_ID, WITHDRAWAL_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, this.bankAccount.getBalance());
    }

}