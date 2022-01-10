package bo;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Reservation {
	@ManyToOne
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

	/**
	 * 
	 */
	public Reservation() {
	}

	/**
	 * @param client
	 * @param sceance
	 * @param nombrePlaces
	 * @param reduction
	 * @param reservationId
	 */
	public Reservation(Client client, Sceance sceance, Integer nombrePlaces, String reduction, Integer reservationId) {
		this.client = client;
		this.sceance = sceance;
		this.nombrePlaces = nombrePlaces;
		this.reduction = reduction;
		this.reservationId = reservationId;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the sceance
	 */
	public Sceance getSceance() {
		return sceance;
	}

	/**
	 * @param sceance the sceance to set
	 */
	public void setSceance(Sceance sceance) {
		this.sceance = sceance;
	}

	/**
	 * @return the nombrePlaces
	 */
	public Integer getNombrePlaces() {
		return nombrePlaces;
	}

	/**
	 * @param nombrePlaces the nombrePlaces to set
	 */
	public void setNombrePlaces(Integer nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	/**
	 * @return the reduction
	 */
	public String getReduction() {
		return reduction;
	}

	/**
	 * @param reduction the reduction to set
	 */
	public void setReduction(String reduction) {
		this.reduction = reduction;
	}

	/**
	 * @return the reservationId
	 */
	public Integer getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public String toString() {
		return "Reservation [client=" + client + ", sceance=" + sceance + ", nombrePlaces=" + nombrePlaces
				+ ", reduction=" + reduction + ", reservationId=" + reservationId + "]";
	}

}
