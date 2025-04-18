import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exporter {

    public static void exportAvions(List<Avion> avions, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("immatriculation,capacite,modele\n");
            for (Avion avion : avions) {
                writer.append(avion.getImmatriculation() + "," + avion.getCapacite() + "," + avion.getModele() + "\n");
            }
        } catch (IOException e) {
            System.out.println("les erreurs d'entrée/sortie");
        }
        System.out.println("Info Avions exportés avec succès");
    }

    public static void exportVols(List<Vol> vols, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("numeroVol,origine,destination,depart,arrivee,etat\n");
            for (Vol vol : vols) {
                writer.append(vol.getNumeroVol() + "," + vol.getOrigine() + "," + vol.getDestination() + ","
                        + vol.getDateHeureDepart() + "," + vol.getDateHeureArrivee() + "," + vol.isEtat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("les erreurs d'entrée/sortie");
        }
        System.out.println("Info Vols exportés avec succès");
    }

    public static void exportPassagers(List<Passager> passagers, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("id,nom,prenom,adresse,contact,passeport\n");
            for (Passager p : passagers) {
                writer.append(p.getid() + "," + p.getNom() + "," + p.getPrenom() + "," +
                        p.getAdresse() + "," + p.getContact() + "," + p.getPasseport() + "\n");
            }
        } catch (IOException e) {
            System.out.println("les erreurs d'entrée/sortie");
        }
        System.out.println("Info Passagers exportés avec succès");
    }
}
