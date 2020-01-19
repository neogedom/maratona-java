package br.com.abc.javacore.ZZIdefault.interfaces;

/**
 * MyList
 */
public interface MyList {

    // No java 8 é possível criar método estático na interface
    // desde que ele tenha um corpo
    // Isso deve mudar o design dos programas em Java, já que as classes
    // utilitárias (tipo o Collections) deviam ser feitos em classes
    // com métodos estáticos
    static void sort() {
        System.out.println("dentro do sort");
    }


    //Sem o default, as interfaces do Java deviam ficar paradas no tempo
    // pois adicionar novos métodos estáticos a interfaces, significa quebrar o código 
    // de todo mundo
    default void remove(){
        System.out.println("dentro do remove");
    }
}