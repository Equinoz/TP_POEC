package gestionCinema.bo;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private String lienImg;
}