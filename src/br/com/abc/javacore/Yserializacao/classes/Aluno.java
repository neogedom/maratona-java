package br.com.abc.javacore.Yserializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Aluno
 */

// implementar a interface Serializable para indicar para o Java que essa classe
// pode ser serializada
// A Serializable não tem método nenhum. Ela é uma interface flag, ela serve
// apenas para indicar que os
// objetos dessa classe serão serializáveis
// Cuidado: ao desserializar uma classe em cache, ela não pode ter sido
// modificada, senão dá InvalidClassException
// Ao serializar um código, o Java gera um serialVersionUID
public class Aluno implements Serializable {
    private Long id;
    private String nome;
    // Tornar um atributo transient significa que ele não será desserializado
    private transient String password;
    private static String nomeEscola = "IFMS :)";
    private transient Turma turma;

    // Se caso você não tem acesso à classe da associação e não pode colocá-la como
    // Serializável, fazer uma serialização manual
    // A interface Serializable verificar se tem o método writeObject antes de
    // executar a classe
    // Para usar essa estratégia, o atributo turma deve ser transient
    private void writeObject(ObjectOutputStream oos) {
        try {
            // Primeiro tenta escrever os atributos não estáticos e não transientes do
            // objeto
            oos.defaultWriteObject();
            // writeUTF para gravar String no lugar do atributo transiente
            oos.writeUTF(turma.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {

            // A ordem das linhas aqui devem seguir a mesma ordem de writeObject
            ois.defaultReadObject();
            turma = new Turma(ois.readUTF());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", password=" + password + ", nomeEscola=" + nomeEscola
                + ", turma=" + turma + "]";
    }

    public Aluno(Long id, String nome, String password) {
        // Durante a desserialização, o construtor não é chamado
        // Se tivéssemos herança, o super() (implícito ou explicito) não seria chamado
       // Por isso se essa classe tiver uma classe pai não serializável, não dá erro 
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}