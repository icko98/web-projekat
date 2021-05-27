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


    // izuzetno cudno. morao sam da menjam getId sa ovim findbyid.get nzm zasto
    public Korisnik findOne(Long id)
    {
        return this.korisnikRepository.findById(id).get();
    }

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

    public void delete(Long id)
    {
        this.korisnikRepository.deleteById(id);
    }


    //TODO
}
