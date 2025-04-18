import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Reservation {
    private String numeroReservation;
    private String dateResevation;
    private String statut;

    private Passager passager;
    private Vol vol;

    public Reservation(String dateResevation, Passager passager, Vol vol) {
        this.numeroReservation = generernumeroReservation();
        this.dateResevation = dateResevation;
        this.statut = "Non confirmée";
        this.passager = passager;
        this.vol = vol ;
    }

    private String generernumeroReservation() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getNumeroResevation(){
        return numeroReservation;
    }
    public String getDateResevation(){
        return dateResevation;
    }
    public String getStatut(){
        return statut;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public void setDateResevation(String dateResevation) {
        this.dateResevation = dateResevation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Passager getPassager() {
        return passager;
    }
    public void setPassager(Passager passager) {
        this.passager = passager;
    }
    public Vol getVol(){
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public void confirmerReservation() {
        this.statut = "Confirmée";
        System.out.println("La réservation " + numeroReservation + " est confirmée.");
    }


    public void annulerReservation(){
        this.statut = "Annulée";
        System.out.println("La résevation "+ numeroReservation+ " est annulée");
    }


    public void modifierReservation(int newNumVol, ArrayList<Vol> vols){
        boolean volTrouve = false;
        for (Vol vol : vols){
            if (newNumVol == vol.numeroVol) {
                System.out.println("Vol trouve et modifie");
                this.vol.numeroVol = newNumVol;
                volTrouve = true;
                break;
            }
        }
        if (!volTrouve) {
            System.out.println("Pas de vol disponible");
        }
    }


    @Override
    public String toString() {
        return "numeroReservation: " + numeroReservation + '\n' +
                "dateResevation: " + dateResevation + '\n' +
                "statut: " + statut + '\n' +
                "passager: " + passager + "\n" +
                "vol: " + vol;
    }


}


