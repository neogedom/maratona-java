package br.com.abc.javacore.Vresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;


// Resource Bundle, um pacote onde colocamos todas as mensagens de texto
// para trabalharmos com internacionalização. Usado para colocar as mensagens do sistema
// Usando essa estratégia é muito mais fácil pq tudo está em um arquivo só e vc não tem que ficar 
// procurando classe por classe
public class ResourceBundleTest {
    public static void main (String ... args) {
        // Para pegar um Resource Bundle não se usa new, se usa getBundle
        // Parâmetros do getBundle = basename = nome que vem antes de _ no arquivo do resource bundle.
        // no nosso caso, messages; e um locale. Se não passar locale, ele pega o padrão do SO
        //Qual a localização padrão?
        //System.out.println(Locale.getDefault());
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));

        //para pegar as mensagens definidas nas chaves do arquivo .properties
       System.out.println(rb.getString("hello"));
       System.out.println(rb.getString("good.morning"));
       // Chamando da properties "pai"
       System.out.println(rb.getString("show"));

       //Se passarmos uma chave que não existe, uma exceção PropertyResourceBundle é lançada
       //System.out.println(rb.getString("good"));

       rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
       System.out.println(rb.getString("hello"));
       System.out.println(rb.getString("good.morning"));
       // Chamando da properties "pai"
       System.out.println(rb.getString("show"));


    }

    /*
    Fluxo do resource bundle (um exemplo de lingua FR do Canadá):
    ele procura nos arquivos seguindo a seguinte sequência
        messages_fr_CA.properties
        messages_fr.properties
        messages_pt_BR.properties (pq é o do meu sistema)
        messages_pt.properties
        messages.properties
        E se caso ele não encontrar, aqui ele lança exceção
             

    */
}

