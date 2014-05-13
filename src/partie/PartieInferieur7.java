package partie;


/*
 * Équipe Piccolo
 */
public class PartieInferieur7 implements Partie{

	/*
	 * La partie est gagnante si le total des deux cartes est inférieur à 7.
	 * @param1 valeur carte1
	 * @param2 valeur carte2
	 */
	public boolean partieEstGagnante(int carte1, int carte2) {

		return carte1 + carte2 <= 7;
	}

	public int mise(){
		return 3;
	}


}
