import java.util.ArrayList;

public class Pilote extends Employe{
    private String licence;
    private int heuresDeVol ;
    private Vol volAssigne ;

    private static ArrayList<Pilote> listPilot = new ArrayList<>();
    public Pilote(int id, String nom, String prenom,String adresse, String contact, String numeroEmploye, int dateEmbauche, String licence, int heuresDeVol) {
        super(id, nom, prenom, adresse,contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
        this.volAssigne = null;
    }


    public static void ajouter(Pilote p) {
        listPilot.add(p);
        System.out.println("Pilote ajouté: " + p.getNom());
    }

    public static Pilote chercher(int id) {
        for (Pilote p : listPilot) {
            if (p.getid() == id) {
                return p;
            }
        }
        System.out.println("Pilote avec l'id " + id + " non trouvé.");
        return null;
    }

    public static void modifier(int id, String newLicence, int nouvellesHeuresDeVol) {
        Pilote p = chercher(id);
        if (p != null) {
            p.licence = newLicence;
            p.heuresDeVol = nouvellesHeuresDeVol;
            System.out.println("Pilote modifié: " + p.getNom());
        }
    }

    public static void supprimer(int id) {
        Pilote p = chercher(id);
        if (p != null) {
            listPilot.remove(p);
            System.out.println("Pilote supprimé: " + p.getNom());
        }
    }

    public static void lister() {
        System.out.println("Liste des pilotes:");
        for (Pilote p : listPilot) {
            System.out.println(p.getid() + " : " + p.getNom());
        }
    }

    public void affecterVol(Vol vol){
        if(this.volAssigne == null) {
            this.volAssigne = vol;
            System.out.println("Pilote " + this.getNom() + " a été assigné au vol " + vol.numeroVol);
        } else {
            System.out.println("Le pilote " + this.getNom() + " a déjà un vol assigné (vol " + this.volAssigne.numeroVol + ").");
        }

    }
    public void obtenirVol(){
        if(this.volAssigne != null) {
            System.out.println("Vol assigné au pilote " + this.getNom() + " : ");
            System.out.println(this.volAssigne.volInfo());
        } else {
            System.out.println("Aucun vol assigné pour le pilote " + this.getNom() + ".");
        }

    }


    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }
}
