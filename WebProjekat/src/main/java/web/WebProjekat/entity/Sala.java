package web.WebProjekat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Sala implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private int kapacitet;
	
	@Column
	private String oznaka;


	@ManyToOne(fetch=FetchType.EAGER)
	private FitnessCentar fitnessCentar;

	@JsonIgnore
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Termin> termini;

	public Sala(Long id, int kapacitet, String oznaka, FitnessCentar fitnessCentar, List<Termin> termini) {
		this.id = id;
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.fitnessCentar = fitnessCentar;
		this.termini = termini;
	}

	public Sala(int kapacitet, String oznaka, FitnessCentar fitnessCentar, List<Termin> termini) {
		this.kapacitet = kapacitet;
		this.oznaka = oznaka;
		this.fitnessCentar = fitnessCentar;
		this.termini = termini;
	}

	public Sala(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public FitnessCentar getFitnessCentar() {
		return fitnessCentar;
	}

	public void setFitnessCentar(FitnessCentar fitnessCentar) {
		this.fitnessCentar = fitnessCentar;
	}

	public List<Termin> getTermini() {
		return termini;
	}

	public void setTermini(List<Termin> termini) {
		this.termini = termini;
	}
}
