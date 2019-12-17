package br.com.abc.javacore.Dsobrecargaconstrutores.classes;

/**
 * Estudante
 */
public class Estudante {

    private String matricula;
    private String nome;
    private double[] notas;
    private String dataMatricula;

    // Erro 1: colocar retorno do método. Construtor não deve ter retorno, nem mesmo
    // void
    // Erro 2: apenas adicionar novo parâmetro no construtor já existente. Isso
    // quebra o código de todo
    // mundo. O certo é criar outro construtor com sobrecarga de método
    public Estudante(String matricula, String nome, double[] notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
    }

    public Estudante(String matricula, String nome, double[] notas, String dataMatricula) {
        this(matricula, nome, notas); // Chamando um construtor dentro de outro construtor
        // E o this() só pode ser usado dentro de outro construtor
        // O this() obrigatoriamente deve ser a primeira linha
        this.dataMatricula = dataMatricula;
    }

    public Estudante() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.matricula);
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.print("\n");
        System.out.println(this.dataMatricula);
    }

}