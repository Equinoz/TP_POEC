package bo;

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

@Entity
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

	/**
	 * 
	 */
	public Sceance() {
	}

	/**
	 * @param sceanceId
	 * @param horaireSceance
	 * @param dureeReclams
	 * @param prix
	 * @param occupation
	 * @param vostfr
	 * @param filmAssocie
	 * @param salleAssociee
	 */
	public Sceance(Integer sceanceId, LocalDateTime horaireSceance, Duration dureeReclams, int prix, int occupation,
			boolean vostfr, Film filmAssocie, Salle salleAssociee) {
		this.sceanceId = sceanceId;
		this.horaireSceance = horaireSceance;
		this.dureeReclams = dureeReclams;
		this.prix = prix;
		this.occupation = occupation;
		this.vostfr = vostfr;
		this.filmAssocie = filmAssocie;
		this.salleAssociee = salleAssociee;
	}

	/**
	 * @return the filmAssocie
	 */

	public Film getFilmAssocie() {
		return filmAssocie;
	}

	/**
	 * @param filmAssocie the filmAssocie to set
	 */
	public void setFilmAssocie(Film filmAssocie) {
		this.filmAssocie = filmAssocie;
	}

	/**
	 * @return the salleAssociee
	 */

	public Salle getSalleAssociee() {
		return salleAssociee;
	}

	/**
	 * @param salleAssociee the salleAssociee to set
	 */
	public void setSalleAssociee(Salle salleAssociee) {
		this.salleAssociee = salleAssociee;
	}

	/**
	 * @return the sceanceId
	 */

	public Integer getSceanceId() {
		return sceanceId;
	}

	/**
	 * @param sceanceId the sceanceId to set
	 */
	public void setSceanceId(Integer sceanceId) {
		this.sceanceId = sceanceId;
	}

	/**
	 * @return the horaireSceance
	 */

	public LocalDateTime getHoraireSceance() {
		return horaireSceance;
	}

	/**
	 * @param horaireSceance the horaireSceance to set
	 */
	public void setHoraireSceance(LocalDateTime horaireSceance) {
		this.horaireSceance = horaireSceance;
	}

	/**
	 * @return the dureeReclams
	 */

	public Duration getDureeReclams() {
		return dureeReclams;
	}

	/**
	 * @param dureeReclams the dureeReclams to set
	 */
	public void setDureeReclams(Duration dureeReclams) {
		this.dureeReclams = dureeReclams;
	}

	/**
	 * @return the prix
	 */

	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the occupation
	 */

	public int getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the vostfr
	 */

	public boolean isVostfr() {
		return vostfr;
	}

	/**
	 * @param vostfr the vostfr to set
	 */
	public void setVostfr(boolean vostfr) {
		this.vostfr = vostfr;
	}

	@Override
	public String toString() {
		return "Sceance [sceanceId=" + sceanceId + ", horaireSceance=" + horaireSceance + ", dureeReclams="
				+ dureeReclams + ", prix=" + prix + ", occupation=" + occupation + ", vostfr=" + vostfr
				+ ", filmAssocie=" + filmAssocie + ", salleAssociee=" + salleAssociee + "]";
	}

}
