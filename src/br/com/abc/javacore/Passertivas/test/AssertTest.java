package br.com.abc.javacore.Passertivas.test;

/**
 * AssertTest
 */
public class AssertTest {

    public static void main(String[] args) {
        //calculaSalario(-10000);]
        diasDaSemana (9);
    }

    // É uma péssima prática usar o assert para métodos públicos
    // Com o método público, corre o risco de alguém chamar seu método de forma
    // errada
    private static void calculaSalario(double salario) {
        // Assert obriga que o valor entre parênteses seja true, ou senão vai dar um
        // erro sério
        // O assert faz com que você não precise confiar nos seus pressupostos (ex.: que
        // ninguém nunca vai dividir por zero)
        // Com o assert, você não precisa do if-else. Nesse caso, se o salario > 0, tem
        // algo
        // muito errado
        // Usado para teste, durante a codificação. Eles estão desativados por padrão
        assert (salario > 0) : "O salário não deve ser menor que zero";
    }

    // Se você quiser usar uma classe publica, ao inves do assert você tem que fazer
    // assim
    public static void calculaSalario2(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException();
        }
    }

    // Exemplo de um caso em que o assert pode ser colocado em método público
    public static void diasDaSemana(int dia) {
        switch (dia) {
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            break;
        case 6:
            break;
        case 7:
            break;
        default:
        // Como temos absoluta certeza que de não há dia 8 na semana,
        // dá pra usar assert falso aqui. Isso vai impedir alguém de 
        // entrar com um valor diferente de 1 - 7
            assert false: "Dia deve estar entre 1 e 7";
        }
    }

}