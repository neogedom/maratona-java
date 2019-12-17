package br.com.abc.javacore.Minterfaces.classes;

/**
 * Produto
 */

 // Aqui o produto implementa Tributavel e Transportavel. Portanto, esse produto é tributável e transportável
 // É assim que se lê
 // Dá para implementar mais de uma interface. Isso é uma forma de contornar o fato de que você não pode 
 // ter múltiplas heranças
public class Produto implements Tributavel, Transportavel{

    private String nome;
    private double peso;
    private double preco;
    private double precoFinal;
    private double valorFrete;

    //Na sobrescrita você não pode sobrescrever com um método mais restritivo
    // Do mais restrito para o menos restrito:
    // private > default (pacote) > protected (pacote e classes em herança) > public
    // Por isso não posso deixar só void calculaImposto, pq aqui ele seria default
	@Override
	public void calculaImposto() {
		precoFinal = this.preco + (preco * IMPOSTO);
    }
    
    @Override
    public void calculaFrete() {
        valorFrete = this.preco / this.peso * 0.1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreço() {
        return getPreço();
    }

    public void setPreco(double preço) {
        this.preco = preço;
    }

   

    public Produto(String nome, double peso, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", peso=" + peso + ", preco=" + preco + ", precoFinal com imposto=" + precoFinal
                + ", valorFrete=" + valorFrete + "]";
    }

    

}