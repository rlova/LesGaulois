package histoire;

import java.util.Random;

public class Druide {
	private int forcePotion = 1;
	private int effetPotionMax;
	private int effetPotionMin;

	public Druide(int effetPotionMax, int effetPotionMin) {
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
	}

	public void preparerPotion () {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax - effetPotionMin);
		if (forcePotion > 7) {
			System.out.println(" J'ai préparé une super potion de force " + forcePotion);
		} else {
			System.out.println(" Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public int getForcePotion() {
		return forcePotion;
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide(5,10);
		panoramix.preparerPotion();
	}
}