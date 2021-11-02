public class Personnage {
        private String nom;
	private String competence1;
	private String competence2;
	private String role; //humain ou mush
	private String localisation; //salle où le joueur se trouve
        private int pm, pa, pmo, pv;
	//private boolean debout;
	//private boolean propre;
	//private int satiete; //un personnage est à satiété pendant 3 cycles (le int permet le décompte)
        
        public Personnage (String n, String c1, String c2, String r, String l, int pm, int pa, int pmo, int pv) {
            this.nom = n;
            this.competence1 = c1;
            this.competence2 = c2;
            this.role = r;
            this.localisation = l;
            this.pm = pm;
            this.pa = pa;
            this.pmo = pmo;
            this.pv = pv;
        }
	
              
        public void competence(String nom) { //initialisation des compétences selon le personnage
            String[] tableauDeCompetence = new String[] {"Tireur", "Bourreau", "Seul espoir", "Traqueur", "Observateur", "Biologiste", "Infirmier", "Astrophysicien", "Pilote", "Robuste", "Paranoïaque", "Technicien", "Mycologiste", "Psy", "Informaticien", "Leader", "Concepteur", "Optimiste", "Logistique", "Physicien", "Détaché", "Sprinter", "Cuistot"};
            
            switch (nom) {
                case "Wang Chao":
                    this.competence1 = tableauDeCompetence[0];
                    this.competence2 = tableauDeCompetence[1];
                case "Zhong Chun":
                    this.competence1 = tableauDeCompetence[2];
                    this.competence2 = tableauDeCompetence[6];
                case "Eleesha Williams":
                    this.competence1 = tableauDeCompetence[3];
                    this.competence2 = tableauDeCompetence[4];
                case "Finola Keegan":
                    this.competence1 = tableauDeCompetence[5];
                    this.competence2 = tableauDeCompetence[6];
                case "Frieda Bergmann":
                    this.competence1 = tableauDeCompetence[7];
                    this.competence2 = tableauDeCompetence[8];
                case "Gioele Rinaldao":
                    this.competence1 = tableauDeCompetence[9];
                    this.competence2 = tableauDeCompetence[10];
                case "Jiang Hua":
                    this.competence1 = tableauDeCompetence[8];
                    this.competence2 = tableauDeCompetence[11];
                case "Ian Soulton":
                    this.competence1 = tableauDeCompetence[5];
                    this.competence2 = tableauDeCompetence[12];
                case "Janice Kent":
                    this.competence1 = tableauDeCompetence[13];
                    this.competence2 = tableauDeCompetence[14];
                case "Kim Jin Su":
                    this.competence1 = tableauDeCompetence[15];
                    this.competence2 = tableauDeCompetence[8];
                case "Lai Kuan-Ti":
                    this.competence1 = tableauDeCompetence[16];
                    this.competence2 = tableauDeCompetence[17];
                case "Paola Rinaldo":
                    this.competence1 = tableauDeCompetence[18];
                    this.competence2 = tableauDeCompetence[0];
                case "Raluca Tomescu":
                    this.competence1 = tableauDeCompetence[19];
                    this.competence2 = tableauDeCompetence[20];
                case "Roland Zuccali":
                    this.competence1 = tableauDeCompetence[21];
                    this.competence2 = tableauDeCompetence[8];
                case "Stephen Seagull":
                    this.competence1 = tableauDeCompetence[22];
                    this.competence2 = tableauDeCompetence[9];
                case "Terrence Archer":
                    this.competence1 = tableauDeCompetence[11];
                    this.competence2 = tableauDeCompetence[0];
                    
            }
        }
}

