package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	private String texte;
	
	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterEquipement(Equipement equipements2) {
		equipements[nbEquipement] = equipements2;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s'√©quipe avec un bouclier");
	}
	
	private void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + getNom() + " est d√©j√† prot√©g√© !");
				break;
			
			case 1:
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + getNom() + " poss√®de d√©j√† un casque !");
				} else {
					ajouterEquipement(equipement);
				}
				break;
			
			case 0:
				ajouterEquipement(equipement);
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
		// prÈcondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = CalculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		// if (force > 0) {
		// parler("AÔe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("AÔe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuÈe
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du
coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace ‡ mon Èquipement sa
force est diminuÈ de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null &&
equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'Èquipement de " + nom.toString() + "
s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
					continue;
				} else {
					equipementEjecte[nbEquipementEjecte] =
equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}	
			
//	public void recevoirCoup(int forceCoup) {
////		Pr√©-condition
//		assert force > 0 : "La force d'un Romain est positive";
////		Variable locale post-condition
//		int forcePost = force;
//		force -= forceCoup;
////		Post-condition
//		assert force < forcePost : "La force d'un Romain a diminu√©";
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
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
