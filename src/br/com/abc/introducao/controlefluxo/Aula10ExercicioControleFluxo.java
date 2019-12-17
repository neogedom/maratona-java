package br.com.abc.introducao.controlefluxo;

public class Aula10ExercicioControleFluxo {
    public static void main (String args []) {
        /* 
            Crie uma variável salário e imprima seu imposto
            imposto: 
                salpario < 1000 == 5%
                salário <= 1000 && salário < 2000 == 10%
                salario >= 2000 && salário < 4000 == 15%
                salário >= 4000 == 20%
        */

        double salario = 3500;
        double imposto = 0;
        

        if (salario < 1000) {
            imposto = salario * 0.05;
        } else if (salario <= 1000 && salario < 2000) {
            imposto = salario * 0.1;
        } else if (salario >= 2000 && salario < 4000) {
            imposto = salario * 0.15;
        } else {
            imposto = salario * 0.2;
        }

        System.out.println("O imposto para o salário de " + salario + " é " + imposto);

    }
}