package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee<trophees.length) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee++;
		}
	}
}
