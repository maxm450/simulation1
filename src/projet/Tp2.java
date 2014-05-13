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
 * @author �quipe Piccolo
 * @version 1.0
 */
public class Tp2 {
	// Am�lioration apport�e.
	private static int montantJoueur = 100;
    private static boolean joueurGagne;    // si le joueur a gagn� ou non la partie. 
    private static int montantGagne; // calcule : montant gagn� selon le pari effectu�.
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
		    System.out.println("Partie sauvegard�e...\n\nAu revoir!\n");
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
	 * M�thode qui d�termine si une partie sauvegard�e existe.
	 */
	public static boolean existePartieSauvegardee(){
		File f = new File("sauvegarde.txt");
		return (f.exists() && !f.isDirectory());
	}
	
	/*
	 * M�thode qui charge une partie sauvegard�e.
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
	 * M�thode qui d�termine si le joueur veut jouer une partie, enregistrer ou quitter.
	 */
    private static char lireOption () {
        
        char reponse;
        
        System.out.print ( "Voulez-vous jouer une partie (p), enregistrer (e) ou quitter (q) ?" );
        reponse = Clavier.lireChar ();
        Clavier.lireFinLigne ();  
        
        while ( reponse != 'p' && reponse != 'e' && reponse != 'q' && reponse != 'P' && reponse != 'E' && reponse != 'Q') {
            System.out.print ( "*** vous devez r�pondre par p, e ou q : " );
            reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
        }
        
        return reponse;
    }
    
    /*
     * M�thode qui d�termine le pari choisi par le joueur.
     */
    private static int lireSortePari () {
        
        int reponse;
        
        System.out.println ( "Quel pari voulez-vous faire ?" );
        System.out.print ( " 1 : paire, 2 : s�quence, 3 : m�me couleur, 4 : somme    choix : " );
        reponse = Clavier.lireInt (); 
        
        while ( reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4 ) {
            System.out.print ( "*** vous devez r�pondre par 1, 2, 3 ou 4 : " );
            reponse = Clavier.lireInt ();
        }
        
        return reponse;
    }
    
    /*
     * Am�lioration apport�e
     * 
     * M�thode lireMontantJoueur  
     * Maintenant le joueur commence soit avec 100 jetons ou bien il reprend une partie souvegard�e.
     */

    /*
     * M�thode qui d�termine le montant de la mise choisi par le joueur.
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
     * Am�lioration apport�e
     * M�thode laSorte
     * cette m�thode est remplac�e par celle de la classe JeuDeCartes.
     */
    
    /*
     * Am�lioration apport�e
     * M�thode laCouleur
     * cette m�thode est remplac�e par celle de la classe JeuDeCartes.
     */
    
    /* 
     * Am�lioration apport�e
     * M�thode estUnePaire
     * cette m�thode est maintenant situ�e dans la classe PartiePaire.
     */

    /*
     * Am�lioration apport�e
     * M�thode sontMemeCouleur
     * cette m�thode est maintenant situ�e dans la classe PartieMemeCouleur.
	*/
    
    /* 
     * Am�lioration apport�e
     * M�thode estUneSequence
     * cette m�thode est maintenant situ�e dans la classe PartieSequence.
    */
    
    /*
     * Am�lioration apport�e
     * M�thode chaineCouleur, m�thode chaineSorte et m�thode afficherCarte
     * maintenant m�thode gui permet d'afficher la valeur ainsi que la couleur d'une carte donn�e.
     */
    
    /*
     * M�thode qui appelle l'interface graphique pour afficher les deux cartes.
     */
    private static void afficherLesDeuxCartes ( int carte1, int carte2 ) {
        GUI.afficherCartes(carte1, carte2);   
    } 

    /*
     * M�thode qui affiche le message de fin de partie.
     */
    private static void afficherFin () {
        
        System.out.println ( "Merci d'avoir jou� avec moi !" );
        System.out.println ( "Vous quittez avec " + montantJoueur + " $ en poche." );
        
    }

    /*
     * M�thode qui initialise la partie avec la saisie du joueur.
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
     * Am�lioration apport�e
     * Avant affichage dans le main
     * maintenant le main apelle cette m�thode.
     */
    
