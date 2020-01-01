package br.com.abc.javacore.ZZBclassesinternas.test;

// Classes aninhadas (nested classes) ou classes internas (inner classes)
// Motivação: manipular eventos em interfaces gráficas
public class ClassesInternasTest {

    private String nome = "Vinícius, Neo Gedom";

    class Interna {

        // Ela tem acesso a todos atributos da classe externa, inclusive os privados
        public void verClasseExterna() {
            System.out.println(nome);
            //Usando o this para chamar o objeto da classe interna
            System.out.println(this);
            //Usando o this para chamar o objeto da classe externa
            System.out.println(ClassesInternasTest.this);
        }

    }

    public static void main(String[] args) {
        // Criando objetos da classe interna dentro do método main
        // Primeiro, cria um objeto da classe externa à classe interna
        ClassesInternasTest externa = new ClassesInternasTest();
        // Depois chama a classe interna (como se fosse um atributo estático) e cria um
        // objeto da classe interna
        ClassesInternasTest.Interna interna = externa.new Interna();
        ClassesInternasTest.Interna interna2 = new ClassesInternasTest().new Interna();
        interna.verClasseExterna();
        interna2.verClasseExterna();
    }

}

/**
 * Externa
 */
// class Externa {

// private String nome = "Vinícius, Neo Gedom";

// /**
// * Criar uma classe interna é só criar uma classe dentro de outra classe
// * É como se a classe interna fosse um método
// */
// class Interna {

// // Ela tem acesso a todos atributos da classe externa, inclusive os privados
// public void verClasseExterna () {
// System.out.println(nome );
// }

// }
// }