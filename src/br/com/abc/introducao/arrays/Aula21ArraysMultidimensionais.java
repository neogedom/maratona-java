package br.com.abc.introducao.arrays;

/**
 * Aula21ArraysMultidimensionais
 */
public class Aula21ArraysMultidimensionais {

    public static void main(String[] args) {
        // int [] dias [] = new int[31][]; pode ser assim também, mas não é aconselhável
        // Só é necessário definir o tamanho do primeiro array
        // Cada posição faz referência para outro array de 2 posições [array][array]
        // O último array é quem guarda o tipo int

        int[][] dias = new int[2][2];
        dias[0][0] = 30;
        dias[0][1] = 31;
        dias[1][0] = 29;
        dias[1][1] = 28;

        // iterando arrays bidimensionais
        for (int i = 0; i < dias.length; i++) {
           System.out.println(dias[1]); // imprimindo aqui, mostra o endereço de memória
           for (int j = 0; j < dias[i].length; j++) {
               System.out.println(dias[i][j]);
           }
        }
        
        System.out.println("--------------------");
        //iterando arrays bidimensionais com foreach
        // Primeiro pega o array de dias[] e joga em int[] ref, depois pega o valor de ref[] e joga numa variável int
        for (int[] ref : dias) {
            for (int dia: ref ) {
                System.out.println(dia);
            }
        }

    }
}