package br.com.abc.javacore.Oexcecao.customexception;

/**
 * LoginInvalidoException
 */

 // TOdas as exceções do java terminam com a palavra Exception
 // Então é uma boa prática nomear a classe com Exception no final
 // Essa será uma exceção exception pq estende diretamente de Exception
public class LoginInvalidoException extends Exception {

    // Criando minha própria mensagem de exceção
    public LoginInvalidoException () {
        super("Usuário ou senha inválido");

        //Por razões de evolução de software, não coloque métodos para tratamento de exceção aqui
    }

    
}