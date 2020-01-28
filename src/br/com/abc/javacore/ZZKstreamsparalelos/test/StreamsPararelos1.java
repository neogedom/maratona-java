package br.com.abc.javacore.ZZKstreamsparalelos.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * StreamsPararelos1
 * É bom usar streams paralelos quando tem uma certa quantidade de valores
 * mas isso varia de processador pra processador
 * OS streams paralelos nem sempre são mais rápidos que os sequenciais
 * por isso sempre vale a pena fazer benchmark
 * Olhe sempre se as streams usam boxing e unboxing. Eles afetam muito a performance 
 * do sistema
 * As operações limit e findFirst são piores com stream paralelos do que com stream sequenciais
 * Pq precisam que os elementos estejam em ordem
 * Não é recomendável usar streams paralelos com quantidades pequenas de dados
 * Algumas coleções performam melhor que outras usando stream paralelos, ex.: Linked list e Stream.iterate são ruins
 * Ter um tamanho definido é essencial para o uso dos streams paralelos, para não correr o risco de percorrer infinitamente
 * a stream a fim de calcular o tamanho dela para fazer a divisão entre as threads
 *  */
public class StreamsPararelos1 {

    public static void main(String[] args) {
        long num = 10_000_000_000L;
        //o for comum performa melhor que os streams
        //por não haver boxing e unboxing
        somaFor(num);
        //somaStreamIterate(num);

        //O stream comum é melhor que o paralelo
        //somaParallelStreamIterate(num);

        //O rangeClosed é a melhor técnica para executar código em streams paralelos
        // mesmo o sequencial já performa muito melhor
        somaRangeClosedStreamIterate(num);
        somaRangeClosedParallelStreamIterate(num);

        //Trocando o número de processadores com os quais as streams paralelas
        // irão trabalhar
        //System.setProperty("java.util.concurrent.ForkJoinPool.commom.paralelism", "12");

    }

    private static void somaFor(long num){
        System.out.println("For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1L; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }


    private static void somaStreamIterate(long num){
        System.out.println("Stream Sequencial");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    private static void somaParallelStreamIterate(long num){
        System.out.println("Stream Paralelo");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    // para melhorar a performance, use os tipos primitivos em Stream
    //isso evita o boxing e o unboxing
    private static void somaRangeClosedStreamIterate(long num){
        System.out.println("Range Closed Stream Sequencial");
        long init = System.currentTimeMillis();
        //usar LongStream evitar boxing e unboxing
        //usando rangeClosed facilita a quebra da stream em duas partes
        // pois o Java já saberá de antemão quantos elementos há na stream
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }


    private static void somaRangeClosedParallelStreamIterate(long num){
        System.out.println("Range Closed Stream Paralelo");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }
}