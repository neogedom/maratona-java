package br.com.abc.javacore.ZZEconcorrencia.test;

/**
 * Entregador
 */
public class Entregador implements Runnable {
    private ListaMembros listaMembros;

    public Entregador(ListaMembros listaMembros) {
        this.listaMembros = listaMembros;
    }

    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println(nomeThread + " começando o trabalho de entrega");
        int quantidadePendente = listaMembros.getEmailsPendentes();
        boolean aberta = listaMembros.isAberta();
        while (aberta || quantidadePendente > 0) {
            try {
                String email = listaMembros.obterEmailMembro();
                if(email != null) {
                    System.out.println("Enviando email para " +email);
                    Thread.sleep(2000);
                    System.out.println("Envio para " +email+ "concluído com sucesso");
                }
            } catch (InterruptedException e) {
                //TODO: handle exception
            }

            aberta = listaMembros.isAberta();
            quantidadePendente = listaMembros.getEmailsPendentes();
        }
        System.out.println("Atividades finalizadas");
    }
    
}