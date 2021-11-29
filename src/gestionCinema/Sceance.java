package gestionCinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sceance {
	
	private int sceance_id;
	private int film_id;
	private LocalDateTime horaire_sceance;
	private LocalDateTime duree_reclams;
	private int prix;
	private int salle_id;
	private int occupation;
	private boolean VOSTFR;
	public int getSceance_id() {
		return sceance_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public LocalDateTime getHoraire_sceance() {
		return horaire_sceance;
	}
	public LocalDateTime getDuree_reclams() {
		return duree_reclams;
	}
	public int getPrix() {
		return prix;
	}
	public int getSalle_id() {
		return salle_id;
	}
	public int getOccupation() {
		return occupation;
	}
	public boolean isVOSTFR() {
		return VOSTFR;
	}
	public Sceance(int sceance_id, int film_id, LocalDateTime horaire_sceance, LocalDateTime duree_reclams, int prix,
			int salle_id, int occupation, boolean vOSTFR) {
		super();
		this.sceance_id = sceance_id;
		this.film_id = film_id;
		this.horaire_sceance = horaire_sceance;
		this.duree_reclams = duree_reclams;
		this.prix = prix;
		this.salle_id = salle_id;
		this.occupation = occupation;
		VOSTFR = vOSTFR;
	}
	@Override
	public String toString() {
		return "Sceance [sceance_id=" + sceance_id + ", film_id=" + film_id + ", horaire_sceance=" + horaire_sceance
				+ ", duree_reclams=" + duree_reclams + ", prix=" + prix + ", salle_id=" + salle_id + ", occupation="
				+ occupation + ", VOSTFR=" + VOSTFR + "]";
	}
	
	
	
	public static ArrayList<Integer> getFilmsByHour(ArrayList<Sceance> lstSceance, Integer hour){
		
		ArrayList<Integer> lstFilmId = new ArrayList<Integer>();
		
		
		for(Sceance sc : lstSceance) {
			if(hour.equals(sc.getHoraire_sceance().getHour())) {
				lstFilmId.add(sc.getFilm_id());
			}
		}		
		return lstFilmId;
	}
	
	

}
