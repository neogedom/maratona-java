package br.com.abc.javacore.ZZCjdbc.test;

import java.util.List;
import java.util.Scanner;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDAO;

/**
 * TesteCRUD
 */
public class TesteCRUD {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            // Usando o parseInt para evitar o bug da classe Scanner que considera o enter
            // como caractere digitado no menu
            op = Integer.parseInt(teclado.nextLine());
            if (op == 0) {
                System.out.println("Saindo do sistema");
                break;
            }

            executar(op);
        }
    }

    public static void executar(int op) {
        switch (op) {
        case 1:
            inserir();
            break;
        case 2:
            atualizar();;
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

    private static void inserir() {
        Comprador c = new Comprador();
        System.out.println("Nome:");
        c.setNome(teclado.nextLine());
        System.out.println("CPF:");
        c.setCpf(teclado.nextLine());
        CompradorDAO.save(c);
    }

    private static void atualizar() {
      System.out.println("Selecione um comprador da lista");
      List<Comprador> compradorList = listar();
      Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
      System.out.println("Novo nome ou enter para manter o mesmo");
      String nome = teclado.nextLine();
      System.out.println("Novo cpf ou enter para manter o mesmo");
      String cpf = teclado.nextLine();
      if(!nome.isEmpty()) {
          c.setNome(nome);
      } 
      if (!cpf.isEmpty()) {
          c.setCpf(cpf);
      }
      CompradorDAO.update(c);
    }

    private static List<Comprador> listar () {
        List<Comprador> compradorList = CompradorDAO.selectAll();
        for(int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("["+i+"] "+c.getNome()+ " "+c.getCpf());
        }

        return compradorList;
    }

    private static List<Comprador> buscarPorNome() {
        System.out.println("Digite o nome do comprador");
        List<Comprador> compradorList = CompradorDAO.searchByName(teclado.nextLine());
        for(int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("["+i+"] "+c.getNome()+ " "+c.getCpf());
        }
        return compradorList;
    }

    private static void deletar() {
        System.out.println("Selecione um comprador da lista");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s")) {
            CompradorDAO.delete(c);
        }
        
      }

    private static void menu() {
        System.out.println("Digite a opção para começar");
        System.out.println("1 - Inserir comprador");
        System.out.println("2 - Atualizar comprador");
        System.out.println("3 - Listar todos os compradores");
        System.out.println("4 - Buscar comprador por nome");
        System.out.println("5 - Deletar");
        System.out.println("0 - Sair");
    }
}