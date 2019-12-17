package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/**
 * DosFileAttributesTest
 */
public class DosFileAttributesTest {

    public static void main(String[] args) {
        Path path = Paths.get("folder2/teste.txt");
        try {
            //Files.createFile(path);
            //Adicionando um atributo oculto e um atributo read-only no DOS
            Files.setAttribute(path, "dos:hidden", true);
            //Cuidado pq o readonly é todo minúsculo
            Files.setAttribute(path, "dos:readonly", true);
            //Lembre-se: para ler é a classe sem o View e o método é readAttributes
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());

            //Outro jeito de setar os atributos do DOS
            DosFileAttributeView dView = Files.getFileAttributeView(path, DosFileAttributeView.class);
            dView.setHidden(false);
            dView.setReadOnly(false);
            dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}