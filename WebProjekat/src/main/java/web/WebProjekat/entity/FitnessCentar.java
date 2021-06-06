package web.WebProjekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
public class FitnessCentar implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String naziv;
	
	@Column(unique=true)
	private String adresa;
	
	@Column(unique=true)
	private String brojTelefona;
	
	@Column(unique=true)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Korisnik> getListaTrenera() {
		return listaTrenera;
	}

	public void setListaTrenera(List<Korisnik> listaTrenera) {
		this.listaTrenera = listaTrenera;
	}

	public List<Sala> getListaSala() {
		return listaSala;
	}

	public void setListaSala(List<Sala> listaSala) {
		this.listaSala = listaSala;
	}

	public List<Trening> getListaTreninga() {
		return listaTreninga;
	}

	public void setListaTreninga(List<Trening> listaTreninga) {
		this.listaTreninga = listaTreninga;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Korisnik> listaTrenera;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Sala> listaSala;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trening> listaTreninga;

	public FitnessCentar(){}

	public FitnessCentar(String naziv, String adresa, String brojTelefona, String email){
		this.naziv=naziv;
		this.adresa=adresa;
		this.brojTelefona=brojTelefona;
		this.email=email;
	}

	public FitnessCentar(Long id, String naziv, String adresa, String brojTelefona, String email, List<Korisnik> listaTrenera, List<Sala> listaSala, List<Trening> listaTreninga) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.listaTrenera = listaTrenera;
		this.listaSala = listaSala;
		this.listaTreninga = listaTreninga;
	}
}
