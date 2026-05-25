package dao;

import model.Autor;

import java.util.List;

public class AutorDao implements Dao<Autor> {

    private static BancoDados db = null;
    private static AutorDao instance = null;

    private AutorDao() {
        db = BancoDados.getInstance();
    }

    public static AutorDao getInstance() {
        if (instance == null) {
            instance = new AutorDao();
        }
        return instance;
    }

    @Override
    public void salvar(Autor model) {
        Long id = db.getId();
        model.setId(id);
        db.getAutores().add(model);
    }

    @Override
    public void excluir(Long id) {
        Autor autorEncontrado = getById(id);
        db.getAutores().remove(autorEncontrado);
    }

    @Override
    public List<Autor> getAll() {
        return db.getAutores();
    }

    @Override
    public void editar(Autor model) {
        Autor autorEncontrado = getById(model.getId());
        autorEncontrado.setNome(model.getNome());
        autorEncontrado.setDataNascimento(model.getDataNascimento());
    }

    @Override
    public Autor getById(Long id) {
        return db.getAutores().stream()
                .filter(autor -> autor.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Autor não encontrado."));
    }

}
