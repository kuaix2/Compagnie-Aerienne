package compagnies_aériennes;

public class Pilote extends Employe{
    private String licence;
    private int heuresDeVol ;
    public Pilote(int id, String nom, String prenom, String adresse, String contact, String numeroEmploye, int dateEmbauche, String licence, int heuresDeVol) {
        super(id, nom, prenom, adresse,contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public void affecterVol(){

    }
    public void obtenirVol(){

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
