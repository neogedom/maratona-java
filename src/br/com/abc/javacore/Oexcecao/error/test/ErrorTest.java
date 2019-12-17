package br.com.abc.javacore.Oexcecao.error.test;

// Exceções são classes e todas elas são filhas de Throwable
// Exceções podem ser tratadas. Quando acontece um Error, seu programa provavelmente irá parar de funcionar
// Você não precisa criar tratamentos para Errors. Se aconteceu um, já era
public class ErrorTest {
    public static void main(final String[] args) {
        stackOverflowError();
    }

    public static void stackOverflowError () {
        // Erro de recursividade
        // Os métodos formam uma pilha ao chamarem uns aos outros
        // Quando há recursividade, o método chama ele mesmo indefinidamente até estourar a quantidade 
        // disponível de memória
        stackOverflowError();



        // Se não houver nenhum tratamento em nenhum dos métodos da pilha, mesmo para exceções, 
        // o programa para de executar
    }
    
}