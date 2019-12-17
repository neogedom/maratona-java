package br.com.abc.introducao.controlefluxo;

public class Aula17ControleFluxo {
    public static void main(String[] args) {
        // Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
        // As parcelas não podem ser menores do que mil
        double valorTotal = 30000;
        for (int parcela = 1; parcela <= valorTotal; parcela++) {
            double valorParcela = valorTotal / parcela;
            // if (valorParcela >= 1000) {
            // System.out.println("Parcela " + parcela + " = " + valorParcela);
            // } else {
            // System.out.println("Saindo do laço");
            // break; // Sem esse break, o que está aqui fora será executado e processamento
            // será desperdiçado
            // // o break quebra o laço
            // }

            // System.out.println("Fora do laço");
            // }

            // versão melhor
            if (valorParcela < 1000) {
                break;
            }
            System.out.println("Parcela " + parcela + " = " + valorParcela);
        }
    }

}