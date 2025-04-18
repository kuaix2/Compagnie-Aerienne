import java.util.ArrayList;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private  String adresse;
    private String contact ;

    private static ArrayList<Personne> listpersonne = new ArrayList<>();

    public Personne(int id, String nom, String prenom,String adresse, String contact) {
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

    public String getPrenom() {
        return prenom;
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
        System.out.println("Nom : " + nom + ", Prénom : " + prenom + ", adresse : "+adresse+ " , contact : "+ contact);
    }


    public static void ajouter(Personne p) {
        listpersonne.add(p);
        System.out.println("Personne ajoutée: " + p.nom);
    }
    public static Personne chercher(int id) {
        for (Personne p : listpersonne) {
            if (p.id == id) {
                return p;
            }
        }
        System.out.println("Personne avec l'id " + id + " non trouvée.");
        return null;
    }
    public static void modifier(int id, String newNom, String newPrenom, String newAdresse, String newContact) {
        Personne p = chercher(id);
        if (p != null) {
            p.nom = newNom;
            p.prenom = newPrenom;
            p.adresse = newAdresse;
            p.contact = newContact;
            System.out.println("Personne modifiée: " + p.nom);
        }
    }

    public static void supprimer(int id) {
        Personne p = chercher(id);
        if (p != null) {
            listpersonne.remove(p);
            System.out.println("Personne supprimée: " + p.nom);
        }
    }

    public static void lister() {
        System.out.println("Liste des personnes :");
        for (Personne p : listpersonne) {
            System.out.println(p.id + " : " + p.nom + " " + p.prenom);
        }
    }

}
