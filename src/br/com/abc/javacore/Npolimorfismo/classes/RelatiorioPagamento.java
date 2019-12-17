package br.com.abc.javacore.Npolimorfismo.classes;

/**
 * RelatiorioPagamento
 */
public class RelatiorioPagamento {

    // COm polimorfismo eu não preciso dessas linhas
    // public void relatorioPagamentoGerente(Gerente gerente) {
    //     System.out.println("Gerando relatório de pagamento para a gerência:");
    //     gerente.calcularPagamento();
    //     System.out.println("Nome: " + gerente.getNome());
    //     System.out.println("Salário desse mês: " + gerente.getSalario());
    // }

    // public void relatorioPagamentoVendedor(Vendedor vendedor) {
    //     System.out.println("Gerando relatório de pagamento para os vendedores:");
    //     vendedor.calcularPagamento();
    //     System.out.println("Nome: " + vendedor.getNome());
    //     System.out.println("Salário desse mês: " + vendedor.getSalario());
    // }

    // funcionario aqui é um parâmetro polimórfico porque é mais genérico que que o chama
    public void relatiorioPagamentoGenerico(Funcionario funcionario) {
        System.out.println("Gerando relatório de pagamento para os funcionários:");
        funcionario.calcularPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário desse mês: " + funcionario.getSalario());

        
        // Com o instanceof dá pra testar se a variável de referência originalmente é do tipo Gerente
        if (funcionario instanceof Gerente) {
            //Cast explícito para imprimir valores dos atributos da classe filha mais específica
            // Funcionário não tem pnl, mas gerente tem
            // Aqui só devolvi a referência para o objeto gerente que veio em funcionario para outra classe gerente
            Gerente gerente = (Gerente) funcionario;
            System.out.println("Participação nos lucros: " + gerente.getPnl());
        } else if (funcionario instanceof Vendedor) {
            //Vendedor vendedor = (Vendedor) funcionario;
            //Cast direto
            System.out.println("Total de vendas: " + ((Vendedor) funcionario).getTotalVendas());
        }
    }
}