package dao;

import model.Cliente;

import java.util.List;

public class ClienteDao implements Dao<Cliente>{
    private static BancoDados db = null;
    private static ClienteDao instance = null;

    private ClienteDao(){
        db = BancoDados.getInstance();
    }

    public static ClienteDao getInstance() {
        if (instance == null){
            instance = new ClienteDao();
        }
        return instance;
    }

    @Override
    public void salvar(Cliente model) {
        model.setId(db.getId());
        db.getClientes().add(model);
    }

    @Override
    public void excluir(Long id) {
        db.getClientes().remove(getById(id));
    }

    @Override
    public List<Cliente> getAll() {
        return db.getClientes();
    }

    @Override
    public void editar(Cliente model) {
        Cliente clienteEncontrado = getById(model.getId());
        clienteEncontrado.setNome(model.getNome());
        clienteEncontrado.setEmail(model.getEmail());
    }

    @Override
    public Cliente getById(Long id) {
        return db.getClientes().stream()
                .filter(x -> x.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }
}
