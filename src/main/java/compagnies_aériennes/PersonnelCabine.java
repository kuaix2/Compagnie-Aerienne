import java.util.ArrayList;


public class PersonnelCabine extends Employe{
    private String qualification;
    private Vol volAssigne;

    private static ArrayList<PersonnelCabine> listePersonnel = new ArrayList<>();


    public PersonnelCabine(int id, String nom, String prenom, String adresse, String contact, String numeroEmploye, int dateEmbauche , String qualification) {
        super(id, nom, prenom,adresse,contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
        this.volAssigne = null;
    }

    public static void ajouter(PersonnelCabine pc) {
        listePersonnel.add(pc);
        System.out.println("Personnel de cabine ajouté: " + pc.getNom());
    }

    public static PersonnelCabine chercher(int id) {
        for (PersonnelCabine pc : listePersonnel) {
            if (pc.getid() == id) {
                return pc;
            }
        }
        System.out.println("Personnel de cabine avec l'id " + id + " non trouvé.");
        return null;
    }

    public static void modifier(int id, String newQualification) {
        PersonnelCabine pc = chercher(id);
        if (pc != null) {
            pc.qualification = newQualification;
            System.out.println("Personnel de cabine modifié: " + pc.getNom());
        }
    }

    public static void supprimer(int id) {
        PersonnelCabine pc = chercher(id);
        if (pc != null) {
            listePersonnel.remove(pc);
            System.out.println("Personnel de cabine supprimé: " + pc.getNom());
        }
    }

    public static void lister() {
        System.out.println("Liste du personnel de cabine:");
        for (PersonnelCabine pc : listePersonnel) {
            System.out.println(pc.getid() + " : " + pc.getNom());
        }
    }

    public void affecterVol(Vol vol){
        if (this.volAssigne == null) {
            this.volAssigne = vol;
            System.out.println("Personnel de cabine " + this.getNom() + " a été assigné au vol " + vol.numeroVol);
        } else {
            System.out.println("Le personnel de cabine " + this.getNom() + " a déjà un vol assigné (vol " + this.volAssigne.numeroVol + ").");
        }

    }
    public void obtenirVol(){
        if (this.volAssigne != null) {
            System.out.println("Vol assigné pour le personnel de cabine " + this.getNom() + " : ");
            System.out.println(this.volAssigne.volInfo());
        } else {
            System.out.println("Aucun vol assigné pour le personnel de cabine " + this.getNom() + ".");
        }

    }



    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String obtenirRole() {
        return "Personnel de Cabine";
    }
}
