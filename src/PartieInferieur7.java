
public class PartieInferieur7 implements Partie{

	@Override
	/*
	 * (non-Javadoc)
	 * @see Partie#estGagant(int, int)
	 * @param1 valeur carte1
	 * @param2 valeur carte2
	 */
	public boolean estGagant(int carte1, int carte2) {
		// TODO Auto-generated method stub
		return carte1 + carte2 <= 7;
	}

	public int mise(){
		return 3;
	}


}
