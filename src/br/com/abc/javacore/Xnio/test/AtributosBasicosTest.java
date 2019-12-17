package br.com.abc.javacore.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * AtributosBasicosTest
 */
public class AtributosBasicosTest {

    // Atributos básicos são aqueles que todo SO tem a respeito dos arquivos: data de modificação, permissões, etc.
    public static void main(String[] args) throws IOException {
        // Criando um objeto GregorianCalendar direto evita de eu criar em duas linhas
        // Calendar.getInstance()
        //Pq o GregorianCalendar tem um construtor que aceita ano, mês, dia
        // Como é um Date, preciso pegar o getTime()
        Date primeiroDeDezembro = new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime();
        File file = new File("folder2/arquivo.txt");
        file.createNewFile();
        //Para modificar a data que o arquivo foi lido da última vez no jeito antigo
        // getTime pq ele espera um long
        // Não confunda! getTime no Date retorna long e getTime no Calendar retorna um Date
        file.setLastModified(primeiroDeDezembro.getTime());
        // Na classe antiga ele imprime em milissegundos (long)
        System.out.println(file.lastModified());

        file.delete();
        Path path = Paths.get("folder2/arquivo_path.txt");
        Files.createFile(path);
        // O setLastMofiedTime precisa de um objeto do tipo FileTime como argumento
        // fromMilies para trabalhar com milissegundos
        FileTime fileTime = FileTime.fromMillis(primeiroDeDezembro.getTime());
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        path = Paths.get("src\\br\\com\\abc\\javacore\\Aintroducaoclasses\\classes\\Carro.java");
        
        // No jeito antigo é file.canRead(), canExecute() e canWrite()
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        
        //Interfaces e classes para trabalhar com os atributos
        //BasicFileAttibutes (atributos básicos para todos os SO), 
        // PosixFileAttributes (atributos básicos sistemas Unix), 
        // DosFileAttributtes (atributos básicos sistemas windows)

        // Os atributos da classe BasicFileAttributes são read-only. Não dá pra modificar
        // como no jeito antigo
        // no readAttibutes é esperando o caminho do arquivo e a interface pela qual serão lidos os atributos
        BasicFileAttributes atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Criação: " + atributosBasicos.creationTime());
        System.out.println("Último acesso: " + atributosBasicos.lastAccessTime());
        System.out.println("Modificado da última vez: " + atributosBasicos.lastModifiedTime());
        System.out.println("-------------------------");
        // System.out.println("É diretório? " + atributosBasicos.isDirectory());
        // System.out.println("É link simbólico? " + atributosBasicos.isSymbolicLink());
        // System.out.println("É arquivo regular? " + atributosBasicos.isRegularFile());

        // Para modificar temos outras interfaces
        //  temos a BasicFileAttrbutesView, PosixFileAttributesView e DosFileAttributesView, 
        // FileOwnerAttributeView (usado para setar o dono), AclFileAttributeView (permissões avançadas)

        // Lembre-se de usar o View para quando quiser fazer modificações. O método aqui é get... e não read...
        BasicFileAttributeView bView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        //Todos os argumentos de setTimes são do tipo FileTime
        FileTime lastModifiedTime = atributosBasicos.lastModifiedTime();
        FileTime createTime = atributosBasicos.creationTime();
        // System.currentTimeMilis para pegar o long dos milissegundos atual
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
        bView.setTimes(lastModifiedTime, lastAccessTime, createTime);
        //Depois de alterar os atributos, é necessário lê-los de novo para ver as alterações
        atributosBasicos = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Criação: " + atributosBasicos.creationTime());
        System.out.println("Último acesso: " + atributosBasicos.lastAccessTime());
        System.out.println("Modificado da última vez: " + atributosBasicos.lastModifiedTime());
        
         


        
    }
}