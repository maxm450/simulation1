
public class PartieMemeCouleur implements Partie{

	@Override
	/*
	 * (non-Javadoc)
	 * @see Partie#estGagant(int, int)
	 * @param1 couleur carte1
	 * @param2 couleur carte2
	 */
	public boolean estGagant(int carte1, int carte2) {
		// TODO Auto-generated method stub
		return carte1 == carte2;
	}

}
