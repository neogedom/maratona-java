package br.com.abc.javacore.ZZBclassesinternas.test;

/**
 * Classes dentro de métodos ou classes locais
 */
public class ClassesLocaisTest {

    private String nome = "Vinícius";

    public void fazAlgumaCoisa() {
        final String sobrenome = "Gomes";
        class Interna {
            public void imprimeNomeExterno() {
                System.out.println(nome);
                // Só é possível chamar atributos locais (do método) dentro de classes locais se
                // eles forem finais
                // Pois existe a possibilidade de a classe durar mais que o método e ocorrer em
                // uma tentativa de uso do atributo sem que ele exista no heap de memória (Java 7)
                // No Java 8, funciona pq ele entende que aquele atributo deve ser final ou effectively
                System.out.println(sobrenome);
            }
        }

        // Para que eu possa ter acesso ao método da classe interna de dentro do método,
        // eu preciso criar um objeto dentro da classe interna
        // Fora da classe fazAlgumaCoisa não é possível usar a classe Interna
        Interna in = new Interna();
        in.imprimeNomeExterno();
    }

    public static void main(String[] args) {
        ClassesLocaisTest externa = new ClassesLocaisTest();
    }
}