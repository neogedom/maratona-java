package br.com.abc.introducao.operadores;

public class Aula6Operadores {
    public static void main(String args[]) {
        int numero1 = 10;
        int numero2 = 20;

        System.out.println("A soma é: " + (numero1 + numero2));
        System.out.println("A multiplicação " + (numero1 * numero2));
        System.out.println("A subtração é: " + (numero1 - numero2));

        // Cuidado!
        // Ao ter usado uma vez o + para concatenar, a próxima vez que ele for usado no
        // sysout ele irá concatenar de novo (e não somar)
        System.out.println(numero1 + numero2 + " A soma é: " + numero1 + numero2);
        System.out.println("A divisão é: " + (numero1 / numero2));

    }
}