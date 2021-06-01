package web.WebProjekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.persister.walking.internal.FetchStrategyHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Termin implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Date pocetak;

    @Column
    private double cena;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @JsonIgnore
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


}
