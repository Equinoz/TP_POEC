package bo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Client {

	private String nom;
	private String abonnement;
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;

	/**
	 * 
	 */
	public Client() {
	}

	/**
	 * @param nom
	 * @param abonnement
	 * @param clientId
	 */
	public Client(String nom, String abonnement, Integer clientId) {
		this.nom = nom;
		this.abonnement = abonnement;
		this.clientId = clientId;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the abonnement
	 */
	public String getAbonnement() {
		return abonnement;
	}

	/**
	 * @param abonnement the abonnement to set
	 */
	public void setAbonnement(String abonnement) {
		this.abonnement = abonnement;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", abonnement=" + abonnement + ", clientId=" + clientId + "]";
	}

}
