package br.com.abc.introducao.controlefluxo;

/**
 * Aula18ControleFluxob
 */
public class Aula17ControleFluxob {

    public static void main(String[] args) {
        // Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
        // As parcelas não podem ser menores do que mil
        double valorTotal = 30000;
        for (int parcela = (int) valorTotal; parcela >= 1; parcela--) { 
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000 ) {
                continue;
                //Código aqui nunca será atingido, e isso causa erro de compilação
               
             } //else {
            //     continue;
            // }
            System.out.println("Parcela " + parcela + " = " + valorParcela);
            System.out.println("Código consumindo memória");
           
        }
    }
}