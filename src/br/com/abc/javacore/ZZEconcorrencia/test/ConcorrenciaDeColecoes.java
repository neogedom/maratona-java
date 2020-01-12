package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcorrenciaDeColecoes
 */
public class ConcorrenciaDeColecoes {

    //Coleções que não implementam o comportamento CopyOnWrite para serem thread-safe
    // ConcurrentHashMap
    // ConcurrentLinkedQueue
    // ConurrentLinkedDeque
    // ConcurrentSkipListMap
    // ConcurrentSkipListSet
    // Enquanto você está iterando, esses objetos não vão manter a referência para o estado de quando
    // você os obteve. Teoricamente há a possibidade de a iteração nunca terminar. O método sixe vai 
    // retornar um valor inconsistente. Isso quer dizer que essas coleções são weakly consistents
    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        //putIfAbsent não subsititui o valor se a chave a ser inserida já existir
        // Ele apenas retorna o valor existente e não insere nada
        map.putIfAbsent("1", "2");
        System.out.println(map.get("1"));

        
    }
}