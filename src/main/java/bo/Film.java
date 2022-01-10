package bo;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;


@Entity
@Table(name = "film")
@JsonRootName(value = "Film")
public class Film {
	@Id
	@Column(name = "film_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int film_id;
	private String nom;
	@Column(name = "durée")
	private Time duree;
	@Column(name = "Producteur")
	private String producteur;
	@Column(name = "Réalisateur")
	private String realisateur;
	@Column(name = "PEGI")
	private String pegi;
	private Timestamp date_diffusion;
	private String genre;

	public Film() {}

	public Film(int film_id, String nom, Time duree, String producteur, String realisateur, String pegi, Timestamp date_diffusion, String genre) {
		this.film_id = film_id;
		this.nom = nom;
		this.duree = duree;
		this.producteur = producteur;
		this.realisateur = realisateur;
		this.pegi = pegi;
		this.date_diffusion = date_diffusion;
		this.genre = genre;
	}
	@JsonGetter("id")
	public int getFilmId() {
		return film_id;
	}

	public void setFilmId(int value) {
		film_id = value;
	}
	@JsonGetter("Nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String value) {
		nom = value;
	}
	@JsonGetter("Durée")
	public Time getDuree() {
		return duree;
	}

	public void setDuree(Time value) {
		duree = value;
	}
	@JsonGetter("Producteur")
	public String getProducteur() {
		return producteur;
	}

	public void setProducteur(String value) {
		producteur = value;
	}
	@JsonGetter("Realisateur")
	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String value) {
		realisateur = value;
	}
	@JsonGetter("PEGI")
	public String getPegi() {
		return pegi;
	}

	public void setPegi(String value) {
		pegi = value;
	}
	@JsonGetter("DateDiffusion")
	public Timestamp getDateDiffusion() {
		return date_diffusion;
	}

	public void setDateDiffusion(Timestamp value) {
		date_diffusion = value;
	}
	@JsonGetter("Genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String value) {
		genre = value;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", nom=" + nom + ", duree=" + duree + ", producteur=" + producteur
				+ ", realisateur=" + realisateur + ", pegi=" + pegi + ", date_diffusion=" + date_diffusion + ", genre="
				+ genre + "]";
	}
}