package web.WebProjekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.persister.walking.internal.FetchStrategyHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Termin implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Date pocetak;

    @Column
    private double cena;


    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;


    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;
    @JsonIgnore
    @ManyToMany(mappedBy = "listaPrijavljenihTreninga")
    private List<Korisnik> listaKorisnika;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @JsonIgnore
    @OneToMany(mappedBy = "termin", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ocena> ocene;


    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Termin(Long id, Date pocetak, double cena, Sala sala, Trening trening, List<Ocena> ocene) {
        this.id = id;
        this.pocetak = pocetak;
        this.cena = cena;
        this.sala = sala;
        this.trening = trening;
        this.ocene = ocene;
    }

    public Termin(Date pocetak, double cena, Sala sala, Trening trening) {
        this.pocetak = pocetak;
        this.cena = cena;
        this.sala = sala;
        this.trening = trening;
        this.ocene = new ArrayList<>();
    }

    public Termin(Date pocetak, double cena, Sala sala, FitnessCentar fitnessCentar, Trening trening) {
        this.pocetak = pocetak;
        this.cena = cena;
        this.sala = sala;
        this.fitnessCentar = fitnessCentar;
        this.trening = trening;
    }

    public Termin(){}

    public List<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(List<Ocena> ocene) {
        this.ocene = ocene;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Termin(Long id, Date pocetak, double cena, Sala sala, FitnessCentar fitnessCEntar, Trening trening, List<Ocena> ocene) {
        this.id = id;
        this.pocetak = pocetak;
        this.cena = cena;
        this.sala = sala;
        this.fitnessCentar = fitnessCentar;
        this.trening = trening;
        this.ocene = ocene;
    }

    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
