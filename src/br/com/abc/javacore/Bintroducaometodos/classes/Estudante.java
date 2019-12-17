package br.com.abc.javacore.Bintroducaometodos.classes;

/**
 * Estudante
 */
// Crie uma classe Estudante com os seguintes atributos
// nome, idade, notas (três notas)
// Crie um método para imprimir os dados e tirar a média desse aluno
// Caso a média seja maior que 6, imprimir aprovado, senão reprovado

public class Estudante {

    //É possível acessar atributos privados dentro da própria classe
    private String nome;
    private int idade;
    private double[] notas;
    private boolean aprovado;

    public void imprimeDados() {

        System.out.println("Nome: " + this.nome); // this pega do objeto que o chama
        System.out.println("Idade: " + this.idade);

        // for (int i = 0; i < notas.length; i++) {
        // System.out.println("Nota " + i + ": " + notas[i]);
        // }
        if (notas != null) // isso funciona pq todo o bloco do for é considerado uma única instrução
            for (double nota : notas) {
                System.out.print(nota + " ");
            }

    }

    public void tiraMedia() {
        double media = 0;
        String status = "";

        // Se as notas forem null, nem executa as próximas instruções
        // Corre o risco de alguma vez a variável notas ser chamada
        if (notas == null) {
            System.out.println("Esse aluno não possui notas!");
            return;
        }

        for (double nota : notas) {
            media += nota;
        }

        media /= notas.length;

        if (media < 6.0) {
            status = "aprovado";
            this.aprovado = false;
        } else {
            status = "reprovado";
            this.aprovado = true;
        }

        System.out.println("\nA média desse aluno é: " + media + ", portanto o aluno está " + status);

    }

    // Princípio do encapsulamento
    // Set são os métodos para atribuir valores
    public void setNome(String nome) {
        // Problemático pq subentende-se que a variável local está recebendo ela mesma
        // nome = nome;
        this.nome = nome; // Aqui significa que o valor em memória/nome do objeto que chamou (this)
        // recebe o valor que está sendo passado
    }

    public void setIdade(int idade) {
        // método set é útil para colocar restrições na atribuiçao do método
        if (idade < 0) {
            System.out.println("Não é possível atribuir idades negativas");
            return;
        }
        this.idade = idade;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    // Get são os métodos para retornar valores dos atributos
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getNotas() {
        return this.notas;
    }

    // Em valores booleanos não se usa get, se usa is
    public boolean isAprovado() {
        return this.aprovado;
    }

    //O set aprovado não é possível porque faz parte da lógica de negócio o aluno estar aprovado/reprovado
    //de acordo com a nota que ele tirar
    // public void setAprovado(boolean aprovado) {
    //     this.aprovado = aprovado;
    // }

    // Com set e get posso impedir que algum programador use alguns atributos,
    // apenas retirando os getters/setters
    // Ás vezes é útil impedir que alguém mude algum atribute, mas deixe ele ler.
    // Isso é impossível usando só
    // modificador de acesso
    // É útil também por que traz baixo acoplamento
    // É importante que os getters e setters sigam 
}