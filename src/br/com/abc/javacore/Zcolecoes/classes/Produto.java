package br.com.abc.javacore.Zcolecoes.classes;

//A classe Comparable indica como os objetos dessa classe devem ser ordenados
// por meio do método compareTo
//Mas esse não é a melhor maneira e sim o Comparator
public class Produto implements Comparable<Produto> {
    private String serialNumber;
    private String nome;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (serialNumber == null) {
            if (other.serialNumber != null)
                return false;
        } else if (!serialNumber.equals(other.serialNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", serialNumber=" + serialNumber + "]";
    }

    public Produto(String serialNumber, String nome, Double preco) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto outroObjeto) {
        // Retorna um número negativo se this.object < outroObjeto
        // Retorna 0 se this.object == outroObjeto
        // Retora um numero positivo se this.object > outroObjeto

        // Se quisermos ordenar por serialNumber (delegando a responsabilidade para
        // classe String que já implementou o método compareTo)
        // return this.nome.compareTo(outroObjeto.getNome());

        // Se quisermos ordenar por preço é bom usar classes Wrapper( lembre-se que tipo
        // primitivo não tem método)
        Double d = preco;
        return d.compareTo(outroObjeto.getPreco());
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}