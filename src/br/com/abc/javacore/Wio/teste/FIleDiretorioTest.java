package br.com.abc.javacore.Wio.teste;

import java.io.File;
import java.io.IOException;

public class FIleDiretorioTest {
    public static void main(String[] args) {
    //     // Lembre-se, essa linha só cria o objeto. Não cria arquivo, nem diretório
    //     File diretorio = new File("folder");
    //     // Isso cria diretórios e o createNewFile cria arquivos
    //     boolean mkdir = diretorio.mkdir(); // esse é um comando oriundo do Linux. Ele retorna booleano
    //     System.out.println("Diretório criado? " + mkdir);

    //     // // Criando arquivo dentro do folder criado acima com caminho absoluto
    //     // File file = new File(
    //     //         "C:\\Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em Java\\Maratona Java\\JavaOnline\\folder\\arquivo.txt");
    //     // try {
    //     //     boolean newFile = file.createNewFile();
    //     //     System.out.println("Arquivo criado? " + newFile);
    //     // } catch (IOException e) {
    //     //     e.printStackTrace();
    //     // }

    //     // Criando arquivo dentro do folder criado acima passando diretório
    
    
    //     File file = new File(diretorio, "arquivo.txt");
        
    //    try {
    //     boolean newFile = file.createNewFile();
    //     System.out.println("Arquivo criado? " + newFile);
    //    } catch (IOException e) {
    //         e.printStackTrace();
    //    }

    //    //Se não passar o mesmo diretório para o objeto de renomeio, ele criará outro arquivo ao
    //    // executar o método renameTo
    //    File arquivoNovoNome = new File(diretorio, "arquivo_renomeado.txt");
       
    //    //o método renameTo não recebe uma String. Ele recebe um objeto file
    //    // Também retorna booleano
    //    boolean renamed = file.renameTo(arquivoNovoNome);
    //    System.out.println("Renomeado? " + renamed);

    //    //renomeando um diretório
    //    File diretorioRenomeado = new File("folder2");
    //    boolean diretorioRenamed = diretorio.renameTo(diretorioRenomeado);
    //    System.out.println("Diretório renomeado? " + diretorioRenamed);

    buscarArquivos();


    }


    // Buscar arquivos dentro de diretórios
    // Existem formas mais robustas para procurar arquivos em diretórios
    // Mas essa é a forma mais rápida e básica pra buscar 
    public static void buscarArquivos() {
        File file = new File("C:\\Users\\vinny\\OneDrive\\Documentos\\Estudos\\Programação em Java\\Maratona Java\\JavaOnline\\");
        String [] list = file.list(); // retorna um array de Strings
        for (String arquivo : list) {
            System.out.println(arquivo);    
            
        }
        
    }
}