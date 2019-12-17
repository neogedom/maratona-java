package br.com.abc.introducao.controlefluxo;

/**
 * Aula14ExercicioControleFluxo
 */
public class Aula14ExercicioControleFluxo {

    /* Crie um switch que dado um valor de 1 a 7,
    considerando que 1 seja domingo, imprima se é dia útil 
    ou final de semana */

    public static void main(String[] args) {
        byte dia = 10;

        switch(dia){
            case 1: case 7:
                System.out.println("Final de semana");
                break;
            case 2: case 3: case 4: case 5: case 6:
                System.out.println("Dia útil");
                break;
            default:
                System.out.println("Opção inválida");

        }
    }
}