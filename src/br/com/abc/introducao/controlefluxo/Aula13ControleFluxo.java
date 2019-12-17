package br.com.abc.introducao.controlefluxo;

public class Aula13ControleFluxo {
    public static void main (String args[]){
        byte dia = 5;

        //Tipos possíveis: char, int, byte, short, enum e String
        switch(dia) {
            case 1: 
                System.out.println("domingo");
                break;
            case 2:
                System.out.println("segunda");
                break;
            case 3:
                System.out.println("terça");
                break;
            case 4: 
                System.out.println("quarta");
                break;
            case 5:
                System.out.println("quinta"); // Sem o break, ele executa tudo daqui pra baixo
                break;
            case 6:
                System.out.println("sexta");
                break;
            case 7:
                System.out.println("sábado");
                break;
        }

        //"" para String '' para char
        String sexo = "F";
        switch (sexo) {
            case "f": 
                System.out.println("feminino");
                break;
            case "m":
                System.out.println("masculino");
                break;
            default: 
                System.out.println("Opção inválida");
        }
    }
}