import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
abstract class AbstractSimpleBankAccountTest {

    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }
}
