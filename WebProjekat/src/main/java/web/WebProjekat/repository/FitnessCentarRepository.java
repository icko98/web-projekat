package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.FitnessCentar;
import web.WebProjekat.entity.Korisnik;

import java.util.List;

public interface FitnessCentarRepository extends JpaRepository<FitnessCentar, Long>{

    void deleteById(Long id);


    //TODO
}