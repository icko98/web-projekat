package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Termin;

import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long>{

    void deleteById(Long id);

    //TODO
}