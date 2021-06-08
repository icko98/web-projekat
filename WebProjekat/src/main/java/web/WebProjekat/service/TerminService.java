package web.WebProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.WebProjekat.entity.Korisnik;
import web.WebProjekat.entity.Termin;
import web.WebProjekat.repository.TerminRepository;

import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    public List<Termin> findAll() {
        List<Termin> termini= this.terminRepository.findAll();
        return termini;
    }
    //TODO
}