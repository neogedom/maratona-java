package br.com.abc.introducao.arrays;

/**
 * Aula22ArraysMultidimensionais
 */
public class Aula22ArraysMultidimensionais {

    public static void main(String[] args) {
       //Você é obrigado a pasasr pelo menos o tamanho do array primário.
       // Os arrays das outras dimensões podem ter tamanhos diferentes
       // Dessa forma as posições do array primário não estão fazendo referência para nenhum outro array
       // int [][] dias = new int[3][];

        // //Criando arrays de posições diferentes dentro das posições do array primário
        // dias[0] = new int[2];
        // dias[1] = new int [] {1, 2, 3};
        // dias [2] = new int[4];

        int[][] dias = {{0,0}, {1,2,3}, {0,0,0,0}};

        for (int[] arr : dias) {
            for (int num : arr) {
                System.out.println(num);
            }
        }
         
    }
}