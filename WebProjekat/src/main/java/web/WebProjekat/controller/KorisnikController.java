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

    @GetMapping(value="/profili/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> getKorisnik(@PathVariable("id") Long id)
    {
        Korisnik korisnik=this.korisnikService.findOne(id);
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }
    @GetMapping(value="/treneri/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> gettKorisnik(@PathVariable("id") Long id)
    {
        Korisnik korisnik=this.korisnikService.findOne(id);
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    //Vraca sve korisnike
    @GetMapping(value="/profili",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getKorisnike(){
        List<Korisnik> listaKorisnika = this.korisnikService.findAll();
        return new ResponseEntity<>(listaKorisnika, HttpStatus.OK);
    }

    @GetMapping(value="/treneri",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> gettKorisnike(){
        List<Korisnik> listaKorisnika = this.korisnikService.findAll();
        return new ResponseEntity<>(listaKorisnika, HttpStatus.OK);
    }


    //Dodavanje novog korisnika
    @PostMapping(value="/profili",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) throws Exception {
        Korisnik newKorisnik = new Korisnik(korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getProsecnaOcena(),
                korisnik.getIme(),korisnik.getPrezime(),korisnik.getTelefon(),korisnik.getEmail(),
                korisnik.getDatumRodjenja(),korisnik.getUloga(),korisnik.getAktivan());
        Korisnik noviKorisnik = korisnikService.create(korisnik);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }
    @PostMapping(value="/loogin",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@RequestBody String Email) throws Exception {
        System.out.println(Email);
        Korisnik kor1 =  korisnikService.findbypar(Email);
        System.out.println(kor1.getLozinka());
        return new ResponseEntity<>(kor1, HttpStatus.OK);
    }


    //Brisanje postojeceg korisnika
    @DeleteMapping(value="/profili/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id)
    {
        this.korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/treneri/{id}")
    public ResponseEntity<Void> deleteeKorisnik(@PathVariable Long id)
    {
        this.korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/profili/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> updateKorisnik(@PathVariable Long id, @RequestBody Korisnik korisnik) throws Exception
    {
        Korisnik noviKorisnik= new Korisnik(korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getProsecnaOcena(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getTelefon(),
                korisnik.getEmail(), korisnik.getDatumRodjenja(),korisnik.getUloga(), korisnik.getAktivan());
        noviKorisnik.setId(id);
        Korisnik novKorisnik = korisnikService.update(noviKorisnik);
        return new ResponseEntity<>(novKorisnik, HttpStatus.OK);
    }
    @PutMapping(value="/treneri/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> updateeKorisnik(@PathVariable Long id, @RequestBody Korisnik korisnik) throws Exception
    {
        Korisnik noviKorisnik= new Korisnik(korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getProsecnaOcena(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getTelefon(),
                korisnik.getEmail(), korisnik.getDatumRodjenja(),korisnik.getUloga(), korisnik.getAktivan());
        noviKorisnik.setId(id);
        Korisnik novKorisnik = korisnikService.update(noviKorisnik);
        return new ResponseEntity<>(novKorisnik, HttpStatus.OK);
    }



    //TODO
}
