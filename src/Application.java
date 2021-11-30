import bo.Salle;
import dao.SalleDAOJDBClmpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SalleDAOJDBClmpl dao = new SalleDAOJDBClmpl();

        List<Salle> salles = dao.sellectAll();
        for (Salle salle : salles){
            System.out.println(salle.toString());
        }
        System.out.println("----");


        // --------------
        Salle salleInsert = new Salle();
        salleInsert.setSalle_id(7);
        salleInsert.setCapacité(60);
        salleInsert.setNumero_salle(6);
        salleInsert.setEquipement_3D(1);
        salleInsert.setCinemas_id(0);
        int salle_id = dao.insert(salleInsert);
        salleInsert.setSalle_id(salle_id);

        System.out.println(salle_id);
        //-----------------------------------

        Salle salledelete = new Salle();
        salledelete.setSalle_id(7);
        int salles_id = dao.delete(salledelete);
        salledelete.setSalle_id(salles_id);
    }
}
