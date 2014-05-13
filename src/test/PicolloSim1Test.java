package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import projet.PicolloSim1;



public class PicolloSim1Test {
	
	@BeforeClass
	public static void setup() {
	}
	
	@AfterClass
	public static void tearDown() {
		
	}

	@Test
	public void testSupprimerSauvegarde() {		
		PicolloSim1.supprimerSauvegarde();		
	}

	@Test
	public void testSauvegarder() {
		final Integer expectedValue = Integer.valueOf(200);
		
		PicolloSim1.setMontantJoueur(200);
		PicolloSim1.sauvegarder();
		String readValue = readSavedFile();
		assertEquals(expectedValue.toString(), readValue);
		
	}

	@Test
	public void testExistePartieSauvegardee() {
				
		File p = new File("sauvegarde.txt");
		boolean b = p.exists();
     	boolean z =	PicolloSim1.existePartieSauvegardee();  	
     	assertTrue( b == z );
     	
     	p.delete();
     	z = PicolloSim1.existePartieSauvegardee(); 
     	assertFalse(z);
     
	}

	@Test
	public void testRestaurer() {
	}

	@Test
	public void testLireOption() {
	}
	

	@Test
	public void testLireSortePari() {
	}

	@Test
	public void testLireMiseJoueur() {
	}

	@Test
	public void testAfficherLesDeuxCartes() {
	}

	@Test
	public void testAfficherFin() {
	}

	@Test
	public void testInitialiserJeuDeCarte() {
	}

	@Test
	public void testJoueurGagnant() {
	}

	@Test
	public void testSetMontantJoueur() {
	}

	@Test
	public void testPariFait() {
	}
	
	   
	    

	    /**
	     * Test of sauvegarder method, of class Tp2.
	      */
	    private String readSavedFile() {
	        
	        BufferedReader reader = null;
	        StringBuilder result = new StringBuilder();
	        String line ;
	        try {
	            
	            reader = new BufferedReader( new FileReader("sauvegarde.txt"));
	            line  = reader.readLine();
	            result.append(line);
	            while (line != null) {
	            	line = reader.readLine();
	            	if (line!=null)
	            	   result.append(line);
	            }
	        } catch (FileNotFoundException ex) {
	        	
	        } catch (IOException ex) {
	        } finally {
	            
	                if (reader != null) {
	                    try {
	                       reader.close();
	                    } catch (Exception exc) {}
	                }
	        }
	        return result.toString();
		
			
	    }

}
