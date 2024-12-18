package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void boirePotion (int forcePotion) {
		this.effetPotion = forcePotion ;
		System.out.println(" Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. ");
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; newTrophees != null && i < newTrophees.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees>0) {
			parler("Je donne au musee tous mes trophees");
			for (int i=0; i<nbTrophees; i++) {
				Equipement equipement = trophees[i];
				musee.donnerTrophees(this, equipement);
			}
			trophees = new Equipement[100];
			nbTrophees = 0;
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Asterix",8);
		System.out.println(asterix);
		asterix.parler("Bonjour");
		asterix.boirePotion(5);
		asterix.faireUneDonnation(null);
	}

}
