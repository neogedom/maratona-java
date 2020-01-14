package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

/**
 * Pessoa
 */
public class Pessoa {

    private String nome;
    private String ultimoNome;
    private String nomeDoMeio;
    private String nomeDoPai;

     //Coloco o construtor privado para ser usado pelo Builder
    private Pessoa(String nome, String ultimoNome, String nomeDoMeio, String nomeDoPai) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.nomeDoMeio = nomeDoMeio;
        this.nomeDoPai = nomeDoPai;
    }

   

   // Pelo padrão builder, criamos uma inner class com os mesmos atributos da classe externa
    // e um construtor
    public static class PessoaBuilder {
        private String nome;
        private String ultimoNome;
        private String nomeDoMeio;
        private String nomeDoPai;

        // Os atributos que quero deixar obrigatório devem ser
        // colocados no construtor de PessoaBuilder
        public PessoaBuilder (String nome) {
            this.nome = nome;
        }

        // No padrão Builder devemos criar métodos que retornem cada um, um objeto da classe
        // interna desenvolvida para o Builder (Nesse caso, PessoaBuilder). Cada objeto retornado
        // conterá um dos atributos da classe recebendo os valores
        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder nomeDoMeio(String nomeDoMeio) {
            this.nomeDoMeio = nomeDoMeio;
            return this;
        }

        public PessoaBuilder ultimoNome(String ultimoNome) {
            this.ultimoNome = ultimoNome;
            return this;
        }

        public PessoaBuilder nomeDoPai(String nomeDoPai) {
            this.nomeDoPai = nomeDoPai;
            return this;
        }
        
        //Um método para criar uma pessoa, usando o construtor privado
        // da classe externa Pessoa
        // O this usado em cada método com nome de atributo determina que os atributos de 
        // PessoaBuilder serão inicializados. Ao chamar build, cria-se uma pessoa
        // usando os valores que estão nos atributos de pessoaBuilder
        // O nome padrão do método é build
        public Pessoa build(){
            // Pessoa pessoa = new Pessoa();
            // pessoa.nome = this.nome;
            // pessoa.nomeDoMeio = this.nomeDoMeio;
            // pessoa.nomeDoPai = this.nomeDoPai;
            // pessoa.ultimoNome = this.ultimoNome;
            return new Pessoa(nome, ultimoNome, nomeDoMeio, nomeDoPai);
            // return pessoa;
        }

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", nomeDoMeio=" + nomeDoMeio + ", nomeDoPai=" + nomeDoPai + ", ultimoNome="
                + ultimoNome + "]";
    }

    
}