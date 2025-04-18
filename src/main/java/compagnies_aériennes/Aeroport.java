import java.util.ArrayList;
import java.util.Objects;

public class Aeroport {
    public String nom;
    public String ville;
    public String description;
    public ArrayList<Vol> volDestinationList;
    public ArrayList<Vol> volOrigineList;

    // Initialisation des listes dans le constructeur
    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.volOrigineList = new ArrayList<>();
        this.volDestinationList = new ArrayList<>();
    }

    public void affecterVol(ArrayList<Vol> volList) {
        for (Vol currentVol : volList) {
            boolean alreadyInOrigineList = false;
            for (Vol v : volOrigineList) {
                if (v.equals(currentVol)) {
                    alreadyInOrigineList = true;
                    System.out.println("Le vol d'origine est déjà dans cet aéroport");
                    break;
                }
            }

            boolean alreadyInDestinationList = false;
            for (Vol v : volDestinationList) {
                if (v.equals(currentVol)) {
                    alreadyInDestinationList = true;
                    System.out.println("Le vol de destination est déjà dans cet aéroport");
                    break;
                }
            }

            if (!alreadyInOrigineList) {
                if (Objects.equals(nom, currentVol.origine)) {
                    volOrigineList.add(currentVol);
                }
            }
            else if (!alreadyInDestinationList) {
                if (Objects.equals(nom, currentVol.destination)) {
                    volDestinationList.add(currentVol);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Aéroport: " + nom + "\n" +
                "Ville: " + ville + "\n" +
                "Description: " + description + "\n" +
                "Vols partant: " + volOrigineList + "\n" +
                "Vols entrants: " + volDestinationList;
    }
}
