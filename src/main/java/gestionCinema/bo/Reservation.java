package gestionCinema.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "reservation_FK"))
	private Client client;
	@ManyToOne
	@JoinColumn(name = "scéance_id", foreignKey = @ForeignKey(name = "reservation_FK_1"))
	private Sceance sceance;
	@Column(name = "nombre_places")
	private Integer nombrePlaces;
	@Column(name = "Réduction")
	private String reduction;
	@Id
	@Column(name = "réservation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;	

}
