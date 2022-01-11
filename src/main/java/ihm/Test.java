package ihm;


import java.time.LocalTime;

import bll.SceanceManager;

public class Test {

	public static void main(String[] args) {		
		//System.out.println(SceanceManager.selectAll());
		Integer sceanceId = 4;
		System.out.println("Heure actuelle :"+ LocalTime.now());
		System.out.println("Horaire :"+SceanceManager.selectById(sceanceId).getHoraireSceance());
		System.out.println("Durée des réclames :"+SceanceManager.selectById(sceanceId).getDureeReclams().toMinutes()+"min");
		System.out.println("Durée du film :"+SceanceManager.selectById(sceanceId).getFilmAssocie().getDuree().toHours()+"h "+SceanceManager.selectById(sceanceId).getFilmAssocie().getDuree().toMinutesPart()+"min");
		System.out.println("Temps écoulé :"+SceanceManager.getTimePassedSceance(SceanceManager.selectById(sceanceId)));		
		System.out.println("Temps restant :"+SceanceManager.getRemainingTimeBySceance(SceanceManager.selectById(sceanceId)));
	}

}
