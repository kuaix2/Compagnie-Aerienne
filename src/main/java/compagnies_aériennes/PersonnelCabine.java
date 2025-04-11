package compagnies_aériennes;

public class PersonnelCabine extends Employe{
    private String qualification;
    public PersonnelCabine(int id, String nom, String prenom, String adresse, String contact, String numeroEmploye, int dateEmbauche , String qualification) {
        super(id, nom, prenom,adresse,contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public void affrcterVol(){

    }
    public void obtenirVol(){

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
