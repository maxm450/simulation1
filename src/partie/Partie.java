package partie;

/*
 * Équipe Piccolo
 */
public interface Partie {
	public  abstract boolean partieEstGagnante(int carte1, int carte2);

	public abstract int mise();
}
