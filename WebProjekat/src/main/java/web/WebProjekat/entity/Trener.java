package web.WebProjekat.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Trener extends Korisnik{
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trening> ListaTreninga;
	
	@Column
	private double prosecnaOcena;

	public List<Trening> getListaTreninga() {
		return ListaTreninga;
	}

	public void setListaTreninga(List<Trening> listaTreninga) {
		ListaTreninga = listaTreninga;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Trener(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, web.WebProjekat.entity.Uloga uloga, Boolean aktivan, List<Trening> listaTreninga, double prosecnaOcena) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
		ListaTreninga = listaTreninga;
		this.prosecnaOcena = prosecnaOcena;
	}
}
