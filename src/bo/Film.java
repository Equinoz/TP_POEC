package bo;

import java.sql.Time;
import java.sql.Timestamp;

public class Film {
	private int film_id;
	private String nom;
	private Time duree;
	private String producteur;
	private String realisateur;
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

	public int getFilmId() {
		return film_id;
	}

	public void setFilmId(int value) {
		film_id = value;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String value) {
		nom = value;
	}

	public Time getDuree() {
		return duree;
	}

	public void setDuree(Time value) {
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

	public Timestamp getDateDiffusion() {
		return date_diffusion;
	}

	public void setDateDiffusion(Timestamp value) {
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