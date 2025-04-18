import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Vol {
    public int numeroVol;
    public String origine;
    public String destination;
    public String dateHeureDepart;
    public String dateHeureArrivee;
    public boolean etat;
    public ArrayList<Passager> passagers;

    public Vol(int numeroVol,String origine,String destination,String dateHeureDepart,String dateHeureArrivee, boolean etat){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart=dateHeureDepart;
        this.dateHeureArrivee=dateHeureArrivee;
        this.etat=etat;
        this.passagers = new ArrayList<>();
    }


    public void ajouterPassager(Passager p) {
        passagers.add(p);
    }

    public ArrayList<Passager> getPassagers() {
        return passagers;
    }

    public void annulerVol(ArrayList<Vol> vols){
        Iterator<Vol> iterator = vols.iterator();
        while (iterator.hasNext()) {
            Vol vol = iterator.next();
            if (vol.numeroVol == this.numeroVol) {
                iterator.remove();
            }
        }
    }

    public void modifierVol(String newDateHeureDepart,
                            String newDateHeureArrivee){
                this.dateHeureDepart = newDateHeureDepart;
                this.dateHeureArrivee = newDateHeureArrivee;
            }

    public void listingPassager() {
        if (passagers.isEmpty()) {
            System.out.println("Vol " + numeroVol + " vide!");
        } else {
            System.out.println("Liste de passagers d'avion " + numeroVol + " :");
            for (Passager p : passagers) {
                System.out.println("- " + p);
            }
        }
    }

    public static void planifierVol(ArrayList<Vol> vols, Vol modele, int jours, int pas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime depart = LocalDateTime.parse(modele.dateHeureDepart, formatter);
        LocalDateTime arrivee = LocalDateTime.parse(modele.dateHeureArrivee, formatter);

        for (int i = 0; i < jours; i += pas) {
            LocalDateTime newDepart = depart.plusDays(i);
            LocalDateTime newArrivee = arrivee.plusDays(i);

            Vol nouveauVol = new Vol(
                    modele.numeroVol + 1 + i,
                    modele.origine,
                    modele.destination,
                    newDepart.format(formatter),
                    newArrivee.format(formatter),
                    modele.etat
            );

            vols.add(nouveauVol);
        }
    }

    public int getNumeroVol() {return numeroVol;}
    public String getOrigine() {
        return origine;
    }
    public String getDestination() {
        return destination;
    }
    public String getDateHeureDepart() {
        return dateHeureDepart;
    }
    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }
    public boolean isEtat() {return etat;}


    public String volInfo(){
        return ("Vol:" + numeroVol + "\n" +
                "Origine:" + origine +"\n" +
                "Destination:" + destination +"\n" +
                "Temps depart:" + dateHeureDepart +"\n" +
                "Temps arrive:" + dateHeureArrivee +"\n" +
                "Etat: " + etat + "\n");
    }

    @Override
    public String toString() {
        return (Integer.toString(numeroVol));
    }
}
