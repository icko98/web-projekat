package web.WebProjekat.entity;

import java.util.*;
import javax.persistence.*;


public class Clan extends Korisnik{
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trening> ListaOdradjenihTreninga;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trening> ListaPrijavljenihTreninga;


	public Clan(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, web.WebProjekat.entity.Uloga uloga, Boolean aktivan, List<Trening> listaOdradjenihTreninga, List<Trening> listaPrijavljenihTreninga) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
		ListaOdradjenihTreninga = listaOdradjenihTreninga;
		ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
	}

	public List<Trening> getListaOdradjenihTreninga() {
		return ListaOdradjenihTreninga;
	}

	public void setListaOdradjenihTreninga(List<Trening> listaOdradjenihTreninga) {
		ListaOdradjenihTreninga = listaOdradjenihTreninga;
	}

	public List<Trening> getListaPrijavljenihTreninga() {
		return ListaPrijavljenihTreninga;
	}

	public void setListaPrijavljenihTreninga(List<Trening> listaPrijavljenihTreninga) {
		ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
	}
}
