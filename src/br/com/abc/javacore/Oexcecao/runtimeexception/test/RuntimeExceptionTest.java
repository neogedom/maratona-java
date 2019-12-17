package br.com.abc.javacore.Oexcecao.runtimeexception.test;

// Exceções do tipo Checked, o compilador espera que você dê o tratamento para ela (você é obrigado a fazer isso)
// Exceções do tipo Unchecked, você não precisa criar nenhum tipo de tratamento
// Geralmente, exceções do tipo unchecked são erros de lógica (ex.: acessar posição no array que não existe)
// e exceções do tipo checked estão para além
// do controle do programador (ex.: servidor de banco de dados fora do ar)
// Todas as exceções filhas de RuntimeException (incluindo a própria) são unchecked
// Aquelas filhas de Exception que não são filhas e nem a própria RuntimeException são checked (você precisa tratar)


// Erros em tempo de execução (Runtime), geralmente são causados pela lógica do programador
public class RuntimeExceptionTest {
    
    public static void main(String[] args) {
    //     Object o = null;
    //     //ArithmeticException
    //     // Quando tento dividir inteiro por zero
    //     // int a = 10 / 0;
    //     //Dá pra tratar assim:
    //     int a = 10;
    //     int b = 0;
    //     if (b != 0) {
    //         int c = a/b;
    //         System.out.println(c);
    //     }
        
    //     //NullPointerException
    //     //Quando tento chamar um método por uma variável de referência não inicializada
    //     // Lembre-se: variável de referência não chama nada. O objeto que chama
    //     // A variável de referência (classe) é só o "controle remoto"
    //    // System.out.println(o.toString());

    //    //ArrayIndexOutOfBoundException
    //    //QUando tento chamar uma posição do array que não existe
    //    // Lembre-se: a posição máxima do array[n] é n-1
    //    try {
    //        // Embora as RuntimeExceptions sejam unchecked (não são obrigadas serem tratadas)
    //        // Dá para usar o try catch com elas
    //     int[] array = new int[2];
    //     System.out.println(array[2]);
    //     // Seja o mais expecífico possível na captura da exceção, embora eu possa pegar as classes mais gerais
    //     // (por causa do polimorfismo)
    //    } catch (ArrayIndexOutOfBoundsException e) {
    //        e.printStackTrace();
    //    }

    //    // Quando acontece um catch, o código continua funcionando
    //    System.out.println("Bloco depois do catch");
      

    //    // O try - catch não é obrigatório para RuntimeExceptions pq como é um erro no código, existem 
    //    // outras maneiras de corrigir ele (corrigindo o código)

    //Não precisa de try - catch, mas se quiser pode colocar
        try {
            divisao(10, 0);
        } catch (RuntimeException e) {
            //getMessage retorna a mensagem da exceção, que pode ser mostrada para clientes
           System.out.println(e.getMessage());
           // O printStackTrace é para ser mostrado apenas para desenvolvedores
           e.printStackTrace();
        }
       
        
    }

    public static void divisao(int num1, int num2) {
        if (num2 == 0) {
            //Não é a exceção correta
           // throw new ArithmeticException();
           // A exceção correta é essa
           //throw para lançar uma exceção. Quando ele é encontrado, ele volta para o método que o chamou
           throw new IllegalArgumentException("Passe um valor diferente de 0 para num2");
        }
        int result = num1/num2;
        System.out.println(result);

    }
}