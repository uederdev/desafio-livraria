package dao;

import model.Livro;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LivroDao implements Dao<Livro>{

    private static BancoDados db = null;
    private static LivroDao instance = null;

    private LivroDao(){
        db = BancoDados.getInstance();
    }
    public static LivroDao getInstance() {
        if (instance == null){
            instance = new LivroDao();
        }
        return instance;
    }

    @Override
    public void salvar(Livro model) {
        Long id = db.getId();
        model.setId(id);
        db.getLivros().add(model);
    }

    @Override
    public void excluir(Long id) {
        Livro livroEncontrado = getById(id);
        db.getLivros().remove(livroEncontrado);
    }

    @Override
    public List<Livro> getAll() {
        return db.getLivros();
    }

    @Override
    public void editar(Livro model) {
        Livro livroEncontrado = getById(model.getId());
        livroEncontrado.setTitulo(model.getTitulo());
        livroEncontrado.setAutor(model.getAutor());
    }

    @Override
    public Livro getById(Long id) {
        return db.getLivros().stream()
                .filter(x -> x.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Livro não encontrado."));
    }

    public List<Livro> getAllByStatus(Boolean status) {
        return db.getLivros().stream()
                .filter(x -> x.getDisponivel().equals(status)).toList();
    }


}
