package br.com.abc.javacore.ZZEconcorrencia.test;

/**
 * Conta
 */
public class Conta {

    private int saldo = 50;

    public int getSaldo () {
        return this.saldo;
    }

    public void saque (int valor) {
        saldo = saldo - valor;
    }
}