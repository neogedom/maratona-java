package br.com.abc.introducao.controlefluxo;

public class Aula10ControleFluxo {
    public static void main(String args[])
    {
        //Se a idade for menor que 15, categoria infantil
        // Se a idade for maior ou igual a 15 e menor ou igual a 18, categoria juvenil
        // Se a idade for maior ou igual a 18, categoria adulto
        int idade = 18;
        String categoria; 
       
        //Dentro do if, um valor booleano
        if(idade < 15) {
           categoria = "infantil";
        } else if (idade >= 15 && idade < 18) {
           categoria = "juvenil";
        } else { // se faltar esse bloco de código, pode ser que a variável não seja inicializada
            categoria = "adulto";
        }

        System.out.println("Categoria " + categoria);

        // // Pegadinha
        // boolean c = false;
        // if (c = true) {
        //     System.out.println("Entrou no if");
        // } else {
        //     System.out.println("Entrou no else");
        // }

    }
}