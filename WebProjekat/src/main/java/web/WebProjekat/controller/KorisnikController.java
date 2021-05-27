package web.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.WebProjekat.entity.Korisnik;
import web.WebProjekat.service.KorisnikService;

import java.util.List;

@RestController
//@RequestMapping(value="/profili")
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/")
    public String welcome() {return "treneri.html";}

    //Vraca jednog korisnika

    @GetMapping(value="/profili.html/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> getKorisnik(@PathVariable("id") Long id)
    {
        Korisnik korisnik=this.korisnikService.findOne(id);
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    //Vraca sve korisnike
    @GetMapping(value="/profili.html",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getKorisnike(){
        List<Korisnik> listaKorisnika = this.korisnikService.findAll();
        return new ResponseEntity<>(listaKorisnika, HttpStatus.OK);
    }


    //Dodavanje novog korisnika valjda, nisam siguran
    @PostMapping(value="/profili.html",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        Korisnik newKorisnik = new Korisnik(korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getProsecnaOcena(),
                korisnik.getIme(),korisnik.getPrezime(),korisnik.getTelefon(),korisnik.getEmail(),
                korisnik.getDatumRodjenja(),korisnik.getUloga(),korisnik.getAktivan());
        Korisnik noviKorisnik = korisnikService.create(korisnik);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }

    //Brisanje postojeceg korisnika
    @DeleteMapping(value="/profili.html/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id)
    {
        this.korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //TODO 80% gotovo ig +zahtevi za dodavanje trenera isl S TIM NE ZNAM STA CU
}
