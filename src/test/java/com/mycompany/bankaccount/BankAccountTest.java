/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.bankaccount;

import com.mycompany.bankaccount.BankAccount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author Salimatuz Zahwah
 */
public class BankAccountTest {

    private BankAccount akun;

    @BeforeEach
    void setUp() {
        akun = new BankAccount("Mahasiswa 09020624064", 1_000_000);
        System.out.println("=== Setup: akun dibuat dengan saldo 1.000.000 ===");
    }

    @AfterEach
    void tearDown() {
        System.out.println("=== TearDown: saldo akhir = " + akun.getSaldo() + " ===\n");
    }

    @Test
    @DisplayName("Deposit berhasil - saldo bertambah")
    void testDepositBerhasil() {
        akun.deposit(500_000);
        assertEquals(1_500_000, akun.getSaldo());
    }

    @Test
    @DisplayName("Withdraw berhasil - saldo berkurang")
    void testWithdrawBerhasil() {
        akun.withdraw(300_000);
        assertEquals(700_000, akun.getSaldo());
    }

    @Test
    @DisplayName("Withdraw gagal - saldo tidak cukup")
    void testWithdrawGagalSaldoTidakCukup() {
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> akun.withdraw(2_000_000)
        );
        assertTrue(exception.getMessage().contains("Saldo tidak cukup"));
        System.out.println("Exception: " + exception.getMessage());
    }
}