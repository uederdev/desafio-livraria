package dao;

import model.Autor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private static List<Autor> autores = new ArrayList<>();

    private static AutorDao instance;

    private AutorDao(){
        autores.add(new Autor(1L, "Machado de Assis", LocalDate.of(1957, 10, 10)));
        autores.add(new Autor(2L, "Carlos Drumond de Andrade", LocalDate.of(1922,12,31)));
        autores.add(new Autor(3l, "Clarice Lispector", LocalDate.of(1933,5,21)));
    }

    public static AutorDao getInstance(){
        if(instance == null){
            instance = new AutorDao();
        }
        return instance;
    }

    public void salvar(Autor autor){
        autores.add(autor);
    }

    public List<Autor> listar(){
        return autores;
    }

    public Autor buscarPorId(Long id){
        return autores.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Autor não encontrado!"));
    }


}
