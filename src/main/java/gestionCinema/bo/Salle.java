package gestionCinema.bo;

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
@Table(name = "salle")
public class Salle {
	@Id
	@Column(name = "salle_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salle_id;
	@Column(name="capacité")
	private int capacite;
	@Column(name = "numéro_salle")
	private int numero_salle;
	@Column(name = "équipement_3D")
	private int equipement_3D;
	private Integer cinemas_id;

}
