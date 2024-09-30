package personnage;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
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
	}
}
