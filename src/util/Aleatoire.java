package util;

import java.util.*;

/**
 * G�n�ration de nombres al�atoires.
 * 
 * @author Louise Laforest 
 * @version octobre 2008
 * 
 * �quipe Piccolo
 */
public class Aleatoire {

	
    private static int germe = 25; // valeur initiale qui peut �tre chang�e avec la m�thode initialiserLesDes.   
    private static Random generateur = new Random ( germe );
    
    /**
     * Initialise le processus al�atoire.  Un m�me germe va g�n�rer les m�mes d�s.
     * @param germe le germe pour intialiser le processus al�atoire.
     */
    public static void initialiserLesDes ( int germe ) {
        generateur = new Random ( germe );
    } // initialiserLesDes

    /**
     * G�n�re un nombre entier al�atoire entre 1 et nbfaces inclusivement.
     * @param nbFaces nombre de faces du d�.
     * @return un nombre entier al�atoire entre 1 et nbfaces inclusivement.
     */
    public static int lancerUnDe ( int nbFaces ) {
        return (int) Math.floor ( ( nbFaces ) * generateur.nextDouble () ) + 1;
    } // lancerUnDe
    
    /**
     * G�n�re un nombre entier al�atoire entre 1 et 6 inclusivement.
     * @return un nombre entier al�atoire entre 1 et 6 inclusivement.
     */
    public static int lancerUnDe6 () {
        return lancerUnDe ( 6 );
    } // lancerUnDe6
    
    public Random getGenerateur() {
    	return generateur;
    }
    
} // Aleatoire
