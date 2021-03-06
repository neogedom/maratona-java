package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import java.util.List;
import java.util.Scanner;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Carro;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Comprador;
import br.com.abc.javacore.ZZFpadroesdeprojeto.db.CarroDAOImpl;
import br.com.abc.javacore.ZZFpadroesdeprojeto.interfaces.CarroDAO;

/**
 * CarroCRUD
 */
public class CarroCRUD {

    private static Scanner teclado = new Scanner(System.in);
    //Em DAO, instanciar aqui a implementação de carroDAO para db, orientada à interface 
    private static CarroDAO dao = new CarroDAOImpl();

    public static void executar(int op) {
        switch (op) {
        case 1:
            inserir();
            break;
        case 2:
            atualizar();
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
        Carro c = new Carro();
        System.out.println("Nome:");
        c.setNome(teclado.nextLine());
        System.out.println("Placa:");
        c.setPlaca(teclado.nextLine());
        System.out.println("Selecione um dos compradores da lista");
        List<Comprador> compradorLista = CompradorCRUD.listar();
        c.setComprador(compradorLista.get(Integer.parseInt(teclado.nextLine())));
        dao.save(c);
    }

    public static void atualizar() {
        System.out.println("Selecione um carros da lista");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = teclado.nextLine();
        System.out.println("Nova placa ou enter para manter o mesmo");
        String cpf = teclado.nextLine();
        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!cpf.isEmpty()) {
            c.setPlaca(cpf);
        }
        dao.update(c);
    }

    public static List<Carro> listar() {
        List<Carro> carroList = dao.selectAll();
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getPlaca() + " " + c.getComprador().getNome());
        }

        return carroList;
    }

    public static List<Carro> buscarPorNome() {
        System.out.println("Digite o nome do carro");
        List<Carro> carroList = dao.searchByName(teclado.nextLine());
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getPlaca() + " " + c.getComprador().getNome());
        }
        return carroList;   
    }

    public static void deletar() {
        System.out.println("Selecione um carros da lista");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("S")) {
              dao.delete(c);
        }

    }
}