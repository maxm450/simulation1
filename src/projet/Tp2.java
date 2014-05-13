package projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.Clavier;
import util.Partie;

/**
 * @author Équipe Piccolo
 * @version 1.0
 */
public class Tp2 {
	// Amélioration apportée.
	private static int montantJoueur = 100;
    private static boolean joueurGagne;    // si le joueur a gagné ou non la partie. 
    private static int montantGagne; // calcule : montant gagné selon le pari effectué.
    private static int mise; // saisie : montant mise par le joueur.

	public static void supprimerSauvegarde(){
		File f = new File("sauvegarde.txt");
		f.delete();
	}
	
	public static void sauvegarder(){
		
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("sauvegarde.txt"));
		    writer.write(String.valueOf(montantJoueur));
		    System.out.println("Partie sauvegardée...\n\nAu revoir!\n");
		}
		catch ( IOException e) {}
		
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
	
	/*
	 * Méthode qui détermine si une partie sauvegardée existe.
	 */
	public static boolean existePartieSauvegardee(){
		File f = new File("sauvegarde.txt");
		return (f.exists() && !f.isDirectory());
	}
	
	/*
	 * Méthode qui charge une partie sauvegardée.
	 */
	public static void restaurer(){
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("sauvegarde.txt")));
			String x = in.readLine();
			setMontantJoueur(Integer.parseInt(x));
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Méthode qui détermine si le joueur veut jouer une partie, enregistrer ou quitter.
	 */
    private static char lireOption () {
        
        char reponse;
        
        System.out.print ( "Voulez-vous jouer une partie (p), enregistrer (e) ou quitter (q) ?" );
        reponse = Clavier.lireChar ();
        Clavier.lireFinLigne ();  
        
        while ( reponse != 'p' && reponse != 'e' && reponse != 'q' && reponse != 'P' && reponse != 'E' && reponse != 'Q') {
            System.out.print ( "*** vous devez répondre par p, e ou q : " );
            reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
        }
        
        return reponse;
    }
    
    /*
     * Méthode qui détermine le pari choisi par le joueur.
     */
    private static int lireSortePari () {
        
        int reponse;
        
        System.out.println ( "Quel pari voulez-vous faire ?" );
        System.out.print ( " 1 : paire, 2 : séquence, 3 : même couleur, 4 : somme    choix : " );
        reponse = Clavier.lireInt (); 
        
        while ( reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4 ) {
            System.out.print ( "*** vous devez répondre par 1, 2, 3 ou 4 : " );
            reponse = Clavier.lireInt ();
        }
        
        return reponse;
    }
    
    /*
     * Amélioration apportée
     * 
     * Méthode lireMontantJoueur  
     * Maintenant le joueur commence soit avec 100 jetons ou bien il reprend une partie souvegardée.
     */

    /*
     * Méthode qui détermine le montant de la mise choisi par le joueur.
     */
    private static int lireMiseJoueur ( int max ) {
    
        int reponse;
        
        System.out.print ( "Entrez le montant de la mise ( maximum : " + max + " ) : " );
        reponse = Clavier.lireInt();
        
        while ( reponse < 0 || reponse > max ) {
            System.out.print ( "*** Le montant doit etre entre 0 et " + max + " : " );
            reponse = Clavier.lireInt();
        }
        
        return reponse;
    } 
    
    /*
     * Amélioration apportée
     * Méthode laSorte
     * cette méthode est remplacée par celle de la classe JeuDeCartes.
     */
    
    /*
     * Amélioration apportée
     * Méthode laCouleur
     * cette méthode est remplacée par celle de la classe JeuDeCartes.
     */
    
    /* 
     * Amélioration apportée
     * Méthode estUnePaire
     * cette méthode est maintenant située dans la classe PartiePaire.
     */

    /*
     * Amélioration apportée
     * Méthode sontMemeCouleur
     * cette méthode est maintenant située dans la classe PartieMemeCouleur.
	*/
    
    /* 
     * Amélioration apportée
     * Méthode estUneSequence
     * cette méthode est maintenant située dans la classe PartieSequence.
    */
    
    /*
     * Amélioration apportée
     * Méthode chaineCouleur, méthode chaineSorte et méthode afficherCarte
     * maintenant méthode gui permet d'afficher la valeur ainsi que la couleur d'une carte donnée.
     */
    
    /*
     * Méthode qui appelle l'interface graphique pour afficher les deux cartes.
     */
    private static void afficherLesDeuxCartes ( int carte1, int carte2 ) {
        GUI.afficherCartes(carte1, carte2);   
    } 

    /*
     * Méthode qui affiche le message de fin de partie.
     */
    private static void afficherFin () {
        
        System.out.println ( "Merci d'avoir joué avec moi !" );
        System.out.println ( "Vous quittez avec " + montantJoueur + " $ en poche." );
        
    }

    /*
     * Méthode qui initialise la partie avec la saisie du joueur.
     */
    private static void initialiserJeuDeCarte () {
    	
    	int reponse;
        System.out.print ( "Entrez un nombre entier positif pour initialiser le jeu : " );
        reponse = Clavier.lireInt ();
        while ( reponse < 0 ) {
        	System.out.print ( "*** Le nombre doit etre un entier positif : " );
        	reponse = Clavier.lireInt();
        }
        JeuDeCartes.initialiserJeuDeCarte ( reponse );
        System.out.println ();
        JeuDeCartes.brasser(); 
    } 
    
    /*
     * Amélioration apportée
     * Avant affichage dans le main
     * maintenant le main apelle cette méthode.
     */
    
    /*
     * Méthode qui détermine si le joueur à gagné sa mise ou non.
     */
    private static void joueurGagnant(boolean gagant, int montantGagne){
    	if ( gagant ) {
            System.out.println ( "Bravo ! Vous avez gagné " + montantGagne + 
            					" $, vous disposez maintenant de " + (montantJoueur + montantGagne) + "$ !\n\n" );
            montantJoueur = montantJoueur + montantGagne;
        } else {
            System.out.println ( "Désolé ! Vous avez perdu votre mise, vous disposez maintenant de " + montantJoueur + "$ !\n\n" );
        }
    	
    }
    
    /* 
     * Amélioration apportée
	 * Méthode pour mettre l'argent du joueur dans la variable de classe.
	 */
    public static void setMontantJoueur(int montant){
    	montantJoueur = montant;
    }
    
    /* 
     * Amélioration apportée
	 * Méthode pour afficher la somme des cartes.
	 */
    private static void afficherSommeCarte(int carte1, int carte2){
    	System.out.println("Voici les cartes: " + JeuDeCartes.valeur(carte1) + " + " + JeuDeCartes.valeur(carte2) + " = " 
                + (JeuDeCartes.valeur(carte1) + JeuDeCartes.valeur(carte2)));
    }

    /* 
     * Amélioration apportée
     * Ajout de la varibale partie.
     * Ajout de la méthode de vérification pour chaque type de partie.
     * Ajout de la fonction mise. 
    */
    private static void pariFait(int pari, int carte1, int carte2){
        Partie partie;

        if ( pari == 1 ) { // est-ce une paire ?
                partie = new PartiePaire();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) - 1, JeuDeCartes.valeur(carte2) - 1);
                montantGagne = partie.mise() * mise;
                
            } else if ( pari == 2 ) { // est-ce une séquence ?
                partie = new PartieSequence();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) -1, JeuDeCartes.valeur(carte2) -1);
                montantGagne = partie.mise() * mise;
                
            } else if ( pari == 3) { // deux de la même couleur ?
                partie = new PartieMemeCouleur();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.couleur(carte1), JeuDeCartes.couleur(carte2) );
                montantGagne = partie.mise() * mise;
                
            } else { // somme égale ou inférieure à 7. 
                partie = new PartieInferieur7();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1), JeuDeCartes.valeur(carte2));
                montantGagne = partie.mise() * mise;
            }

    }
    
    /*
     * Amélioration apportée
	 * Le jeu affiche le montant du joueur au départ.
	 */
    private static void afficherMontantJoueur(){
    	System.out.println ( "Vous disposez maintenant de " + montantJoueur + " $" );
    }

    public static void main ( String [] arg ) {
                
        char    reponse;        // saisie : pour la reponse o ou n.
        int     pari;           // saisie : pour la sorte de pari 1, 2 ou 3.
        int     carte1;         // la première carte pigée.
        int     carte2;         // la deuxième carte pigée.
        
        // Initialiser le procédé aléatoire.
        initialiserJeuDeCarte();
        
        if (existePartieSauvegardee()){
        	System.out.print("Désirez-vous reprendre la partie enregistrée ? (o/n) : ");
        	reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
            System.out.println();
            
            while ( reponse != 'o' && reponse != 'n' && reponse != 'O' && reponse != 'N' ) {
                System.out.print ( "*** vous devez répondre par o ou n : " );
                reponse = Clavier.lireChar ();
                Clavier.lireFinLigne ();
            }
            
            if ( reponse == 'o' || reponse == 'O' )
            	restaurer();
            else
            	supprimerSauvegarde();
        } 
        
        // Boucle pour les parties
        reponse = 'p';
        System.out.println ();
        
        while ( reponse == 'p' || reponse == 'P' ) { 
        	/* 
        	 * Amélioration apportée
        	 * Le jeu affiche le montant du joueur au départ.
        	 */
        	afficherMontantJoueur();
            // Saisie et validation du type de pari.
            
            pari = lireSortePari ();
            System.out.println ();
            
            // Saisie et validation du montant de la mise.
            
            mise = lireMiseJoueur ( montantJoueur );
            System.out.println ();
            
            montantJoueur = montantJoueur - mise;
            
            // Faire piger deux cartes par l'ordinateur.
            carte1 = JeuDeCartes.piger();
            carte2 = JeuDeCartes.piger();
            
            afficherLesDeuxCartes ( carte1, carte2 );
            afficherSommeCarte(carte1, carte2);
            
           
            // Déterminer si le joueur a gagné ou perdu.
            joueurGagne = false;
            
            /* 
             * Amélioration apportée
             * Ajout de la méthode pariFait.
             */
            pariFait(pari, carte1, carte2);

            // Affiche si le joueur a gagné ou perdu ainsi que son gain s'il y a lieu.
            joueurGagnant(joueurGagne, montantGagne);
            
            // Détermine si le montant que le joueur possède lui permet de poursuivre sa partie.
            if ( montantJoueur > 0 ) {
                reponse = lireOption();
            } else {
                System.out.println ( "Vous n'avez plus d'argent, vous ne pouvez continuer." );
                reponse = 'q';
            }

        } // Boucle de jeu.
        if ( reponse == 'e' || reponse == 'E' ){
        	sauvegarder();
        }
        else if ( reponse == 'q' || reponse == 'Q' ) {
        	afficherFin();
        	supprimerSauvegarde();
        }
        System.exit(-1);
        
    } 
    
}
