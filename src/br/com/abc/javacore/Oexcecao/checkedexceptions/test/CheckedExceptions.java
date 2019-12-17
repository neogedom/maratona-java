package br.com.abc.javacore.Oexcecao.checkedexceptions.test;

import java.io.File;
import java.io.IOException;

/**
 * CheckedExceptions
 */
// Marcado com a palavra reservada throws, as checked exceptions obrigam o programador a 
// tratá-las, se vierem a acontecer
public class CheckedExceptions {
    public static void main(String[] args) {
        
        //Como o método criarArquivo lança a exceção e eu chamo ele aqui,
        // tenho que tratar. Poderia até lançar tbm, mas como o método é a base
        // da pilha de métodos, o programa vai travar se eu não tratar
        // try {
        //     criarArquivo(); 
        // } catch (IOException e) {
        //    e.printStackTrace();
        // }

        abrirArquivo ();
       
    }

    // O método é estático pq está na mesma classe do método main e vai ser acessado por ele
    //throws para avisar o método que chama que pode acontecer uma exceção e que ele se prepare
    //o throws é necessário quando se está lançando exceções do tipo checked
    public static void criarArquivo() throws IOException {
        File file = new File("teste.txt");
        // O método createNewFile lança uma exceção do tipo checked (IOException). E exige que ela seja tratada
        // caso contrário, acusa erro de compilação
        // try (tente fazer isso), se der errado, catch (pegue essa exceção)
        try {
            // Quando vc cria o bloco try - catch e coloca alguma exceção como parâmetro do catch
            // você precisa colocar algum código que possivelmente lance a exceção do parâmetro
            // dentro do try
            System.out.println("Aquivo criado? " + file.createNewFile());
            // Acontecendo algo com a linha acima, o java pula direto pro catch
            System.out.println("Arquivo criado");
        } catch (IOException e) {
           // Imprimindo qual tipo de erro aconteceu
           // printStackTrace imprime a pilha de exceções
           e.printStackTrace();
           
           //Dessa forma, trato a exceção nesse método, mas lanço ela pra quem chama dar mais tratamento
           throw e;
        }
         
    }

    public static String abrirArquivo() {
        File file = new File("Teste.txt");
        try {
            System.out.println("Arquivo criado: " + file.createNewFile());
            System.out.println("Abrindo um arquivo");
            System.out.println("Fazendo a leitura do arquivo");
            //throw new Exception();
            System.out.println("Escrevendo no arquivo");
            //Isso não vai ser executado se acontecer uma exceção em uma das linhas acima
           // System.out.println("Fechar o arquivo");
           return "valor";
        } catch (Exception e) {
            // POr saber que pode ser que a linha de fechamento de arquivo não execute,
            // coloco ela pra fechar o arquivo no catch, que será executado independente
            // de acontecer uma exceção. Só aqui assim eu repito código
            //System.out.println("Fechar o arquivo");
            System.out.println("Dentro do catch");
            e.printStackTrace();
            return null;
        } 
        // Você também pode colocar o finally imediatamente depois do try, desde que remova o catch
        finally {
            // Por causa de evitar a duplicação de código, existe o bloco finally. 
            // Ele será executado independente de qualquer coisa (inclusive, se há retorno)
            System.out.println("Fechar o arquivo");
        }

        
    }
}
