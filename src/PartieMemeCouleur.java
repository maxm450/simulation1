
public class PartieMemeCouleur implements Partie{

	/*
	 * (non-Javadoc)
	 * @see Partie#estGagant(int, int)
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
