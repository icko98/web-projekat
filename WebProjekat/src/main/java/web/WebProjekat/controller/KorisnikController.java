package web.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.WebProjekat.entity.Korisnik;
import web.WebProjekat.service.KorisnikService;

import java.util.List;

@RestController
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    //@GetMapping("/")
    //public String welcome() {return "treneri.html";}

    @GetMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getKorisnik(){
        List<Korisnik> listaKorisnika = this.korisnikService.findAll();
        return new ResponseEntity<>(listaKorisnika, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        Korisnik noviKorisnik = korisnikService.create(korisnik);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }
}
