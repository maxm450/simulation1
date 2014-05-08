
public class PartieSequence implements Partie{

	@Override
	/*
	 * (non-Javadoc)
	 * @see Partie#estGagant(int, int)
	 * @param1 valeur carte1
	 * @param2 valeur carte2
	 */
	public boolean estGagant(int carte1, int carte2) {
		return 	carte1 == carte2 + 1 || 
				carte1 == carte2 - 1 ||
				carte1 == 12 && carte2 == 0 ||    // as et roi
				carte2 == 12 && carte1 == 0;
	}


	public int mise() {
		return 3;
	}
}
