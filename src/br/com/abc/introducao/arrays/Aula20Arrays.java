package br.com.abc.introducao.arrays;

/**
 * Aula20Arrays
 */
public class Aula20Arrays {

    public static void main(String[] args) {
       // int[] numeros = new int[5];
        int[] numeros2 = {1,2,3,4,5};// Outra forma de criar a referência do array
        //Se você colocar o tamanho dentro dos colchetes, dá erro

        // int i;
        // for (i = 0; i < numeros2.length; i++){
        //     System.out.println(numeros2[i]);
        // }
        
        //foreach, outra forma de iterar arrays
        for(int numero: numeros2) { //É importante que a variável local (numero) seja do tipo dos valores 
            //dentro do array
            System.out.println(numero);

            //A variável local numero não pode ser usada fora do escopo do for

        }
    } 
}