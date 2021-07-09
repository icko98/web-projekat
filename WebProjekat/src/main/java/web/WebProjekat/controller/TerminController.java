package web.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.WebProjekat.entity.Korisnik;
import web.WebProjekat.entity.Termin;
import web.WebProjekat.service.TerminService;

import java.util.List;

@Controller
public class TerminController {
@Autowired
    private TerminService terminService;

    @GetMapping(value="/termini",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Termin>> getTermine(){
        List<Termin> listaTermina = this.terminService.findAll();
        return new ResponseEntity<>(listaTermina, HttpStatus.OK);
    }
    @PostMapping(value="/termini",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Termin> createTermin(@RequestBody Termin termin) throws Exception {
        Termin newtermin = new Termin(termin.getPocetak(), termin.getCena(), termin.getSala(), termin.getTrening());
        Termin noviTermin = terminService.create(termin);
        return new ResponseEntity<>(noviTermin, HttpStatus.CREATED);

    }

}
