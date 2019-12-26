package br.com.abc.javacore.Zcolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MapTest
 */
// A principal característica do Map é que ele é uma coleção que mantém
// chave:valor
public class MapTest {

    public static void main(String[] args) {
        // O generics do Map exige chave e valor
        // Usando o HashMap, assim como tudo que tem Hash no nome, não dá pra garantir
        // organização
        // Regra: Não podem existir chaves duplicadas
        // Map<String, String> map = new HashMap<>();
        //LinkedHashMap para garantir a ordem de inserção
        Map <String, String> map = new LinkedHashMap<>();

        // Associando chave a valor
        map.put("teklado", "teclado");
        map.put("mause", "mouse");
        map.put("vc", "você");
        // Ao inserir a chave duas vezes, o Java pega o valor da última inserção e
        // associa à chave, substituindo o primeiro valor
        map.put("vc", "voce2");
        map.put("meza", "mesa");

        // Iterando sobre um map
        // Duas formas. 1ª com um for
        // Iterando com for sobre a chave
        // Como na chave não é possível ter elementos duplicados,
        // chamamos o método keySet que retorna um set (uma coleção sem elementos
        // duplicados)
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println("----------------");

        // Retornando os valores de um Map com foreach
        for (String values : map.values()) {
            System.out.println(values);
        }

        System.out.println("----------------");

        //Retornando chave e valor de um Map por meio de um foreach
        // É necessário chamar um Entry, que é uma subinterface,
        // informando no generics qual o tipo da chave e o tipo do valor
        for(Map.Entry <String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }   

    }
}