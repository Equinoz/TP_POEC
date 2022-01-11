package bo;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@Column(name = "film_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer film_id;
	private String nom;
	@Column(name = "durée")
	private Duration duree;
	@Column(name = "Producteur")
	private String producteur;
	@Column(name = "Réalisateur")
	private String realisateur;
	@Column(name = "PEGI")
	private String pegi;
	private LocalDateTime date_diffusion;
	private String genre;

	public Film() {}

	public Film(Integer film_id, String nom, Duration duree, String producteur, String realisateur, String pegi, LocalDateTime date_diffusion, String genre) {
		this.film_id = film_id;
		this.nom = nom;
		this.duree = duree;
		this.producteur = producteur;
		this.realisateur = realisateur;
		this.pegi = pegi;
		this.date_diffusion = date_diffusion;
		this.genre = genre;
	}
	public Integer getFilmId() {
		return film_id;
	}

	public void setFilmId(Integer value) {
		film_id = value;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String value) {
		nom = value;
	}
	
	public Duration getDuree() {
		return duree;
	}

	public void setDuree(Duration value) {
		duree = value;
	}

	public String getProducteur() {
		return producteur;
	}

	public void setProducteur(String value) {
		producteur = value;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String value) {
		realisateur = value;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String value) {
		pegi = value;
	}

	public LocalDateTime getDateDiffusion() {
		return date_diffusion;
	}

	public void setDateDiffusion(LocalDateTime value) {
		date_diffusion = value;
	}

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