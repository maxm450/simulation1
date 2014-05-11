import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class JeuDeCartesTest {

	@Test
	public void testInitialiserJeuDeCarte() {
		final int germe = 10;
		
		final JeuDeCartes jeuRef = new JeuDeCartes();
		JeuDeCartes.initialiserJeuDeCarte(germe);
		Random generateur = jeuRef.getGenerateur();
		assertNotNull("Generateur doit etre non null",generateur);
		
	}

	@Test
	public void testBrasser() {

		final JeuDeCartes jeuRef = new JeuDeCartes();
	
		JeuDeCartes.brasser();
		boolean isAsc = true;
		boolean isDsc = true;
		final int [] tab = jeuRef.getPaquet();
		for(int i = 1; i < tab.length; i++){
			if (tab[i] < tab[0] ) {
				isAsc &= false;
			} else if (tab[i] > tab[0]) {
				isDsc &= false;
			}
		}
		
		assertFalse(isAsc);
		assertFalse(isDsc);
						
	}

	@Test
	public void testPiger() {
		 
		final JeuDeCartes jeuRef = new JeuDeCartes();
		int [] tab = jeuRef.getPaquet();
		int res;
		
		res = JeuDeCartes.piger();
		assertTrue(res >= 0 && res < JeuDeCartes.getNombreDeCarte());
		
		for( int i = 1; i < tab.length; i++){
			assertTrue(res != JeuDeCartes.piger());
		}
		
		
		
		
		
		
		
		
		
	}

	@Test
	public void testCarteValide() {
		fail("Not yet implemented");
	}

	@Test
	public void testCouleur() {
		fail("Not yet implemented");
	}

	@Test
	public void testValeur() {
		fail("Not yet implemented");
	}
	
	

}
