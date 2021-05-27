package web.WebProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.WebProjekat.entity.FitnessCentar;
import web.WebProjekat.repository.FitnessCentarRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FitnessCentarService {

    @Autowired
    private FitnessCentarRepository FitnessCentarRepository;

    public FitnessCentar findOne(Long id) {return this.FitnessCentarRepository.findById(id).get();}
    public List<FitnessCentar> findAll() {return this.FitnessCentarRepository.findAll();}
    public FitnessCentar create(FitnessCentar fC) throws Exception{
        if (fC.getId() != null){
            throw new Exception("ID must be null!");
        }
        return this.FitnessCentarRepository.save(fC);
    }
    public void delete(Long id) { this.FitnessCentarRepository.deleteById(id);}
    public FitnessCentar update(FitnessCentar fC) throws Exception{
        FitnessCentar fCUpdate = this.FitnessCentarRepository.getOne(fC.getId());
        if (fCUpdate == null){
            throw new Exception("Fitness centar does not exist");
        }
        fCUpdate.setAdresa(fC.getAdresa());
        fCUpdate.setBrojTelefona(fC.getBrojTelefona());
        fCUpdate.setEmail(fC.getEmail());
        fCUpdate.setNaziv(fC.getNaziv());

        //LISTE ???

        return this.FitnessCentarRepository.save(fCUpdate);

    }

    //TODO
}