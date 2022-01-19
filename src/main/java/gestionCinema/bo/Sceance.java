package gestionCinema.bo;

import java.time.LocalDateTime;
import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sceance")
public class Sceance {

	@Id
	@Column(name = "scéance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sceanceId;
	@Column(name = "horaire_scéance")
	private LocalDateTime horaireSceance;
	@Column(name = "durée_réclams")
	private Duration dureeReclams;
	private int prix;
	private int occupation;
	@Column(name = "VOSTFR")
	private boolean vostfr;
	@ManyToOne
	@JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "sceance_FK"))
	private Film filmAssocie;
	@ManyToOne
	@JoinColumn(name = "salle_id", foreignKey = @ForeignKey(name = "sceance_FK_1"))
	private Salle salleAssociee;

}
