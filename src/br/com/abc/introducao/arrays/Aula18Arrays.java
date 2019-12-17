package br.com.abc.introducao.arrays;

public class Aula18Arrays {
    public static void main (String args []) {
        // int nome[]; //menos recomendado
        // Há dois tipos de variáveis no java: primitivo e referência
        // Array é do tipo por referência
        // apenas colocando int [] nome; não existe ainda espaço na memória
        // O index sempre é tamanho - 1
       
        //Criando espaço na memória
        //Por causa do new, dá pra ver que array é um objeto
        int[] idades = new int[3];
        idades[0] = 20;
        idades[1] = 15;
        idades[2] = 30;
        //idades[3] = 45 -> errado

        System.out.println("Idade 1 " + idades[0]);
        System.out.println("Idade 2 " + idades[1]);
        System.out.println("Idade 3 " + idades[2]);






    }
}