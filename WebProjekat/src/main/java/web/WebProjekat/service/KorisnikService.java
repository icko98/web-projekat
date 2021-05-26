package web.WebProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.WebProjekat.entity.Korisnik;
import web.WebProjekat.repository.KorisnikRepository;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll() {
        List<Korisnik> korisnici= this.korisnikRepository.findAll();
        return korisnici;
    }
    public Korisnik create(Korisnik korisnik) throws Exception {
        if (korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        return this.korisnikRepository.save(korisnik);
    }

    //TODO
}
