
import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne{
    private String passeport;
    private List<Reservation> reservations;

    private static ArrayList<Passager> listePassager = new ArrayList<>();

    public Passager(int id, String nom, String prenom,String adresse, String contact, String passeport) {
        super(id, nom, prenom,adresse,contact);
        this.passeport = passeport;
        this.reservations = new ArrayList<>();
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }


    public static void ajouter(Passager p) {
        listePassager.add(p);
        System.out.println("Passager ajouté: " + p.getNom());
    }

    public static Passager chercher(int id) {
        for (Passager p : listePassager) {
            if (p.getid() == id) {
                return p;
            }
        }
        System.out.println("Passager avec l'id " + id + " non trouvé.");
        return null;
    }

    public static void modifier(int id, String newPasseport) {
        Passager p = chercher(id);
        if (p != null) {
            p.setPasseport(newPasseport);
            System.out.println("Passager modifié: " + p.getNom());
        }
    }

    public static void supprimer(int id) {
        Passager p = chercher(id);
        if (p != null) {
            listePassager.remove(p);
            System.out.println("Passager supprimé: " + p.getNom());
        }
    }

    public static void lister() {
        System.out.println("Liste des passagers :");
        for (Passager p : listePassager) {
            System.out.println(p.getid() + " : " + p.getNom());
        }
    }


public void reserverVol(Vol vol){
        Reservation reservation = new Reservation( "2022...",this, vol);
        reservations.add(reservation);
}
public  void annulerReservation(Reservation r){
        if(reservations.contains(r)){
            r.annulerReservation();
            reservations.remove(r);
        }
        else {
            System.out.println("reservation introuvable");
        }

}
public void obtenirResevation(){
       System.out.println(reservations);
       }


    public String passagerInfo(){
        return ("id:" + getid() + "\n" +
                "nom:" + getNom() +"\n" +
                "prenom:" + getPrenom() +"\n" +
                "adresse:" + getAdresse() +"\n" +
                "contact" + getContact() +"\n" +
                "Passeport" + getPasseport() +"\n");
    }

    @Override
    public String toString() {
        return (getNom());
    }

}
