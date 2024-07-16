package br.com.Cafeteria.Cafeteria.Service;

import br.com.Cafeteria.Cafeteria.Controller.dto.CafeDoCliente;
import br.com.Cafeteria.Cafeteria.Repository.CafeRepository;
import br.com.Cafeteria.Cafeteria.Repository.orm.CafeDoBancoDeDados;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CafeService {
    private final CafeRepository repository;

    public CafeService(CafeRepository repository) {
        this.repository = repository;
    }

    public List<CafeDoBancoDeDados> listAll() {
        Iterable<CafeDoBancoDeDados> all = repository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .toList();
    }

    public CafeDoBancoDeDados findById(long id) {
        Optional<CafeDoBancoDeDados> optional = repository.findById(id);
        return optional.get();
    }

    public CafeDoBancoDeDados save(CafeDoCliente cafe) {
        CafeDoBancoDeDados db = new CafeDoBancoDeDados();
        db.setTipoCafe(cafe.getNome());
        db.setValor(cafe.getValor());
        return repository.save(db);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public CafeDoBancoDeDados replace(CafeDoCliente cafe) {
        CafeDoBancoDeDados db = repository.findByTipoCafe(cafe.getNome());

        if (db == null) {
            System.out.println("Objeto nao existe na base");
        }

        db.setTipoCafe(cafe.getNome());
        db.setValor(cafe.getValor());

        CafeDoBancoDeDados save = repository.save(db);
        return save;
    }
}
