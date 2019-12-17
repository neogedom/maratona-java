package br.com.abc.javacore.Bintroducaometodos.test;

import br.com.abc.javacore.Bintroducaometodos.classes.Calculadora;

/**
 * CalculadoraTest
 */
public class CalculadoraTest {
    // O método main pode receber varargs
    public static void main(String ... args) {
        Calculadora calc = new Calculadora();
        // //Padrão também é variavel.metodo()
        // calc.somaDoisNumeros();
        // calc.subtraiDoisNumeros();
        // // No método se chama parâmetro, na chamada do método se chama argumentos
        // // É preciso passar a mesma quantdade de argumentos e todos no mesmo tipo esperado como parâmetro no métod
        // calc.multiplicaDoisNumeros(5, 5);
        // System.out.println("Divisão de dois números:");
        // //É possível imprimir o retorno
        // System.out.println(calc.divideDoisNumeros(20, 2));
        // //Ou guardar o retorno em uma variável
        // double result =  calc.divideDoisNumeros(20, 0);
        // System.out.println(result);
        // //System.out.println(calc.imprimeDoisNumerosDivididos(2, 2);); dá erro pq o método retorna void
        // System.out.println("Imprimindo dois números divididos: ");
        // calc.imprimeDoisNumerosDivididos(20, 0);

        // int num1 = 5;
        // int num2 = 10;
        // System.out.println("Antes do método alteraDoisNumeros: " + num1 + " " + num2);
        // calc.alteraDoisNumeros(num1, num2);
        // System.out.println("Depois do método alteraDoisNumeros: " + num1 + " " + num2);


        //O programa exeecuta toda as instruções, depois continua a partir daqui
        System.out.println("Continuando a execução");

        int [] numeros = {1, 2, 3, 4, 5};
        calc.somaArray(numeros);
        // Dá pra passar o Array
       // calc.somaVarArgs(numeros);
       // Mas também dá pra passar os valores direto
       calc.somaVarArgs(1, 2, 3, 4, 5);
    }
}