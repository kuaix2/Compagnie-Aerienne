public class Avion {
    public int immatriculation;
    public String modele;
    public int capacite;
    public Vol volAssigne;

    public Avion(int immatriculation,String modele,int capacite){
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    public void affecterVol(Vol vol){
        if (volAssigne == null && !vol.etat){
            volAssigne = vol;
            vol.etat = true;
            System.out.println("Vol" + vol + " a ete assigne pour l'avion " + immatriculation);
        } else {
            System.out.println("Error: L'avion/vol a deja ete assigne pour un autre vol/avion.");
        }
    }

    public void verifierDisponibilite(){
        if (volAssigne == null){
            System.out.println("L'avion " + immatriculation + " est disponible");
        } else {
            System.out.println("L'avion " + immatriculation + " n'est pas disponible");
        }
    }

    public int getImmatriculation() { return this.immatriculation; }
    public String getModele() { return this.modele; }
    public int getCapacite() { return this.capacite; }
    public Vol getVolAssigne () {return this.volAssigne;}

    public String avionInfo(){
        return ("immatriculation:" + immatriculation + "\n" +
                "modele:" + modele +"\n" +
                "capacite:" + capacite +"\n");
    }

}
