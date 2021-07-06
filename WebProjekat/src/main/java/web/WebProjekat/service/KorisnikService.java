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

    public Korisnik findbypar(String email) throws Exception{

        Korisnik k1 = this.korisnikRepository.findByEmail(email);
        if(k1==null) {
            throw new Exception("Korisnik ne postoji");
        }
        return k1;
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

    public Korisnik update(Korisnik korisnik) throws Exception {
        Korisnik korisnikUpdate = this.korisnikRepository.getOne(korisnik.getId());
        if (korisnikUpdate == null) {
            throw new Exception("Korisnik does not exist");
        }
        korisnikUpdate.setAktivan(korisnik.getAktivan());
        korisnikUpdate.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikUpdate.setEmail(korisnik.getEmail());
        korisnikUpdate.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikUpdate.setIme(korisnik.getIme());
        korisnikUpdate.setPrezime(korisnik.getPrezime());
        korisnikUpdate.setLozinka(korisnik.getLozinka());
        korisnikUpdate.setProsecnaOcena(korisnik.getProsecnaOcena());
        korisnikUpdate.setTelefon(korisnik.getTelefon());
        //LISTE ???

        return this.korisnikRepository.save(korisnikUpdate);
    }


    //TODO
}
