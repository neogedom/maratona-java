package br.com.abc.javacore.Xnio.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//Curiosidade: Nos EUA, ninguém usa .rar
public class ZipandoTest {

    public static void main(String[] args) {

        // Para zipar preciso de três coisas:
        // 1. onde vamos salvar o zip
        Path dirZip = Paths.get("pasta/subpasta");
        // 2. onde nosso arquivo está
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
        // 3. o nome do nosso arquivo zip
        // .resolve() para juntar com o caminho colocado na variável dirZip
        Path zipFile = dirZip.resolve("arquivo.zip");

        // Lembre-se de criar o zip em outra pasta que não é a que estão os arquivos que
        // está tentando zipar, pois o DirectoryStream irá tentar pegar o .zip criado lá
        // pelo ZipFileOutputStream ocasionando na tentativa de zipar ele mesmo

        // Para zipar usamos o OutputStream para zipar arquivos: ZipOutputStream
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
                // Para adicionar todos os arquivos dentro da subpasta, eu devo percorrer as
                // subpastas
                // Fazemos isso com a interface DirectoryStream apontando o Path como generics
                // Usamos aqui o caminho da supasta onde estão os arquivos que serão zipados
                DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles);) {

            for (Path path : stream) {
                System.out.println(path);
                // a ZipEntry espera o nome do arquivo como construtor
                // Pegamos o path atual da iteração por onde o DirectoryStream está percorrendo
                // ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                // Ao chamar o putNextEntry, preparamos a próxima entrada
                zip.putNextEntry(new ZipEntry(path.getFileName().toString()));
                // Agora vamos efetivamente copiar os arquivos, lendo esse arquivo e escrevendo
                // com o ZipOutputStream
                //FileInputStream fis = new FileInputStream(path.toFile());

                BufferedInputStream bf = new BufferedInputStream(new FileInputStream(path.toFile()));
                // Pegando os bytes de fis e escrever dentro de buff
                byte[] buff = new byte[2048];
                int bytesRead;

                // // read(buff) lê até o tamanho de buff
                while ((bytesRead = bf.read(buff)) != -1) {
                    // write() lê o que está no array de bytes buff, da posição 0, colocando blocos
                    // de bytes do tamanho de bytesRead
                    // No entanto, não é obrigatório colocar o 0 e o bytesRead. Foi só pra otimizar
                    zip.write(buff, 0, bytesRead);
                }

                zip.flush();
                zip.closeEntry();

                // O close do fis veio pra cá pq precisou ser criado dentro do for
                //o close do bf fecha o close do FileInputStream
                bf.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Arquivo gravado com sucesso");
        }

    }

}