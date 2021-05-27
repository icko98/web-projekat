package web.WebProjekat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.WebProjekat.entity.FitnessCentar;
import web.WebProjekat.service.FitnessCentarService;

import java.util.List;

@RestController
public class FitnessCentarController {
    @Autowired
    private FitnessCentarService fitnessCentarService;

    @GetMapping(value="/FC.html/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentar> getFC(@PathVariable("id") Long id)
    {
        FitnessCentar fc=this.fitnessCentarService.findOne(id);
        return new ResponseEntity<>(fc, HttpStatus.OK);
    }

    @GetMapping(value = "/FC.html", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentar>> getFCe()
    {
        List<FitnessCentar> listaFC=this.fitnessCentarService.findAll();
        return new ResponseEntity<>(listaFC,HttpStatus.OK);
    }

    @PostMapping(value= "/FC.html",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentar> createFC(@RequestBody FitnessCentar fc) throws Exception{
        FitnessCentar noviFC = fitnessCentarService.create(fc);
        return new ResponseEntity<>(noviFC, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/FC.html/{id}")
    public ResponseEntity<Void> deleteFC(@PathVariable Long id)
    {
        this.fitnessCentarService.delete((id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // metoda za azuriranje FCa NIJE PROVERENA!!!!!!

    @PutMapping(value="/FC.html/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentar> updateFC(@PathVariable Long id, @RequestBody FitnessCentar fc) throws Exception
    {
        FitnessCentar fcNovi= new FitnessCentar(fc.getNaziv(), fc.getAdresa(), fc.getBrojTelefona(),fc.getEmail());
        fcNovi.setId(id);
        FitnessCentar noviFC = fitnessCentarService.update(fcNovi);
        return new ResponseEntity<>(noviFC, HttpStatus.OK);
    }


    //TODO
}
