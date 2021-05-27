package web.WebProjekat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

enum Uloga{Administrator, Trener, Korisnik}

@Entity
public class Korisnik implements Serializable {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(unique=true)
	private String KorisnickoIme;
	
	@Column
	private String Lozinka;

	@Column
	private int ProsecnaOcena;

	@Column
	private String Ime;
	
	@Column
	private String Prezime;
	
	@Column(unique=true)
	private String Telefon;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private Date DatumRodjenja;

	@Column
	@Enumerated
	private Uloga Uloga;

	@Column
	private Boolean Aktivan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return KorisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		KorisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return Lozinka;
	}

	public void setLozinka(String lozinka) {
		Lozinka = lozinka;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}

	public web.WebProjekat.entity.Uloga getUloga() {
		return Uloga;
	}

	public int getProsecnaOcena() {
		return ProsecnaOcena;
	}

	public void setProsecnaOcena(int prosecnaOcena) {
		ProsecnaOcena = prosecnaOcena;
	}

	public void setUloga(web.WebProjekat.entity.Uloga uloga) {
		Uloga = uloga;
	}

	public Boolean getAktivan() {
		return Aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		Aktivan = aktivan;
	}

	public Korisnik(){}

	public Korisnik(Long id, String korisnickoIme, String lozinka, int prosecnaOcena, String ime, String prezime, String telefon, String email, Date datumRodjenja, web.WebProjekat.entity.Uloga uloga, Boolean aktivan) {
		this.id = id;
		KorisnickoIme = korisnickoIme;
		Lozinka = lozinka;
		ProsecnaOcena = prosecnaOcena;
		Ime = ime;
		Prezime = prezime;
		Telefon = telefon;
		this.email = email;
		DatumRodjenja = datumRodjenja;
		Uloga = uloga;
		Aktivan = aktivan;
	}

	public Korisnik(String korisnickoIme, String lozinka, int prosecnaOcena, String ime, String prezime, String telefon, String email, Date datumRodjenja, web.WebProjekat.entity.Uloga uloga, Boolean aktivan) {
		KorisnickoIme = korisnickoIme;
		Lozinka = lozinka;
		ProsecnaOcena = prosecnaOcena;
		Ime = ime;
		Prezime = prezime;
		Telefon = telefon;
		this.email = email;
		DatumRodjenja = datumRodjenja;
		Uloga = uloga;
		Aktivan = aktivan;
	}
}

