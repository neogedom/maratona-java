package br.com.abc.javacore.Jmodificadorfinal.classes;

import br.com.abc.javacore.Isobrescrita.classes.Comprador;

/**
 * Carro
 */
// Com o modificador final na classe, significa que a classe não pode ser
// estendida. Isso fere a orientação à objeto, mas foi necessário 
// A classe String é uma classe final
public final class Carro {

    // Aqui a velocidade limite não pode mudar, independente do que aconteça
    // por isso ela deve ser uma constante
    // Constante no java é final
    // Obrigatoriamente, você deve inicializar uma constante final
    // E deve escrever a constante final em maiúsculo
    // Além disso, independente do objeto, a velocidade deve ser a mesma
    // Por isso usamos static
    private static final double VELOCIDADE_LIMITE = 220;
    private final Comprador COMPRADOR = new Comprador();
    private String nome;
    private String marca;

    // public Carro() {
    //     // Se a constante não for estática, dá pra inicializar no construtor
    //     // mas se for estática, ela já existe junto com a classe
    //     VELOCIDADE_LIMITE = 200;
    // }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", nome=" + nome + "]";
    }

    // Só cria o método get, pq não pode mudar constantes
    public static double getVelocidadeLimite() {
        return VELOCIDADE_LIMITE;
    }

    public Comprador getCOMPRADOR() {
        return COMPRADOR;
    }

    //Em métodos com modificador final, você não pode sobrescrever o método
    // Significa que o método é perfeito
    // Mas você pode fazer sobrecarga
    // public final void imprime() {


    // }

    
}