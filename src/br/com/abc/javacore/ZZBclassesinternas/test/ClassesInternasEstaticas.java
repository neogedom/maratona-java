package br.com.abc.javacore.ZZBclassesinternas.test;

/**
 * ClassesInternasEstaticas
 */
//Classes estáticas são como se fosse métodos estáticos
class Externa {
    static class Interna {
        public void imprimir () {
            System.out.println("oi");
        }
    }
}
public class ClassesInternasEstaticas {

    public static void main(String[] args) {
        //Chamando classe interna estática
        Externa.Interna teste = new Externa.Interna();
        teste.imprimir();
        Interna2 teste2 = new Interna2();
        teste2.imprimir();
    }

    static class Interna2 {
        public void imprimir () {
            System.out.println("oi dentro do interna 2");
        }
    }
}