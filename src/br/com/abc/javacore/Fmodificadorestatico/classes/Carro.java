package br.com.abc.javacore.Fmodificadorestatico.classes;

/**
 * Carro
 */
public class Carro {
    // Velocidade Limite: 240 km/h
    private String nome;
    private double velocidadeMaxima;
    // O operador estático transforma o atributo em membro da classe e que pode ser modificado a nível de classe
    // e não somente em nível de objeto
    private static double velocidadeLimite = 240;

    public Carro() {

    }

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    // Quando o atributo é estático, não é uma boa ideia acessá-lo por meio de um get/set de um objeto
    // pois altera as propriedades dq1' e todos os objetos enquanto se acha que está alterando de um único
    // public void setVelocidadeLimite(double velocidadeLimite) {
    //     this.velocidadeLimite = velocidadeLimite;
    // }

    //O jeito certo de se acessar atributos estáticos com get/set é por meio de métodos estáticos
    // Cuidado: você não pode acessar atributos de classe com métodos estáticos, pois os métodos estáticos
    // pertencem à classe e existem antes mesmo que atributos tenham sido criados
    public static void setVelocidadeLimite (double velocidadeLimite) {
        //Lembre-se, você não pode usar o this 
        // Mas assim é uma atribuição da variável para ela mesma
        // velocidadeLimite = velocidadeLimite;
        //Então fazemos assim
        Carro.velocidadeLimite = velocidadeLimite;
    }

    public String getNome() {
        return nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    // public double getVelocidadeLimite() {
    //     return velocidadeLimite;
    // }

    public static double getVelocidadeLimite () {
        return velocidadeLimite;
    }

    public void imprime() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
        // O this faz referência ao objeto criado e o conteúdo dos atributos naquele objeto
        // Como velocidadeLimite é um atributo static (de classe), não faz sentido usar o this
        System.out.println("Velocidade Limite: " + velocidadeLimite);
    }

}