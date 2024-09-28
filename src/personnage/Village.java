package personnage;

public class Village {
	private String nom;
//	private Chef chef;
	private static Gaulois[] villageois;
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
	
	public static Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois];
	}
	
//	public void setChef(Chef chef) {
//		this.chef = chef;
//	}

	public String getNom() {
		return nom;
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		Gaulois gaulois = village.trouverHabitant(30);
	}
}
