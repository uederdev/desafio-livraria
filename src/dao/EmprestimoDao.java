package dao;

import model.Emprestimo;
import model.Livro;

import java.util.List;

public class EmprestimoDao {

    private static BancoDados db = null;
    private static EmprestimoDao instance = null;
    private static LivroDao livroDao = null;


    private EmprestimoDao(){
        db = BancoDados.getInstance();
    }
    public static EmprestimoDao getInstance() {
        if (instance == null){
            instance = new EmprestimoDao();
        }
        livroDao = LivroDao.getInstance();
        return instance;
    }

    public List<Emprestimo> getAll(){
        return db.getEmprestimos();
    }

    public void create(Emprestimo model){
        db.getEmprestimos().add(model);
        Livro livro = livroDao.getById(model.getLivro().getId());
        livro.emprestado();
    }

    public List<Emprestimo> getAllByCliente(long clienteId) {
        return db.getEmprestimos().stream().filter(x -> x.getCliente().getId().equals(clienteId)).toList();
    }
}
