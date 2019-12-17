package br.com.abc.introducao.operadores;

public class Aula8OperadoresLogicos {

    public static void main (String args[])
    {
        //&& -> AND 
        // || -> OR
        int idade = 18;
        float salario = 1000f;

        System.out.println(idade >= 18 && salario >= 3000);
        System.out.println(idade >= 18 || salario >= 3000);
    }
}