package br.com.abc.javacore.Hheranca.classes;

/**
 * Funcionario
 */
// Funcionário é um tipo de pessoa, por isso estende pessoa.
// Isso é herança
// Obs.: não existe herança múltipla em Java do tipo Funcionario extends Pessoa, Endereco

/**
 * Ordem de inicialização quando temos herança
 * 1 - Espaço em memória é alocado para o objeto sendo construido
 * 2 - Cada um dos atributos do objeto é criado e inicializado com os valores default
 * 3 - O construtor da superclasse é chamado
 * 4 - A inicialização dos atributos via declaração e o código do bloco de inicialização da superclasse são
 * executados na ordem em que aparecem
 * 5 - O código do construtor da superclasse é chamado
 * 6 - Passo 4 para a subclasse é executado
 * 7 - O código do construtor da classe é executado
 */
public class Funcionario extends Pessoa {
    private double salario;

    
    // public Funcionario(double salario) {
    //     this.salario = salario;
    // }

    // Se eu criar um construtor que tenha argumentos na classe pai, tenho que criar 
    // um construtor na classe filha que contenha pelo menos o que é requerido como argumento
    // da classe pai. Nesse caso, nome e cpf
    public Funcionario(String nome, String cpf, double salario) {
        
        //Eu passo os parâmetros nome e cpf por meio de super para a classe pai
        // Se você usar o super, não pode chamar o this() pq ambos precisam ser a primeira linha 
        // do construtor
        super(nome, cpf);
        this.salario = salario;
    }

    //Se escrever a mesma assinatura de um método na classe pai, estarei sobrescrevendo o método
    // Se eu colocar parâmetros diferentes, estarei fazendo uma sobrecarga de métodos
    public void print() {
        //Para chamar métodos da classe pai, usar o super
        super.print();
        System.out.println("Salário: " + this.salario);
        imprimeReciboPagamento();

    }

    public void imprimeReciboPagamento() {
        System.out.println("Eu " +  super.nome + " recebi o pagameto de " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    


    
}