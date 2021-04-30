package com.example.carros.api.carros;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;



    /**
     * Voce pode chamar na URL esses parametros
     * api/v1/carros?page=1
     * api/v1/carros?page=1&size=5
     * @param page
     * @param size
     * @return
     */
    @GetMapping
	public ResponseEntity get(Pageable pageable) {
		return ResponseEntity.ok(service.getCarros(pageable));
	}

    @GetMapping("/{id}")
    public ResponseEntity getCarroById(@PathVariable("id") Long id){
        CarroDTO carro = service.getCarrosById(id);
        return ResponseEntity.ok(carro);
    }

    /**
     * ?page=0&size=5
     * /api/v1/carros/tipo/esportivos?page=0&size=5
     * @param tipo
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarroByTipo(@PathVariable("tipo") String tipo,
                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size){
        List<CarroDTO> carros = service.getCarrosByTipo(tipo, PageRequest.of(page, size));

        return carros.isEmpty() ? ResponseEntity.noContent().build() : 
                ResponseEntity.ok(carros);
    }

    /**
     * /search?query=Lamborghini
     * @param query
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("query") String query) {
    List<CarroDTO> carros = service.search(query);
    return carros.isEmpty() ?
            ResponseEntity.noContent().build() :
            ResponseEntity.ok(carros);
    }

    
    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity post(@RequestBody Carro carro) {

        CarroDTO c = service.insert(carro);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        carro.setId(id);
        CarroDTO c = service.update(carro, id);


        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
