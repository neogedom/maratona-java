package br.com.abc.javacore.Kenumeracoes.classes;

/**
 * Enumaration tipo Cliente
 */
public enum TipoCliente {
    // A declaração interna segue o mesmo padrão das constantes
    // Porque os enums são constantes
    //Quando eu declaro construtor, eu preciso passar os argumentos por meio das enumerações

    
    PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica") {
        //Constant specific class body. Significa que posso criar um bloco de código para cada enum 
        // a fim de sobrescrever
    // algum método desse mesmo enum
        public String getId () {
            return "B";
        }
    }; // O ponto e vírgula é obrigatório

    // VOcê pode criar atributos dentro da enumeração, mas você só pode criar depois da enumeração
    private int tipo;
    private String nome;

    // Não pode criar construtor public, porque você nunca vai chamar o construtor de uma enumeração
    // ELe mesmo vai se chamar
    private TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return "A";
    }

    // Não é uma boa ideia criar set, porque se não caimos no mesmo problema da pessoa passar valores
    //não permitidos para a variável
    // public void setTipo(int tipo) {
    //     this.tipo = tipo;
    // }

    

    
    
}