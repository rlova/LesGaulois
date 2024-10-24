package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMax;
	private int effetPotionMin;
	private Random valeur = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
		parler(" Bonjour, je suis le druide " + nom + " et ma potion est d'une force "+ effetPotionMin + " à " + effetPotionMax);
	}
	
	public String getNom() {
		return nom;
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obelix")) {
			System.out.println(" Non, Obélix !... Tu n'auras pas de potion magique!");
		}
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion () {
		forcePotion = this.valeur.nextInt(effetPotionMin,effetPotionMax);
		return forcePotion;
	}

	public void faireParler() {
		int force = forcePotion;
		if (force > 7) {
			parler(" J'ai préparé une super potion de force " + force);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + force);
		}
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEffetPotionMax() {
		return effetPotionMax;
	}

	public int getEffetPotionMin() {
		return effetPotionMin;
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		for (int i=0; i<5; i++) {
			panoramix.faireParler();
		}
	}
}