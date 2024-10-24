package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario1 {
	public static void main(String[] args) {
		Druide panoramix = new Druide(5,10);
		System.out.println("Le druide Panoramix : << Bonjour, je suis le druide Panoramix et ma potion peut aller d'une force " + panoramix.getEffetPotionMin() + " à " + panoramix.getEffetPotionMax() + " >>");
		System.out.println("Le druide Panoramix : << Je vais aller préparer une petite potion... >>");
		System.out.print("Le druide Panoramix : << ");
		panoramix.preparerPotion();
		System.out.print("Le druide Panoramix : <<");
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minus = new Romain("Minus",6);
		Gaulois obelix = new Gaulois("Obelix",25);
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		System.out.print("Le gaulois Asterix : <<");
		asterix.boirePotion(6);		
		asterix.parler("Bonjour");		
		minus.parler("UN GAU... UN GAUGAU...");		
		minus.parler("J'abandonne...");	
	}
}