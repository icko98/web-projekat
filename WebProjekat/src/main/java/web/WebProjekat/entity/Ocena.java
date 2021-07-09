package web.WebProjekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Ocena implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private int ocena;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik trener;

    public Ocena(Long id, int ocena, Termin termin, Korisnik trener) {
        this.id = id;
        this.ocena = ocena;
        this.termin = termin;
        this.trener = trener;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Korisnik getTrener() {
        return trener;
    }

    public void setTrener(Korisnik trener) {
        this.trener = trener;
    }
}
