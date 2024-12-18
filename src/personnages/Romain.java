package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	public static final String SOLDAT = "Le soldat ";
//	private boolean vainqueur = true;
	
	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("La force d'un Romain est toujours positive"+force);
		}
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
		
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public void ajouterEquipement(Equipement equipements2) {
		equipements[nbEquipement] = equipements2;
		nbEquipement++;
		System.out.println(SOLDAT + getNom() + " s'equipe avec un " + equipements2);
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println(SOLDAT + getNom() + " est deja protege !");
				break;
			case 1:
				if (equipements[0] == equipement) {
					System.out.println(SOLDAT + getNom() + " possede deja un " + equipement);
				} else {
					ajouterEquipement(equipement);
				}
				break;
			default:
				ajouterEquipement(equipement);
				break;
		}
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
//		Pre-condition
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force==0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
//			vainqueur = false;
		}
//		// post condition la force a diminuee
		assert force <= oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace a mon equipement sa force diminue de "; 
			for (int i=0; i< nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) {
			return 0;
		}
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;					
			}
		}
		return equipementEjecte;
	}	
			
//	public void recevoirCoup(int forceCoup) {
////		Pré-condition
//		assert force > 0 : "La force d'un Romain est positive";
////		Variable locale post-condition
//		int forcePost = force;
//		force -= forceCoup;
////		Post-condition
//		assert force < forcePost : "La force d'un Romain a diminué";
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abondonne...");
//		}
//	}
	
	public static void main(String[] args) {
		Romain minus = new Romain ("Minus",6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
//		System.out.println(Equipement.CASQUE);
//		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
}
