package bo;

public class Salle {
    private int salle_id;
    private int capacité;
    private int numero_salle;
    private int equipement_3D;
    private int cinemas_id;

    public Salle(int salle_id, int capacité, int numero_salle, int equipement_3D, int cinemas_id) {
        this.salle_id= salle_id;
        this.capacité = capacité;
        this.numero_salle = numero_salle;
        this.equipement_3D = equipement_3D;
        this.cinemas_id = cinemas_id;
    }

    public Salle() {

    }


    public int getSalle_id() {
        return salle_id;
    }

    public void setSalle_id(int salle_id) {
        this.salle_id = salle_id;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public int getNumero_salle() {
        return numero_salle;
    }

    public void setNumero_salle(int numero_salle) {
        this.numero_salle = numero_salle;
    }

    public int getEquipement_3D() {
        return equipement_3D;
    }

    public void setEquipement_3D(int equipement_3D) {
        this.equipement_3D = equipement_3D;
    }

    public int getCinemas_id() {
        return cinemas_id;
    }

    public void setCinemas_id(int cinemas_id) {
        this.cinemas_id = cinemas_id;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "salle_id=" + salle_id +
                ", capacité=" + capacité +
                ", numero_salle=" + numero_salle +
                ", equipement_3D=" + equipement_3D +
                ", cinemas_id=" + cinemas_id +
                '}';
    }
}
