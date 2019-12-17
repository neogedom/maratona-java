package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * PosixFileAttribuesView
 */

// Para rodar essa classe é necessário ter um sistema Linux
public class PosixFileAttributesTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/vinicius/dev/arquivo");

        //O PosixFileAttibutes adiciona os métodos para lidar com grupos e permissões
        // que são nativos dos sistemas Unix
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());

        //Para alterar as permissões
        System.out.println("Alterando as permissões: ");
        //Duas opções para alterar as permissões
        PosixFileAttributeView pView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        

        Set <PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw"); // usa-se o mesmo código das permissões do Linux
        //pView.setPermissions(perms);

        Files.setPosixFilePermissions(path, perms);
        posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());
    }
}