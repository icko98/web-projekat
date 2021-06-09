package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Korisnik;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    void deleteById(Long Id);
    List<Korisnik> findByEmail(String email);
    //TODO
}
