package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		if (numeroVillageois>=0 && numeroVillageois<nbVillageois) {
			return villageois[numeroVillageois];
		}
		return null;
	}
	
	public void afficherVillageois(Chef chef, Gaulois Villageois) {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i=0; i<nbVillageois; i++) {
			System.out.println(" - " + villageois[i].getNom());
		}
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
		Chef abraracourix = new Chef("Abraracourix",6,village);
		village.setChef(abraracourix);
		Gaulois asterix = new Gaulois("Asterix",6);
		village.ajouterHabitant(asterix);
		Gaulois gaulois = village.trouverHabitant(0);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(abraracourix, obelix);
	}
}

// Je n'arrivais pas sortir l'habitant numéro 0 j'ai donc essayé de le mettre entre les deux intervalles (cad que le num doit être entre 0 et le nb d'habitant)
// Cela renvoie donc un resultat null, c'est pourquoi j'ai précisé que le numéro peut être égale à 0 et on obtient l'habtant'