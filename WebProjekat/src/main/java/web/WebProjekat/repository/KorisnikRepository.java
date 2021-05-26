package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    void deleteById(Long Id);
    //TODO
}
