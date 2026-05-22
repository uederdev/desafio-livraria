package dao;

import java.util.List;

public class DAOGenerico {

    private static List<Class<?>> classes = List.of();

    public void salvar(Class<?> clazz){

    }

    public List<Class<?>> listar(){
        return classes;
    }
}
