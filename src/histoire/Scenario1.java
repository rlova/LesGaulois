package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario1 {
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.faireParler();
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minus = new Romain("Minus",6);
		Gaulois obelix = new Gaulois("Obelix",25);
		panoramix.prendreParole();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		System.out.print("Le gaulois Asterix : <<");
		asterix.boirePotion(6);		
//		asterix.parler("Bonjour");		
//		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
//		minus.parler("J'abandonne...");	
	}
}