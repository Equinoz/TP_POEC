package bo;

import java.sql.Time;
import java.sql.Timestamp;


public class Sceance {

	private int sceanceId;
	private int filmId;
	private int salleId;
	private Timestamp horaireSceance;
	private Time dureeReclams;
	private int prix;
	private int occupation;
	private boolean vostfr;
	private Film filmAssocie;
	private Salle salleAssociee;
	
	
	
	/**
	 * 
	 */
	public Sceance() {
	}
	
	/**
	 * @param sceanceId
	 * @param filmId
	 * @param salleId
	 * @param horaireSceance
	 * @param dureeReclams
	 * @param prix
	 * @param occupation
	 * @param vostfr
	 */
	public Sceance(int sceanceId, int filmId, int salleId, Timestamp horaireSceance, Time dureeReclams,
			int prix, int occupation, boolean vostfr) {
		this.sceanceId = sceanceId;
		this.filmId = filmId;
		this.salleId = salleId;
		this.horaireSceance = horaireSceance;
		this.dureeReclams = dureeReclams;
		this.prix = prix;
		this.occupation = occupation;
		this.vostfr = vostfr;
	}
	

	/**
	 * @param sceanceId
	 * @param horaireSceance
	 * @param dureeReclams
	 * @param prix
	 * @param occupation
	 * @param vostfr
	 * @param filmAssocie
	 * @param sceanceAssociee
	 */
	public Sceance(int sceanceId,Film filmAssocie, Salle salleAssociee, Timestamp horaireSceance, Time dureeReclams, 
			int prix, int occupation, boolean vostfr) {
		this.sceanceId = sceanceId;
		this.horaireSceance = horaireSceance;
		this.dureeReclams = dureeReclams;
		this.prix = prix;
		this.occupation = occupation;
		this.vostfr = vostfr;
		this.filmAssocie = filmAssocie;
		this.salleAssociee = salleAssociee;
	}

	@Override
	public String toString() {
		return "Sceance [sceanceId=" + sceanceId + ", filmId=" + filmId + ", salleId=" + salleId + ", horaireSceance="
				+ horaireSceance + ", dureeReclams=" + dureeReclams + ", prix=" + prix + ", occupation=" + occupation
				+ ", vostfr=" + vostfr + ", filmAssocie=" + filmAssocie + ", salleAssociee=" + salleAssociee + "]";
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
	 * @return the filmId
	 */
	public int getFilmId() {
		return filmId;
	}
	/**
	 * @param filmId the filmId to set
	 */
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	/**
	 * @return the salleId
	 */
	public int getSalleId() {
		return salleId;
	}
	/**
	 * @param salleId the salleId to set
	 */
	public void setSalleId(int salleId) {
		this.salleId = salleId;
	}
	/**
	 * @return the horaireSceance
	 */
	public Timestamp getHoraireSceance() {
		return horaireSceance;
	}
	/**
	 * @param horaireSceance the horaireSceance to set
	 */
	public void setHoraireSceance(Timestamp horaireSceance) {
		this.horaireSceance = horaireSceance;
	}
	/**
	 * @return the dureeReclams
	 */
	public Time getDureeReclams() {
		return dureeReclams;
	}
	/**
	 * @param dureeReclams the dureeReclams to set
	 */
	public void setDureeReclams(Time dureeReclams) {
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
	
	
	
}
