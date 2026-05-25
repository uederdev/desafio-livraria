package dao;

import java.util.List;

public interface Dao<T> {

    void salvar(T model);
    void excluir(Long id);
    List<T> getAll();
    void editar(T model);
    T getById(Long id);

}
