package br.com.abc.javacore.Gassociacao.classes;

// Um endereço tem pelo menos uma pessoa
public class Endereco {
    private String rua;
    private String bairro;
    private String estado;
    // Navegablidade: baixo acoplamento do endereço com pessoas. Isso é representado por seta aberta unidirecional na UML
    // Aqui não tem como eu reutilizar a classe endereço em outro projeto pq ele está acoplado com pessoa
    // Na UML é um relacionamento unidirecional com seta aberta
    //private Pessoa[] pessoas;
}