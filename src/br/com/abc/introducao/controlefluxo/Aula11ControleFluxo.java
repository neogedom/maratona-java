package br.com.abc.introducao.controlefluxo;

public class Aula11ControleFluxo {
    public static void main (String args [])
    {
        int idade = 15;
        String status;

        // if (idade < 18) status = "Não adulto";
        // else status = "Adulto";

        //Operador ternário
       // status = condição ? if : else ;
       status = idade < 18 ? "Não adulto" : "Adulto";
        System.out.println(status);
    }

} 