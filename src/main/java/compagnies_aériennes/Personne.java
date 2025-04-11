package compagnies_aériennes;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private  String adresse;
    private String contact ;

    public Personne(int id, String nom, String prenom, String adresse, String contact) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse =adresse;
        this.contact = contact;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public  void obtenirInfos(){
        System.out.println("Nom : " + nom + ", Prénom : " + prenom + ", adresse"+adresse+ " , contac"+ contact);
    }

}
