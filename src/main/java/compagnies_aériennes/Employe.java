package compagnies_aériennes;

public abstract class Employe extends Personne{

    private String numeroEmploye;
    private int dateEmbauche;
    public Employe(int id, String nom, String prenom, String adresse, String contact, String numeroEmploye, int dateEmbauche) {
        super(id, nom, prenom,adresse,contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }

    public void setNumeroEmploye(String numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public int getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(int dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String obtenirRole() {
        return "Employé";
    }


}
