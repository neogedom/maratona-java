package br.com.abc.javacore.Zcolecoes.classes;


public class Celular {
    private String nome;
    private String IMEI;

    public Celular(String nome, String iMEI) {
        this.nome = nome;
        IMEI = iMEI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String iMEI) {
        IMEI = iMEI;
    }

    @Override
    public String toString() {
        return "Celular [IMEI=" + IMEI + ", nome=" + nome + "]";
    }

    // É possível usar qualquer atributo para montar o método equals, mas é comum
    // usar apenas o atributo identificador (que pode ser a combinação de atributos)
    // Regras: O método equals deve ser reflexivo (x.equals(x) tem que ser true se o
    // x não for null)
    // O método equals deve ser simétrico (para x e y diferentes de null, se
    // x.equals(y) é true, y.equals(x) tem que ser true)
    // O método equals deve ter transitividade (para x, y e z diferentes de null, se
    // x.equals(y) == true e z.equals(x) == true, logo y.equals(z) deve ser true)
    // O método equals deve ser consistente (x.equals(y) deve sempre retornar o
    // mesmo valor)
    // Além disso, para x diferente de null, x.equals(null) tem que retornar false

    // O método equals é sobrescrito de Object
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) { // se eles estão no mesmo endereço de memória
            return true;
        }
        if (this.getClass() != obj.getClass()) { // se a classe desse objeto for diferente da classe do tá seno passado
                                                 // como parâmetro em equals()
            return false;
        }
        Celular outroCelular = (Celular) obj;
        // Mesmo que o objeto não seja nulo, existe a possibilidade de o atributo
        // identificador ser nulo
        // Operador ternário: se IMEI for diferente de null, compara o IMEI dessa classe
        // com o IMEI que veio no parâmetro, se não for, retorna false
        // return IMEI != null ? this.IMEI.equals(outroCelular.getIMEI()) : false;
        return IMEI != null && IMEI.equals(outroCelular.getIMEI());
    }

    // A tabela hash guarda elementos nas listas de forma otimizada
    // O hash traduz os elementos em valores correspondentes depois faz um cálculo
    // com os valores. O resultado do cálculo representa o elemento
    // O problema é que às vezes os cálculos de dois elementos diferentes podem dar
    // resultados iguais, mas uma hora ele tem que retornar true
    // Regras do hashCode
    // Se x.equals(y) == true, x.hashCode() == y.hashCode(), por isso o atributo
    // identificador deve ser o mesmo para os dois
    // y.hashCode() == x.hashCode() não necessariamente o equals retornará true
    // Se x.equals(y) for false, não precisa ter nada no hashcode
    // Se y.hashCode() != y.hashCode(), x.equals(y) deverá ser false
    public int hashCode() {

        // O Java já facilitou e criou a classe hashCode pra gente
        // É importante garantir que o atibuto identificar não seja null para ter
        // certeza de que não retornará NullPointerException
        // O 1 é um valor constante qualquer
        return IMEI != null ? IMEI.hashCode() : 1;
    }

}