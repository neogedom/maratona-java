package br.com.abc.javacore.Oexcecao.checkedexceptions.test;

import java.io.FileNotFoundException;

import br.com.abc.javacore.Oexcecao.checkedexceptions.classes.Funcionario;
import br.com.abc.javacore.Oexcecao.checkedexceptions.classes.Pessoa;

public class SobrescritaComExceptionsTest {
    public static void main(String... args) {
        Funcionario funcionario = new Funcionario();
        Pessoa pessoa = new Pessoa();

        try {
            funcionario.salvar();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Esse aqui precisa tratar a exceção
        //pessoa.salvar();
    }
}