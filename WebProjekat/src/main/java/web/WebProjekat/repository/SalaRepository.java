package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Sala;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long>{

    void deleteById(Long id);

    //TODO
}