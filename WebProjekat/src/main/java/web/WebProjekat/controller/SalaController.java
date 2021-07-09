package web.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.WebProjekat.entity.Sala;
import web.WebProjekat.service.SalaService;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class SalaController {
@Autowired
    private SalaService salaService;

    @GetMapping(value="/Sale", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sala>> getSale()
    {
        List<Sala> listaSala=this.salaService.findAll();
        return new ResponseEntity<>(listaSala, HttpStatus.OK);
    }

    @GetMapping(value="/Sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sala> getSala(@PathVariable("id") Long id)
    {
        Sala sala = this.salaService.findOne(id);
        return new ResponseEntity<>(sala, HttpStatus.OK);
    }

    @PostMapping(value="/Sale/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sala> createSala(@RequestBody Sala salas) throws Exception {
        Sala novaSala = salaService.create(salas);
        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/Sale/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id)
    {
        this.salaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/Sale/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sala> updateSala(@PathVariable Long id, @RequestBody Sala sala) throws Exception {
        Sala novaSala = new Sala(sala.getKapacitet(), sala.getOznaka(), sala.getFitnessCentar(), sala.getTermini());
        novaSala.setId(id);
        Sala salNov = salaService.update(novaSala);
        return new ResponseEntity<>(salNov, HttpStatus.OK);
    }
    //TODO ne bi trebalo nista vise? valjda idk?
}
