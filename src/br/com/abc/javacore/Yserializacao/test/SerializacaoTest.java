package br.com.abc.javacore.Yserializacao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.abc.javacore.Yserializacao.classes.Aluno;
import br.com.abc.javacore.Yserializacao.classes.Turma;

/**
 * SerializacaoTest
 */

// Serialização serve para o uso dos frameworks
// O que é? É pegar um objeto e passar ele por um stream (canal de dados)
public class SerializacaoTest {
    // Tarefa: gravar um objeto em arquivo
    public static void main(String[] args) {

        // Sem implementar a interface Seriaizable em Aluno vai dar a exceção
        // NotSerializableException
        gravadorObjeto();
        leitorObjeto();
    }

    // Serializando (gravando) um objeto
    private static void gravadorObjeto() {
        Turma turma = new Turma("Maratona Java");
        Aluno aluno = new Aluno(1L, "Vinícius Gomes", "12345");
        aluno.setTurma(turma);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"));) {
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Desserializando (lendo) um objeto
    private static void leitorObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"));) {
            
            // o readObject() retorna um Object, por isso o cast
            Aluno aluno = (Aluno) ois.readObject(); // Ele vai pedir outro catch, então é só pegar a outra exceção
                              // (ClassNotFoundException) no mesmo catch com a notação do java 7
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}