package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Trening;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long>{

    void deleteById(Long id);

    //TODO
}