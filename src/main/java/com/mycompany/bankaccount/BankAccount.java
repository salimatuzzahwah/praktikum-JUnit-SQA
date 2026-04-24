/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccount;

/**
 *
 * @author Salimatuz Zahwah
 */
public class BankAccount {

    private String pemilik;
    private double saldo;

    public BankAccount(String pemilik, double saldoAwal) {
        if (saldoAwal < 0) {
            throw new IllegalArgumentException("Saldo awal tidak boleh negatif");
        }
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
    }

    public void deposit(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah deposit harus lebih dari 0");
        }
        this.saldo += jumlah;
    }

    public void withdraw(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah penarikan harus lebih dari 0");
        }
        if (jumlah > this.saldo) {
            throw new IllegalStateException(
                "Saldo tidak cukup! Saldo saat ini: " + this.saldo
            );
        }
        this.saldo -= jumlah;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPemilik() {
        return pemilik;
    }
}