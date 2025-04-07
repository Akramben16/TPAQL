import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.BankAccount;

/*Classe d'équivalence :
✔ Dépôts valides (somme positive)
✔ Dépôt invalide (somme négative)
✔ Retraits valides (solde suffisant)
✔ Retrait invalide (solde insuffisant, somme négative)
✔ Transferts valides entre comptes
✔ Transfert invalide (compte null, somme négative)
✔ Ajout d'intérêts */

class BankAccountTest {
    private BankAccount account;
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100, 0.05);
        account1 = new BankAccount(300, 0.05);
        account2 = new BankAccount(100, 0.05);
    }

    @Test
    void depositShouldIncreaseBalance() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void depositShouldThrowExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }

    @Test
    void withdrawShouldThrowExceptionForInsufficientBalance() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(200));
    }

    @Test
    void transferShouldMoveFundsBetweenAccounts() {
        account1.transfer(100, account2);
        assertEquals(200, account1.getBalance());
        assertEquals(200, account2.getBalance());
    }

    @Test
    void transferShouldThrowExceptionForNullAccount() {
        assertThrows(NullPointerException.class, () -> account1.transfer(50, null));
    }

    @Test
    void addInterestShouldIncreaseBalance() {
        account.addInterest();
        assertEquals(105, account.getBalance());
    }
}

