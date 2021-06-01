package web.WebProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.WebProjekat.entity.Sala;
import web.WebProjekat.repository.SalaRepository;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala findOne(long id) {return this.salaRepository.findById(id).get();}
    public List<Sala> findAll(){return this.salaRepository.findAll();}
    public Sala create(Sala sala) throws Exception{
        if (sala.getId()!=null){
            throw new Exception("ID must be null!");
        }
        return this.salaRepository.save(sala);
    }
    public void delete(long id) { this.salaRepository.deleteById(id);}
    public Sala update(Sala sala) throws Exception{
        Sala salaUpdate = this.salaRepository.getOne(sala.getId());
        if (salaUpdate==null){
            throw new Exception("Sala nije pronadjena.");
        }
        salaUpdate.setFitnessCentar(sala.getFitnessCentar());
        salaUpdate.setKapacitet(sala.getKapacitet());
        salaUpdate.setOznaka(sala.getOznaka());
        salaUpdate.setTermini(sala.getTermini());

        return this.salaRepository.save(salaUpdate);
    }

    //TODO
}