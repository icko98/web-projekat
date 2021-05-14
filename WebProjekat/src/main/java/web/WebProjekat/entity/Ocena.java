package web.WebProjekat.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Ocena implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private int ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    public Ocena(Long id, int ocena, Termin termin, Trener trener) {
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

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
}
