package web.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.WebProjekat.entity.Clan;

import java.util.List;

public interface ClanRepository extends JpaRepository<Clan, Long>{

    void deleteById(Long id);

    //TODO
}
