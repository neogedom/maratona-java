package br.com.abc.javacore.Kenumeracoes.classes;

/**
 * Cliente
 */
public class Cliente {

    // Da pra criar o enum assim
    // Ele funciona como classe interna
    // Não é permitido cirar enumeração dentro de método
     public static enum TipoPagamento {
         // A declaração interna segue o mesmo padrão das constantes
         // Porque os enums são constantes
        AVISTA, APRAZO;
        
     }

    private String nome;
    // // Desse jeito, nada impede que algum programador passe algum valor diferente de 1 ou 2
    // public static final int PESSOA_FISICA = 1;
    // public static final int PESSOA_JURIDICA = 2;
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipo() {
        return tipoCliente;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipoCliente = tipo;
    }

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", tipo=" + tipoCliente.getNome() + ", tipo de pagamento="+ tipoPagamento+""+
        ", numero "+tipoCliente.getTipo()+"]";
        // Pego o getTipo em tipoCliente para salvar o valor 2 no banco de dados
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    
}