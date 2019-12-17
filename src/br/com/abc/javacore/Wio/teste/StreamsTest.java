package br.com.abc.javacore.Wio.teste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * StreamsTest
 */
// Streams são fluxos de dados
// Buffer: ao invés de ler diretamente do disco, você lerá da memória
// InputStream para ler e OutputStream para escrever
public class StreamsTest {
    public static void main(String[] args) {
        leitorTunado();
    }

    private static void gravador() {

        byte[] dados = { 65, 66, 67, 68, 69, 70 }; // esses bytes correspondem a ABCDEF
        // InputStream implementa a interface Closeable, por isso pode usar o try -
        // resources
        // Se você quiser continuar escrevendo no arquivo sem sobrescrevê-lo, você deve
        // adicionar um argumento
        // true dentro do construtor de FileOutputStream
        // As classes OutputStream automaticamente criam o arquivo
        try (FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")) {
            // Gravando o array de bytes no meu arquivo, forma 1
            // for(Byte b : dados) {
            // gravador.write(b);
            // }
            // Gravando o array de bytes no meu arquivo, forma 2
            gravador.write(dados);
            System.out.println("Dados gravados com sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Com o Buffer melhora no desempenho, principalmente em arquivos muito grandes
    private static void gravadorTunado() {

        // Jeito longo 
        // FileOutputStream gravador = new FileOutputStream("pasta/stream.txt");
        // BufferedOutputStream bf = new BufferedOutputStream(gravador);

        byte[] dados = { 65, 66, 67, 68, 69, 70 }; // esses bytes correspondem a ABCDEF
        // InputStream implementa a interface Closeble, por isso pode usar o try -
        // resources
        // Se você quiser continuar escrevendo no arquivo sem sobrescrevê-lo, você deve
        // adicionar um argumento
        // true dentro do construtor de FileOutputStream
        // As classes OutputStream automaticamente criam o arquivo
        // O 4098 representa o tamanho de memória dedicada ao buffer, por padrão ele tem 8142 bytes
        try (BufferedOutputStream gravadorBuffer = new BufferedOutputStream (new FileOutputStream("pasta/stream.txt"), 4098)) {
            // Gravando o array de bytes no meu arquivo, forma 1
            // for(Byte b : dados) {
            // gravador.write(b);
            // }
            // Gravando o array de bytes no meu arquivo, forma 2
            gravadorBuffer.write(dados);

            //Como no Stream é possível fechar o túnel antes de mandar todos os dados
            // por segurança usamos o flush(), que manda o túnel "cuspir" tudo que ele tem antes 
            // de fechar
            gravadorBuffer.flush();
            System.out.println("Dados gravados com sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitor() {
        try (FileInputStream leitor = new FileInputStream("pasta/stream.txt")) {
            // A leitura é feita byte a byte e quando chega no final do arquivo, retorna -1
            int leitura;
            while ((leitura = leitor.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(" " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorTunado() {
        try (BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"))) {
            // A leitura é feita byte a byte e quando chega no final do arquivo, retorna -1
            int leitura;
            while ((leitura = leitorBuffer.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(" " + b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}