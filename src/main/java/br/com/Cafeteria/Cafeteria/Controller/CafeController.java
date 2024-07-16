package br.com.Cafeteria.Cafeteria.Controller;

import br.com.Cafeteria.Cafeteria.Controller.dto.CafeDoCliente;
import br.com.Cafeteria.Cafeteria.Service.CafeService;
import br.com.Cafeteria.Cafeteria.Repository.orm.CafeDoBancoDeDados;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cafes")
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CafeDoBancoDeDados> findAll() {
        return cafeService.listAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CafeDoBancoDeDados findById(@PathVariable long id) {
        return cafeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CafeDoBancoDeDados save(@RequestBody CafeDoCliente cafe) {
        return cafeService.save(cafe);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        cafeService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CafeDoBancoDeDados replace(@RequestBody CafeDoCliente cafe) {
        return cafeService.replace(cafe);
    }
}
