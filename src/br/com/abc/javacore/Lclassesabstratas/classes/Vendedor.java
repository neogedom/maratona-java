package br.com.abc.javacore.Lclassesabstratas.classes;
/**
 * Vendedor
 */
public class Vendedor extends Funcionario {
    private double totalVendas;

    @Override
    public void calculaSalario() {
        // Você não é obrigado a colocar código aqui, só a sobrescrever
        salario += 0.05 * totalVendas;

    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Vendedor() {
    }

    public Vendedor(String nome, String clt, double salario, double totalVendas) {
        super(nome, clt, salario);
        this.totalVendas = totalVendas;
    }

    @Override
    public String toString() {
        return "Vendedor [Salário=" + salario + ", CLT=" + clt + ", Total de Vendas=" + totalVendas + "]";
    }

    @Override
    public void imprime() {
        System.out.println("dentro do método imprime");
    }
    

}