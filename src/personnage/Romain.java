package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
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
		System.out.println("Le soldat " + getNom() + " s'équipe avec un bouclier");
	}
	
	private void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat " + getNom() + " est déjà protégé !");
				break;
			
			case 1:
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + getNom() + " possède déjà un casque !");
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
	
	public void recevoirCoup(int forceCoup) {
//		Pré-condition
		assert force > 0 : "La force d'un Romain est positive";
//		Variable locale post-condition
		int forcePost = force;
		force -= forceCoup;
//		Post-condition
		assert force < forcePost : "La force d'un Romain a diminué";
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abondonne...");
		}
	}
	
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
