package compagnies_aériennes;

public class Passager extends Personne{
    private String passeport;
    private List<Reservation> reservations;

    public Passager(int id, String nom, String prenom, String adresse, String contact, String passeport) {
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

public void reserverVol(){

}
public  void annulerReservation(){

}
public void obtenirResevation(){

}

}
