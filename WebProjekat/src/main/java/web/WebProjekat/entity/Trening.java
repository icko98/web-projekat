package web.WebProjekat.entity;

import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum Tip{Cardio, Box, Kickbox, BJJ, HIIT, Gym}
@Entity
public class Trening implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String Naziv;
	
	@Column
	private String Opis;

	@Enumerated
	@Column
	private Tip Tip; // ENUM
	
	@Column
	private int Trajanje;

	@OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Termin> termini;

	@ManyToOne(fetch = FetchType.EAGER)
	private Korisnik trener;

	public Trening(Long id, String naziv, String opis, web.WebProjekat.entity.Tip tip, int trajanje, List<Termin> termini, Korisnik trener) {
		this.id = id;
		Naziv = naziv;
		Opis = opis;
		Tip = tip;
		Trajanje = trajanje;
		this.termini = termini;
		this.trener = trener;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return Naziv;
	}

	public void setNaziv(String naziv) {
		Naziv = naziv;
	}

	public String getOpis() {
		return Opis;
	}

	public void setOpis(String opis) {
		Opis = opis;
	}

	public web.WebProjekat.entity.Tip getTip() {
		return Tip;
	}

	public void setTip(web.WebProjekat.entity.Tip tip) {
		Tip = tip;
	}

	public int getTrajanje() {
		return Trajanje;
	}

	public void setTrajanje(int trajanje) {
		Trajanje = trajanje;
	}

	public List<Termin> getTermini() {
		return termini;
	}

	public void setTermini(List<Termin> termini) {
		this.termini = termini;
	}

	public Korisnik getTrener() {
		return trener;
	}

	public void setTrener(Korisnik trener) {
		this.trener = trener;
	}
}
