package histoire;

import java.util.Random;

public class Druide {
	private int forcePotion = 1;
	private int effetPotionMax;
	
	public Druide(int effetPotionMax) {
		this.effetPotionMax = effetPotionMax;
	}

	public void preparerPotion () {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax);
		if (forcePotion > 7) {
			System.out.println(" J'ai préparé une super potion de force " + forcePotion);
		} else {
			System.out.println(" Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide(10);
		panoramix.preparerPotion();
	}
}