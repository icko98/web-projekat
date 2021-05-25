package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Ocena;

import java.util.List;

public interface OcenaRepository extends JpaRepository<Ocena, Long>{

    void deleteById(Long id);

    //TODO
}