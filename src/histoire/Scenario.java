package histoire;

import personnage.Gaulois;
import personnage.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide(5,10);
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minus = new Romain("Minus",6);
		Gaulois obelix = new Gaulois("Obelix",25);
		System.out.println(" Le druide Panoramix : << Bonjour, je suis le druide Panoramix et ma potion peut aller d'une force " + panoramix.geteffetPotionMin() + " à " + + " >>");
		System.out.println(" Le druide Panoramix : << Je vaus aller préparer une petite potion... >>");
		System.out.print(" Le druide Panoramix : ");
		panoramix.preparerPotion();
		System.out.println(" Le druide Panoramix : << ");
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
