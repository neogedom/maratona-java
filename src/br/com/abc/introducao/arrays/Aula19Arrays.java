package br.com.abc.introducao.arrays;

/**
 * Aula19Arrays
 */
public class Aula19Arrays {

    public static void main(String[] args) {
        String [] idades = new String[3];

        //Os espaços dos arrays são inicializados automaticamente com valores padrão
        //Para os tipos byte, int, float, double, short e long, os valores serão 0
        //Para char será '\u0000' (um unicode representando um espaço vazio)
        //Para boolean será false
        //Para variáveis do tipo reference será null (exemplo: String)
        System.out.println("Idade 1 " + idades[0]);
        System.out.println("Idade 2 " + idades[1]);
        System.out.println("Idade 3 " + idades[2]);

        String nomes[] = new String[3];
        nomes[0] = "Naruto";
        nomes[1] = "Goku";
        nomes[2] = "Meliodas";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + " nome " + nomes[i]);
            
        }

        //Obs.: Escolhendo um tamanho de array, não é possível mudar. Por isso as coleções do Java são mais usadas que os arrays

    }
}