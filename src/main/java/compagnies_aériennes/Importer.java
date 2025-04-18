import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Importer {

    public static ArrayList<Vol> importVol(String filePath) {
        ArrayList<Vol> listeVol = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    try {
                        int numeroVol = Integer.parseInt(parts[0]);
                        String origine = parts[1];
                        String destination = parts[2];
                        String dateHeureDepart = parts[3];
                        String dateHeureArrive = parts[4];
                        Boolean etat = Boolean.parseBoolean(parts[5]);

                        Vol vol = new Vol(numeroVol, origine, destination, dateHeureDepart, dateHeureArrive, etat);
                        listeVol.add(vol);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format (vol) : " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("les erreurs d'entrée/sortie (vol)");
        }

        System.out.println("Info (Vols) importés avec succès");
        return listeVol;
    }

    public static ArrayList<Avion> importAvion(String filePath) {
        ArrayList<Avion> listeAvion = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    try {
                        int immatriculation = Integer.parseInt(parts[0]);
                        int capacite = Integer.parseInt(parts[1]);
                        String modele = parts[2];

                        Avion avion = new Avion(immatriculation,modele,capacite);
                        listeAvion.add(avion);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format sur les données du avion : " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("les erreurs d'entrée/sortie");
        }

        System.out.println("Info Avions importés avec succès");
        return listeAvion;
    }

    public static ArrayList<Passager> importPassager(String filePath) {
        ArrayList<Passager> listePassager = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String nom = parts[1];
                        String prenom = parts[2];
                        String adresse = parts [3];
                        String contact = parts [4];
                        String passeport = parts [5];

                        Passager passager = new Passager(id,nom,prenom,adresse,contact,passeport);
                        listePassager.add(passager);
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format sur les données du passager : " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("les erreurs d'entrée/sortie" + e.getMessage());
        }

        System.out.println("Info Passagers importés avec succès");
        return listePassager;
    }
}
