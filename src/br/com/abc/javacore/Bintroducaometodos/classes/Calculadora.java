package br.com.abc.javacore.Bintroducaometodos.classes;

/**
 * Calculadora
 */
public class Calculadora {

    // Void é vazio
    // O padrão de nomes para métodos no Java é camelCase
    public void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    // Forma para criar método <modificador de acesso> <tipo de retorno> <nome do
    // método> ()
    public void subtraiDoisNumeros() {
        System.out.println(5 - 5);
    }

    // Método com passagem de parâmetro
    // A recepção dos argumentos nos parâmetros equivale a double num1 = 5
    public void multiplicaDoisNumeros(double num1, double num2) {

        System.out.println(num1 * num2);
    }

    public double divideDoisNumeros(double num1, double num2) {
        // Retorna para quem chamou

        // Dividir nº por 0 retorna Infinity. Dividir 0 por 0 dá erro
        // É importante lidar com o erro de divisão por 0
        // Cuidado com retornos inatingíveis
        if (num1 != 0) {
            return num1 / num2;
            // Qualquer instrução abaixo de um retorno é uma instrução inatingível
        }
        return 0;

    }

    public void imprimeDoisNumerosDivididos(double num1, double num2) {
        if (num2 != 0) {
            System.out.println(num1 / num2);
            // Return sem valor com função de break. Só é possível em métodos void
            return;
        }

        System.out.println("Não é possível dividir por zero");

    }

    public void alteraDoisNumeros(int num1, int num2) {
        num1 = 30;
        num2 = 40;

        System.out.println("Dentro do altera dois números: ");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

    }

    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }

        System.out.println(soma);
    }

    //Recebendo varargs como argumentos
    //Recebendo valores separados, o Java se encarrega de transformá-los em Array
    // Regras: você só pode criar um varargs por assinatura
        // Se você quiser passar mais de um parâmetro, o varargs precisa ser o último pq o Java não saberá quando parar 
        // de contar os elementos do varargs
    public void somaVarArgs(double valorDouble, int ... numeros) {

        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }

        System.out.println(soma);
    }
}