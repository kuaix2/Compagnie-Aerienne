import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creation objet
        Avion avion1 = new Avion(1111, "A001", 10);
        Avion avion2 = new Avion(2222, "A002", 20);
        Avion avion3 = new Avion(3333, "A003", 30);

            //False: Le vol n'a pas encore d'avion
        Vol vol1 = new Vol (1,"Origine1","Destination1","2004-01-01 3:00","2004-01-01 4:00", false);
        Vol vol2 = new Vol (2,"Origine2","Destination2","2004-01-01 3:00","2004-01-01 4:00", false);
        Vol vol3 = new Vol (3,"Origine1","Destination3","2025-05-01 08:00", "2025-05-01 22:00", true);

        Aeroport aeroport1 = new Aeroport("Origine1", "Paris", "Aeroport de Paris");
        Aeroport aeroport2 = new Aeroport("Origine2", "NYC", "Aeroport de NYC");
        Aeroport aeroport3 = new Aeroport("Origine3", "Istanbul", "Aeroport de Istanbul");

        Personne personne1 = new Personne(1, "Ango", "Georges", "123 Rue Exemple", "0123456789");

        Pilote pilote1 = new Pilote(2, "Cruz", "Maxime", "456 Avenue des Pilotes", "0987654321", "EMP002", 2021, "LIC123", 500);
        Pilote pilote2 = new Pilote(3, "Benard", "Brian", "455 Avenue des Pilotes", "098765444", "EMP003", 2021, "LIC456", 5200);

        PersonnelCabine pc1 = new PersonnelCabine(3, "Sotiras", "Roman", "789 Boulevard des Cabines", "0556677889", "EMP004", 2022, "Qualification Senior");
        PersonnelCabine pc2 = new PersonnelCabine(4, "Chaptini", "Camille", "789 Boulevard des Cabines", "0556677899", "EMP008", 2022, "Qualification Senior");

        Passager passager1 = new Passager(1,"Chuang","Shu-han","Paris","01 23 45 67 80","Passport1111");
        Passager passager2 = new Passager(2,"Benard","Allan","Paris","01 23 45 67 88","Passport11112222");
        ArrayList<Passager> passagers = new ArrayList<Passager>();
        passagers.add(passager1);
        passagers.add(passager2);
        Reservation reservation1 = new Reservation( "2004-1-2 15:00", passager1, vol1);

        vol1.ajouterPassager(passager1);
        vol1.ajouterPassager(passager2);

        ArrayList<Vol> vols = new ArrayList<Vol>();
        vols.add(vol1);
        vols.add(vol2);
        vols.add(vol3);

        //Export
        ArrayList<Avion> avions = new ArrayList<>();
        avions.add(avion1);
        avions.add(avion2);
        avions.add(avion3);
        Exporter.exportAvions(avions, "src/avions.csv");
        Exporter.exportVols(vols, "src/vols.csv");
        Exporter.exportPassagers(passagers, "src/passagers.csv");

        //Importation
        System.out.println("----- Premiere importation - sans changement -----");

        ArrayList<Vol> volsImporte;
        volsImporte = Importer.importVol("src/vols.csv");

        for (Vol vol : volsImporte) {
            System.out.println(vol.volInfo());
        }

        ArrayList<Avion> avionsImporte;
        avionsImporte = Importer.importAvion("src/avions.csv");

        for (Avion avion : avionsImporte) {
            System.out.println(avion.avionInfo());
        }

        ArrayList<Passager> passagersImporte;
        passagersImporte = Importer.importPassager("src/passagers.csv");

        for (Passager passager : passagersImporte) {
            System.out.println(passager.passagerInfo());
        }


        //Test manuelle
        System.out.println("---- Test de la classe Personne ----");
        personne1.obtenirInfos();
        personne1.setNom("Benard");
        System.out.println("Nom modifié : " + personne1.getNom());
        System.out.println();

        System.out.println("---- Test de la classe Pilote (Employé) ----");
        pilote1.obtenirInfos();
        System.out.println("Rôle : " + pilote1.obtenirRole());
        System.out.println("Licence : " + pilote1.getLicence());
        System.out.println("Heures de vol : " + pilote1.getHeuresDeVol());

        pilote1.affecterVol(vol2);
        pilote1.obtenirVol();
        pilote2.obtenirVol();//Cas ou le pilot n'est pas effecter a un vol
        System.out.println();



        System.out.println("---- Test de la classe PersonnelCabine (Employé) ----");
        pc1.obtenirInfos();
        System.out.println("Rôle : " + pc1.obtenirRole());
        System.out.println("Qualification : " + pc1.getQualification());
        pc1.affecterVol(vol2);
        pc1.obtenirVol();
        pc2.obtenirRole();//Cas ou le  personnel n'est pas effecter a un vol
        System.out.println();




        System.out.println("---- Test de la classe Passager ----");
        passager1.obtenirInfos();
        System.out.println("Passeport : " + passager1.getPasseport());
        passager1.reserverVol(vol2);
        System.out.println("Après réservation, les réservations du passager : ");
        passager1.obtenirResevation();

        if (!passager1.getReservations().isEmpty()) {
            Reservation res = passager1.getReservations().get(0);
            passager1.annulerReservation(res);
            System.out.println("Après annulation, les réservations du passager : ");
            passager1.obtenirResevation();
            System.out.println();
        }

        //Fonctions dans le fichier Avion.java
        System.out.println("----- AFFECTATION DES AVIONS-VOLS -----");
        avion1.affecterVol(vol1);
        avion1.affecterVol(vol2); //Erreur type 1
        avion2.affecterVol(vol1); //Erruer type 2
        avion2.affecterVol(vol2);

        System.out.println("\n ----- AFFICHAGE DES DISPONIBILITE -----");
        avion1.verifierDisponibilite();
        avion3.verifierDisponibilite();

        //Fonctions dans Aeroport.java
        System.out.println("\n ----- AFFECTATION DES AVIONS-AEROPORT -----");
        aeroport1.affecterVol(vols);
        System.out.println(aeroport1);

        //Fonctions dans vol.java
        System.out.println("\n ----- ANNULATION ET MODIFICATION DES VOLS -----");
        System.out.println("Avant annulation: " + vols);
        vol1.annulerVol(vols);
        System.out.println("Apres annulation: " + vols);

        System.out.println("Avant modif:\n" + vol2.volInfo());
        vol2.modifierVol("2025-1-1 3:00","2025-1-1 6:00");
        System.out.println("Apres modif:\n " + vol2.volInfo());



        System.out.println("\n ----- LISTE DE PASSAGER DANS UN VOL SPECIFIQUE -----");
        vol1.listingPassager();


        System.out.println("\n ----- PLANNIFICATION DES VOLS -----");
        Vol.planifierVol(vols, vol3, 10, 2);

        for (Vol v : vols) {
            System.out.println(v.volInfo());
        }


        //Fonctions dans Reservation.java
        System.out.println("\n ----- ANNULATION ET MODIFICATION DES RESERVATION -----");
        System.out.println("Avant confirmation: \n " + reservation1);

        System.out.println(" \n Apres confirmation: ");
        reservation1.confirmerReservation();
        System.out.println(reservation1);

        System.out.println(" \n Apres annulation: ");
        reservation1.annulerReservation();
        System.out.println(reservation1);

        System.out.println("\n Modif de vol:");
        reservation1.modifierReservation(99, vols); //Cas ou le vol n'existe pas
        reservation1.modifierReservation(2, vols);

        System.out.println("----- Deuxieme importation - apres changement -----");
        Exporter.exportVols(vols, "src/vols.csv");

        volsImporte = Importer.importVol("src/vols.csv");

        for (Vol vol : volsImporte) {
            System.out.println(vol.volInfo());
        }


    }
}
