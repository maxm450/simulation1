package projet;

import util.Partie;

/*
 * Équipe Piccolo
 */
public class PartieSequence implements Partie{

	/*
	 * La partie est gagnante si les deux cartes forment une séquence.
	 * @param1 valeur carte1
	 * @param2 valeur carte2
	 */
	public boolean partieEstGagnante(int carte1, int carte2) {
		return 	carte1 == carte2 + 1 || 
				carte1 == carte2 - 1 ||
				carte1 == 12 && carte2 == 0 ||    // as et roi
				carte2 == 12 && carte1 == 0;
	}


	public int mise() {
		return 3;
	}
}
