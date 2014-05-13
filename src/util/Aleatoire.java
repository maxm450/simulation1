package util;

import java.util.*;

/**
 * Génération de nombres aléatoires.
 * 
 * @author Louise Laforest 
 * @version octobre 2008
 * 
 * Équipe Piccolo
 */
public class Aleatoire {

	
    private static int germe = 25; // valeur initiale qui peut être changée avec la méthode initialiserLesDes.   
    private static Random generateur = new Random ( germe );
    
    /**
     * Initialise le processus aléatoire.  Un même germe va générer les mêmes dés.
     * @param germe le germe pour intialiser le processus aléatoire.
     */
    public static void initialiserLesDes ( int germe ) {
        generateur = new Random ( germe );
    } // initialiserLesDes

    /**
     * Génère un nombre entier aléatoire entre 1 et nbfaces inclusivement.
     * @param nbFaces nombre de faces du dé.
     * @return un nombre entier aléatoire entre 1 et nbfaces inclusivement.
     */
    public static int lancerUnDe ( int nbFaces ) {
        return (int) Math.floor ( ( nbFaces ) * generateur.nextDouble () ) + 1;
    } // lancerUnDe
    
    /**
     * Génère un nombre entier aléatoire entre 1 et 6 inclusivement.
     * @return un nombre entier aléatoire entre 1 et 6 inclusivement.
     */
    public static int lancerUnDe6 () {
        return lancerUnDe ( 6 );
    } // lancerUnDe6
    
    public Random getGenerateur() {
    	return generateur;
    }
    
} // Aleatoire
