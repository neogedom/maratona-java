package br.com.abc.javacore.Bintroducaometodos.classes;

/**
 * Crie os seguintes atributos para essa classe:
 * nome, matricula, RG, CPF
 * Em seguida, crie uma classe de teste para preencher e imprimir os dados desse professor
 */
public class Professor {
    public String nome;
    public String matricula;
    public String rg;
    public String cpf;

    public void imprime() {
        //Quando você usa o this, você pega os atributos do próprio objeto sem precisar instancia-lo recursivamente
        System.out.println(this.cpf);
        System.out.println(this.matricula);
        System.out.println(this.nome);
        System.out.println(this.rg);

        // this.nome = "Fulano";
        // System.out.println("Dentro do imprime: "+ this.nome);
        
    }
    
}