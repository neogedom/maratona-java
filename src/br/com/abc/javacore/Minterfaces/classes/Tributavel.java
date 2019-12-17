package br.com.abc.javacore.Minterfaces.classes;

/**
 * Tributavel
 */
// interface é como um contrato
// Ela vai dizer o que uma classe deve fazer, mas não como ela deve fazer
// Interface é como se fosse uma classe abstrata completamente abstrata (sem métodos concretos)
// É convenção terminar as interfaces com "vel" (adjetivos) ou começando com I
// Trocamos a palavra class por interface
// Assim como classes abstratas, interfaces não podem ser final
// Você não estende uma interface, você implementa
public interface Tributavel {

    // Os atributos de uma interface são implicitamente sempre public static final
    double IMPOSTO = 0.2;

    // Implicitamente todos os métodos são public e abstract
    void calculaImposto();

    
}