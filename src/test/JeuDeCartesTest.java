package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import projet.JeuDeCartes;


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
		final int [] tab = JeuDeCartes.getPaquet();
        JeuDeCartes.setNombrePige(0);
		JeuDeCartes.brasser();
		for(int i = 1; i < tab.length; i++){
			if (tab[i] < tab[0] ) {
				isAsc &= false;
			} else if (tab[i] > tab[0]) {
				isDsc &= false;
			}
		}
		
		assertFalse(isAsc ^ isDsc);
						
	}

	@Test
	public void testPiger() {
		 
		final JeuDeCartes jeuRef = new JeuDeCartes();
		int [] tab = JeuDeCartes.getPaquet();
		int res;
		
		res = JeuDeCartes.piger();
		assertTrue(res >= 0 && res < JeuDeCartes.getNombreDeCarte());
		
		for( int i = 1; i < tab.length; i++){
			assertTrue(res != JeuDeCartes.piger());
		}	
		
	}

	@Test
	public void testCarteValide() {
		
		for (int carte = 0; carte < JeuDeCartes.getNombreDeCarte() + 20; carte++) {
			if (carte < 0 || carte > JeuDeCartes.getNombreDeCarte()) {
				assertFalse(JeuDeCartes.carteValide(carte));
			} else if (carte >= 0 && carte < JeuDeCartes.getNombreDeCarte()) {
				assertTrue(JeuDeCartes.carteValide(carte));
			}
		}
			
	}

	@Test
	public void testCouleur() {

		for (int carte = 0; carte < JeuDeCartes.getNombreDeCarte() + 20; carte++) {
			if (carte < 0 || carte > JeuDeCartes.getNombreDeCarte()) { // Carte invalide
				assertTrue(JeuDeCartes.couleur(carte) == -1);
			} else if (carte >= 0 && carte < JeuDeCartes.getNombreDeCarte()) { // carte valide
				assertTrue(JeuDeCartes.couleur(carte) >=0 && JeuDeCartes.couleur(carte) <= 3 );
			}
		}
		
	}

	@Test
	public void testValeur() {
		
		for (int carte = 0; carte < JeuDeCartes.getNombreDeCarte() + 20; carte++) {
			if (carte < 0 || carte > JeuDeCartes.getNombreDeCarte()) { // Carte invalide
				assertTrue(JeuDeCartes.valeur(carte) == -1);
			} else if (carte >= 0 && carte < JeuDeCartes.getNombreDeCarte()) { // carte valide
				assertTrue(JeuDeCartes.valeur(carte) >= 0 && JeuDeCartes.valeur(carte) <= 13 );
			}
		}
		
	}
	
	

}
