package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Termin;

import java.util.Date;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long>{

    void deleteById(Long id);

    // 1 :Pretraga po nazivu
    //List<Termin> findByTreningNazivIgnoreCase(String treningNaziv);

    // 2 :Pretraga po tipu
    //List<Termin> findByTreningTipIgnoreCase(String treningTip); // OVDE VRV NE TREBA STRING POSTO JE ENUM

    // 3 :Pretraga po opisu
    //List<Termin> findByTreningOpisIgnoreCase(String treningOpis);

    // 4 :Pretraga po ceni
    //List<Termin> findByCena(Double cena);

    // 5 :Pretraga po vremenu termina
    //List<Termin> findByDate(Date date);


    //TODO pogledaj stavku 2
}