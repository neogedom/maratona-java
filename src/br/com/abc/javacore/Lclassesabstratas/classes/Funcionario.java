package br.com.abc.javacore.Lclassesabstratas.classes;

/**
 * Funcionario
 */
// Você nunca poderá instanciar (usar new) em uma classe abstrata
// Usamos classes abstratas por questões arquiteturais
// Classes abstratas pode conter métodos abstratos (Métodos que não possuem implementação)
// Sendo o objetivo de uma classe abstrata ser estendida, você não pode adicionar o modificador final
// Classes abstratas podem estender outras classes abstratas
public abstract class Funcionario extends Pessoa {
    
    protected String clt;
    protected double salario;

    public Funcionario () {
    } 
    
    public Funcionario (String nome, String clt, double salario) {
        super(nome);
        this.clt = clt;
        this.salario = salario;
    } 

    //Se eu reescrever a classe abstrata da classe pai nessa classe abstrata e transformar
    // ela em concreta, ela não vai ser mais obrigatória nas classes filhas dessa aqui
    @Override
    public void imprime() {

    }

    //Eu posso redeclarar uma método abstrato
    // public abstract void imprime();

    // Ao colocar o abstract em funcionário, eu obrigo que todas as classes filhas tenham que implementar
    //calculaSalario de seu próprio jeito
    public abstract void calculaSalario(); //Além disso, métodos abstratos não podem ter corpo, por isso terminam com ;

    // Se você tiver pelo menos um método abstrato, toda a classe deve ser abstrata
    // Mas classes abstratas não são obrigadas a terem métodos abstratos   


    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario [clt=" + clt +  ", salario=" + salario + "]";
    }
    
}