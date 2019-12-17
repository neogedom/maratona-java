package br.com.abc.introducao.controlefluxo;

/**
 * Aula15ControleFluxo
 */
public class Aula15ControleFluxo {

    public static void main(String[] args) {
       int contador = 11;
       // while ou do... while quando você não tem certeza de quantas vezes irá repetir 
       while(contador < 10) {
            System.out.println(++contador);
        }

        contador = 0;
        //Executa pelo menos uma vez
        do {

            System.out.println("Dentro do while: " + contador++);
        }while(contador < 10);

        //For quando você sabe quantas vezes o laço de repetição deve ser executado
        for (int i = 0; i < 10; i++ ) {
            System.out.println("O valor de i é " + i);
            if (i == 5) {
                break;
            }

        }
    }
}