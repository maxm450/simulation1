import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;


public class AleatoireTest {

	@Test
	public void testInitialiserLesDes() {
		final int germe = 2;
		final Aleatoire aleatoireRef = new Aleatoire();
		Aleatoire.initialiserLesDes(germe);
		Random generateurAleatoire = aleatoireRef.getGenerateur();
		assertNotNull(generateurAleatoire);
	}

	@Test
	public void testLancerUnDe() {
		final int x = 3;
		int z;
		
		for (int i= 0; i < 100; i++) {
		   Aleatoire.lancerUnDe(x);
		   z = Aleatoire.lancerUnDe(x);
		   assertTrue( z > 0 );
		   assertFalse( z < 1 );
		   assertTrue( z <= x );
		}
		
	}

	@Test
	public void testLancerUnDe6() {
	// return lancerUnDe ( 6 );
		int z;
		z = Aleatoire.lancerUnDe6();
		
		for (int i= 0; i < 100; i++) {
		   assertTrue ( z > 0 && z <= 6  );
		   assertFalse( z < 1 && z > 6);
		}
		
	}

}
