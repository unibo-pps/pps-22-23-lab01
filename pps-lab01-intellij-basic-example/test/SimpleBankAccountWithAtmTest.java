import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest {

    public static final int ATM_FEE = 1;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Kel", "Vin", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 50);
        assertEquals(100 - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        this.bankAccount.withdraw(accountHolder.getId(), 50);
        assertEquals(50 - 2 * ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(accountHolder.getId(), 100);
        this.bankAccount.withdraw(2, 50);
        assertEquals(100 - ATM_FEE, this.bankAccount.getBalance());
    }

}