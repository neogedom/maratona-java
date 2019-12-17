package br.com.abc.javacore.Hheranca.classes;

// Herança é usado por dois motivos:
// 1 - Reaproveitar código
// 2 - Polimorfismo

//Toda classe é filha da classe Object do pacote java.lang
public class Pessoa {
    //Modificador de acesso protected permite que os filhos (fora do pacote) e as classes do mesmo pacote
    // acessem o atributo
    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void print() {
        System.out.println("---------------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Endereço: " + this.endereco.getRua() + " " + this.endereco.getBairro());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}