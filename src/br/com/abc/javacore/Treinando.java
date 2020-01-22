package br.com.abc.javacore;

import javax.swing.JButton;

/**
 * Treinando
 */
public class Treinando {

    public static void main(String[] args) {
        // new Thread(() -> System.out.println("Olá mundo")).run();
        JButton jButton = new JButton();
        jButton.addActionListener((e) -> System.out.println("Olá mundo"));
    }
}