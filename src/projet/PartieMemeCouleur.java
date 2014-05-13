package projet;

import util.Partie;

/*
 * �quipe Piccolo
 */
public class PartieMemeCouleur implements Partie{

	/*
	 * La partie est gagnante si les deux cartes sont de la m�me couleur.
	 * @param1 couleur carte1
	 * @param2 couleur carte2
	 */
	public boolean partieEstGagnante(int carte1, int carte2) {

		return carte1 == carte2;
	}

	public int mise(){
		return 2;
	}
}
