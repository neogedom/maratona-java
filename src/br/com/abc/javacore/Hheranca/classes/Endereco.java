package br.com.abc.javacore.Hheranca.classes;

public class Endereco {
    private String rua;
    private String bairro;

    public Endereco () {

    }

    public Endereco (String rua, String bairro) {
        this.bairro = bairro;
        this.rua = rua;
    }

    public void setRua (String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setBairro (String bairro) {
        this.bairro = bairro;
    }

    public String getBairro () {
        return bairro;
    }
}