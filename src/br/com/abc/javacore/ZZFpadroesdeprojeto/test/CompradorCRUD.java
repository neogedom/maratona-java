package br.com.abc.javacore.ZZFpadroesdeprojeto.test;
import java.util.List;
import java.util.Scanner;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Comprador;
import br.com.abc.javacore.ZZFpadroesdeprojeto.db.CompradorDAOImpl;

/**
 * CompradorCRUD
 */
public class CompradorCRUD {

    private static Scanner teclado = new Scanner(System.in);

    public static void executar(int op) {
        switch (op) {
        case 1:
            inserir();
            break;
        case 2:
            atualizar();
            ;
            break;
        case 3:
            listar();
            break;
        case 4:
            buscarPorNome();
            break;
        case 5:
            deletar();
            break;
        }
    }

    public static void inserir() {
        Comprador c = new Comprador();
        System.out.println("Nome:");
        c.setNome(teclado.nextLine());
        System.out.println("CPF:");
        c.setCpf(teclado.nextLine());
        CompradorDAOImpl.save(c);
    }

    public static void atualizar() {
        System.out.println("Selecione um comprador da lista");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = teclado.nextLine();
        System.out.println("Novo cpf ou enter para manter o mesmo");
        String cpf = teclado.nextLine();
        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!cpf.isEmpty()) {
            c.setCpf(cpf);
        }
        CompradorDAOImpl.update(c);
    }

    public static List<Comprador> listar() {
        List<Comprador> compradorList = CompradorDAOImpl.selectAll();
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf());
        }

        return compradorList;
    }

    public static List<Comprador> buscarPorNome() {
        System.out.println("Digite o nome do comprador");
        List<Comprador> compradorList = CompradorDAOImpl.searchByName(teclado.nextLine());
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf());
        }
        return compradorList;
    }

    public static void deletar() {
        System.out.println("Selecione um comprador da lista");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("S")) {
            CompradorDAOImpl.delete(c);
        }

    }
}