    /*
     * M�thode qui d�termine si le joueur � gagn� sa mise ou non.
     */
    private static void joueurGagnant(boolean gagant, int montantGagne){
    	if ( gagant ) {
            System.out.println ( "Bravo ! Vous avez gagn� " + montantGagne + 
            					" $, vous disposez maintenant de " + (montantJoueur + montantGagne) + "$ !\n\n" );
            montantJoueur = montantJoueur + montantGagne;
        } else {
            System.out.println ( "D�sol� ! Vous avez perdu votre mise, vous disposez maintenant de " + montantJoueur + "$ !\n\n" );
        }
    	
    }
    
    /* 
     * Am�lioration apport�e
	 * M�thode pour mettre l'argent du joueur dans la variable de classe.
	 */
    public static void setMontantJoueur(int montant){
    	montantJoueur = montant;
    }
    
    /* 
     * Am�lioration apport�e
	 * M�thode pour afficher la somme des cartes.
	 */
    private static void afficherSommeCarte(int carte1, int carte2){
    	System.out.println("Voici les cartes: " + JeuDeCartes.valeur(carte1) + " + " + JeuDeCartes.valeur(carte2) + " = " 
                + (JeuDeCartes.valeur(carte1) + JeuDeCartes.valeur(carte2)));
    }

    /* 
     * Am�lioration apport�e
     * Ajout de la varibale partie.
     * Ajout de la m�thode de v�rification pour chaque type de partie.
     * Ajout de la fonction mise. 
    */
    private static void pariFait(int pari, int carte1, int carte2){
        Partie partie;

        if ( pari == 1 ) { // est-ce une paire ?
                partie = new PartiePaire();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) - 1, JeuDeCartes.valeur(carte2) - 1);
                montantGagne = partie.mise() * mise;
                
            } else if ( pari == 2 ) { // est-ce une s�quence ?
                partie = new PartieSequence();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) -1, JeuDeCartes.valeur(carte2) -1);
                montantGagne = partie.mise() * mise;
                
            } else if ( pari == 3) { // deux de la m�me couleur ?
                partie = new PartieMemeCouleur();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.couleur(carte1), JeuDeCartes.couleur(carte2) );
                montantGagne = partie.mise() * mise;
                
            } else { // somme �gale ou inf�rieure � 7. 
                partie = new PartieInferieur7();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1), JeuDeCartes.valeur(carte2));
                montantGagne = partie.mise() * mise;
            }

    }
    
    /*
     * Am�lioration apport�e
	 * Le jeu affiche le montant du joueur au d�part.
	 */
    private static void afficherMontantJoueur(){
    	System.out.println ( "Vous disposez maintenant de " + montantJoueur + " $" );
    }

    public static void main ( String [] arg ) {
                
        char    reponse;        // saisie : pour la reponse o ou n.
        int     pari;           // saisie : pour la sorte de pari 1, 2 ou 3.
        int     carte1;         // la premi�re carte pig�e.
        int     carte2;         // la deuxi�me carte pig�e.
        
        // Initialiser le proc�d� al�atoire.
        initialiserJeuDeCarte();
        
        if (existePartieSauvegardee()){
        	System.out.print("D�sirez-vous reprendre la partie enregistr�e ? (o/n) : ");
        	reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
            System.out.println();
            
            while ( reponse != 'o' && reponse != 'n' && reponse != 'O' && reponse != 'N' ) {
                System.out.print ( "*** vous devez r�pondre par o ou n : " );
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
        	 * Am�lioration apport�e
        	 * Le jeu affiche le montant du joueur au d�part.
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
            
           
            // D�terminer si le joueur a gagn� ou perdu.
            joueurGagne = false;
            
            /* 
             * Am�lioration apport�e
             * Ajout de la m�thode pariFait.
             */
            pariFait(pari, carte1, carte2);

            // Affiche si le joueur a gagn� ou perdu ainsi que son gain s'il y a lieu.
            joueurGagnant(joueurGagne, montantGagne);
            
            // D�termine si le montant que le joueur poss�de lui permet de poursuivre sa partie.
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
