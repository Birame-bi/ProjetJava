

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vaisseau {

    private int armure, fuel, oxygène;
    private Salle[] salles = new Salle[27];

    public Vaisseau(int a, int f, int o) {

        this.armure = a;
        this.fuel = f;
        this.oxygène = o;
        init();
        placementObjets();
    }
    
    //principale méthode, création des salles
    private void init() {
        //ensembles de noms des salles, de leurs code d'accès, et des équipements 
        String[] tableauDeNomSalle = new String[]{"Pont", "Tourelle Alpha avant", "Tourelle Beta avant", "Couloir Avant", "Jardin Hydroponique", "Laboratoire", "Stockage Avant", "Infirmerie", "Tourelle Alpha centre", "Tourelle Beta centre", "Baie Alpha", "Couloir central", "Baie Beta", "Stockage Alpha centre", "Réfectoire", "Stockage Beta centre", "Dortoir Alpha", "Nexus", "Dortoire Beta", "Baie Alpha 2", "Couloir arrière", "Stockage Alpha arrière", "Stockage Beta arrière", "Baie Icarus", "Salle des moteurs", "Tourelle Alpha arrière", "Tourelle Beta arrière"};
        String[] tableauAccesSalle = new String[]{"ABC", "@C", "@C", "@ABDEFG", "CF", "CG", "CDH", "CEI", "FJ", "GL", "HKMPS", "JLN", "IKORT", "J", "K", "L", "J", "T", "L", "JTXY", "LPQRSUVW", "TY", "TY", "TYZ", "SY", "SUVWXZ", "WY"};
        String[] equipementsNom = new String[]{"douche", "lit", "jet d'attaque", "jet d'exploration", "NERON", "PILGRED", "terminal planète", "système de navigation", "terminal recherche"};
        
        
        for (int i = 0; i < 27; i++) { //27 salles
            //première partie, obtention de l'ensemble des salles auxquelles la salle à accès. Complexe.
            //passage du code de chaque case de tableauAccesSalle à une liste des caractères que le composent
            List charAcces = Arrays.asList(tableauAccesSalle[i].toCharArray());

            Set<String> acces = new HashSet<>();
            for (int j = 0; j < charAcces.size(); j++) { //pour chaque élément de la liste
                //@ est le char 64, suivi de toutes les majuscules. On récupère un int à partir de la valeur ASCII du caractère
                int h = ((int) charAcces.get(j) )-64; 
                //on ajoute la salle correspondante aux salles auquelles cette salle a accès
                acces.add(tableauDeNomSalle[h]);
            }
            //ajout des équipements aux salles
            Set<String> equipements = new HashSet<>();
            switch (i) {
                case 16,17 -> {
                    for (int j = 0; j < 3; j++) {
                        equipements.add(equipementsNom[1]);
                    }
                    equipements.add(equipementsNom[0]);
                }
                case 10,12,19 -> {
                    for (int j = 0; j < 3; j++) {
                        equipements.add(equipementsNom[2]);
                    }
                }
                case 23 -> equipements.add(equipementsNom[3]);
                case 18 -> equipements.add(equipementsNom[4]);
                case 25 -> equipements.add(equipementsNom[5]);
                case 0 -> {
                    equipements.add(equipementsNom[6]);
                    equipements.add(equipementsNom[7]);
                }
                case 5 -> equipements.add(equipementsNom[8]);
            }

            this.salles[i] = new Salle(tableauDeNomSalle[i], acces, equipements);
        }
        
    }
    
    //Placement aléatoire des objets dans les salles. Complexe.
    private void placementObjets() {
        int nbObjet;
        String[] tableauDeNomObjet = new String[]{"armure", "combinaison", "gants de protection", "savon", "tablier intachable", "trotinette", "extincteur", "couteau", "blaster", "grenade", "médikit", "caméra", "souche de test", "débrit métallique", "chat", "ration standard", "extracteur", "serum"};
        //on détermine pour chaque objets combien d'exemplaires de cet objet on va ajouter
        for (int j = 0; j < 18; j++) {
            nbObjet = switch (j) {
                case 1 -> 4;
                case 6 -> 3;
                case 8 -> 2;
                case 11 -> 2;
                case 13 -> 30;
                case 15 -> 30;
                default -> 1;
            };
            int objetPlace = 0; //on déclare un booléen
            for (int k = 0; k < nbObjet; k++) { //pour chaque exemplaire de cet objet
                do {
                    int x = NbAleatoire(26); //on génère aléatoirement le numéro de la salle dans laquelle on ajoute l'objet
                    if (this.salles[x].Objets.length <= 3) { //si le stockage de la salle n'est pas plein, on l'ajoute
                        this.salles[x].Objets[this.salles[x].Objets.length] = tableauDeNomObjet[j];
                        objetPlace = 1; //l'objet a bien été ajouté, on met le booléen à vrai
                    }
                } while (objetPlace != 1); //tant que l'objet n'a pas été placé, on génére un autre numéro de salle et on reccomence
                objetPlace = 0; //on réinitialise le booléen avant de passer à l'objet suivant
            }
        }
    }
    
    public static int NbAleatoire(int n) { //génération d'un nombre aléatoire
        int nb = (int) (Math.random() * n);
        return nb;
    }


}
