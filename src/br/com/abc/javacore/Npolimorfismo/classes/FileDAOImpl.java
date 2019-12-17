package br.com.abc.javacore.Npolimorfismo.classes;

/**
 * FileDAOImpl
 */
public class FileDAOImpl implements GenericDAO {

    @Override
    public void save() {
        System.out.println("Salvando dados nos arquivos");
    }
    
}