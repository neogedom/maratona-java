package br.com.abc.javacore.Npolimorfismo.classes;

/**
 * Gerente
 */
public class Gerente extends Funcionario {

    private double pnl;
    
    @Override
    public void calcularPagamento(){
        this.salario += pnl;
    }

    public Gerente(String nome, double salario, double pnl) {
        super(nome, salario);
        this.pnl = pnl;
    }

    public double getPnl() {
        return pnl;
    }

    public void setPnl(double pnl) {
        this.pnl = pnl;
    }

}