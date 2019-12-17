package br.com.abc.javacore.Csobrecargametodos.classes;

/**
 * Funcionario
 */
public class Funcionario {

    private String nome;
    private String cpf;
    private double salario;
    public String rg;

    //O construtor sempre existe, você criando explicitamente ou não
    // Regra 1: Construtor nunca terá retorno, nem mesmo void
    // Construtor é útil para "obrigar" regras de negócio. Ex.: nenhum Funcionario será criado sem nome
    public Funcionario (String nome, String cpf, double salario, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.rg = rg;
        System.out.println("Dentro do construtor");
    }

    public Funcionario () {

    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSalario() {
        return this.salario;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }


     //this é uma variável de referência que faz referência para o próprio objeto
     public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.salario);
        System.out.println(this.rg);
    }

    // Como se fosse todos os métodos set num lugar só
    public void init(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }


    //Aqui temos uma sobrecarga de método. Útil quando você quer adicionar novos atributos e 
    // não afetar o código preexistente, inclusive no projeto de outras pessoas.
    // A sobrecarga repete o modificador de acesso, o tipo do retorno, o nome, mas a quantidade e/ou
    // os parâmetros devem ser diferentes
    public void init (String nome, String cpf, double salario, String rg) {
        // this.nome = nome;
        // this.cpf = cpf;
        // this.salario = salario;
       
        //Evite repetir código
        this.init(nome, cpf, salario);
        this.rg = rg;
    }

}