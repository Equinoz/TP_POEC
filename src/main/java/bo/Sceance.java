package bo;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name ="sceance")
@JsonRootName(value = "Sceance")
public class Sceance {

	@Id
	@Column(name = "scéance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sceanceId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "horaire_scéance")
	private LocalDateTime horaireSceance;
	@Column(name = "durée_réclams")
	private LocalTime dureeReclams;
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
	public Sceance() {}
	
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
	public Sceance(int sceanceId, LocalDateTime horaireSceance, LocalTime dureeReclams, int prix, int occupation, boolean vostfr,
			Film filmAssocie, Salle salleAssociee) {
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

    @JsonGetter("FilmAssocie")
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

    @JsonGetter("SalleAssociee")
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

    @JsonGetter("SceanceId")
	public int getSceanceId() {
		return sceanceId;
	}
	/**
	 * @param sceanceId the sceanceId to set
	 */
	public void setSceanceId(int sceanceId) {
		this.sceanceId = sceanceId;
	}
	
	/**
	 * @return the horaireSceance
	 */
    @JsonGetter("HoraireSceance")
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
    @JsonGetter("DureeReclams")
	public LocalTime getDureeReclams() {
		return dureeReclams;
	}
	/**
	 * @param dureeReclams the dureeReclams to set
	 */
	public void setDureeReclams(LocalTime dureeReclams) {
		this.dureeReclams = dureeReclams;
	}
	/**
	 * @return the prix
	 */
    @JsonGetter("Prix")
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
    @JsonGetter("Occupation")
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
    @JsonGetter("Vostfr")
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
