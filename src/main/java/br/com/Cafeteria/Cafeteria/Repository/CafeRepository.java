package br.com.Cafeteria.Cafeteria.Repository;

import br.com.Cafeteria.Cafeteria.Repository.orm.CafeDoBancoDeDados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends CrudRepository<CafeDoBancoDeDados, Long> {
    CafeDoBancoDeDados findByTipoCafe(String tipoCafe);
}
