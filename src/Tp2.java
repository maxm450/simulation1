import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author Piccolo
 * @version 1.0
 */
public class Tp2 {
	
	private static int montantJoueur = 100;

	public static void supprimerSauvegarde(){
		File f = new File("sauvegarde.txt");
		if(f.delete())
			System.out.println("Suppression de la sauvegarde...\n");
		else
			System.out.println("Le fichier est en cours d'utilisation et ne peut être supprimé...");
	}
	
	public static void sauvegarder(){
		
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("sauvegarde.txt"));
		    writer.write(String.valueOf(montantJoueur));
		    System.out.println("Partie sauvegardee...\n\nAu revoir!\n");

		}
		catch ( IOException e)
		{
		}
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
	
	public static boolean existePartieSauvegardee(){
		File f = new File("sauvegarde.txt");
		return (f.exists() && !f.isDirectory());
	}
	
	public static void restaurer(){
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("sauvegarde.txt")));
			String x = in.readLine();
			setMontantJoueur(Integer.parseInt(x));
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static char lireOption () {
        
        char reponse;
        
        System.out.print ( "Voulez-vous jouer une partie (p), enregistrer (e) ou quitter (q) ?" );
        reponse = Clavier.lireChar ();
        Clavier.lireFinLigne ();  
        
        while ( reponse != 'p' && reponse != 'e' && reponse != 'q' ) {
            System.out.print ( "*** vous devez repondre par p, e ou q : " );
            reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
        }
        
        return reponse;
    } // lireOption
    
    public static int lireSortePari () {
        
        int reponse;
        
        System.out.println ( "Quel pari voulez-vous faire ?" );
        System.out.print ( " 1 : paire, 2 : sequence, 3 : meme couleur, 4 : somme    choix : " );
        reponse = Clavier.lireInt (); 
        
        while ( reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4 ) {
            System.out.print ( "*** vous devez repondre par 1, 2, 3 ou 4 : " );
            reponse = Clavier.lireInt ();
        }
        
        return reponse;
    } // lireSortePari
    
    /*public static int lireMontantJoueur () {
    
        int reponse;
        
        System.out.print ( "Entrez le montant dont vous disposez : " );
        reponse = Clavier.lireInt();
        
        while ( reponse <= 0 ) {
            System.out.print ( "*** Le montant doit etre superieur a 0 : " );
            reponse = Clavier.lireInt();
        }
        
        return reponse;
    } // lireMontantJoueur*/

    public static int lireMiseJoueur ( int max ) {
    
        int reponse;
        
        System.out.print ( "Entrez le montant de la mise ( maximum : " + max + " ) : " );
        reponse = Clavier.lireInt();
        
        while ( reponse < 0 || reponse > max ) {
            System.out.print ( "*** Le montant doit etre entre 0 et " + max + " : " );
            reponse = Clavier.lireInt();
        }
        
        return reponse;
    } // lireMiseJoueur
    
    public static int laSorte ( int carte ) {
        
    /* antï¿½cï¿½dent : 0 <= carte <= 51
     * consï¿½quent : retourne la valeur de la carte (0, 1, ... 12)
     *              0 : as, 1 : 2, 2 : 3, ..., 9 : 10, 10 : valet, 11 : dame, 12 : roi
     */
    
        return carte % 13;
        
    } // laSorte
    
    public static int laCouleur ( int carte ) {
        
    /* antï¿½cï¿½dent : 0 <= carte <= 51
     * consï¿½quent : retourne la couleur de la carte (0, 1, 2, 3)
     *              0 : coeur, 1 : carreau, 2 : trefle, 3 : pique
     */
    
        return carte / 13;
        
    } // laCouleur
    
    /* Amélioration apportée
     * cette fonction est maintenant située dans la classe PartiePair
     * public static boolean estUnePaire ( int carte1, int carte2 ) { 

     * antï¿½cï¿½dent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consï¿½quent : retourne vrai si carte1 et carte 2 constituent une paire,
     *              faux sinon
     *
    
     *return laSorte ( carte1 ) == laSorte ( carte2 );
      
     * } // estUnePaire
     */

    /*
     * Amélioration apportée
     * cette fonction est maintenant situ/ dans la classe PartieMemeCouleur
     * 
     * 
     *public static boolean sontMemeCouleur ( int carte1, int carte2 ) { 

     * antï¿½cï¿½dent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consï¿½quent : retourne vrai si carte1 et carte 2 sont de la mï¿½me
     *              couleur.  Les 4 couleurs possibles sont : coeur, carreau,
     *              trï¿½fle et pique.
     *
        
     *return laCouleur ( carte1 ) == laCouleur ( carte2 );
        
     *} // sontMemeCouleur
	*/
    
    /* Amélioration apportée
     * cette fonction est maintenant situ/ dans la classe PartieSequence
     * public static boolean estUneSequence ( int carte1, int carte2 ) { 
	 *
     * antï¿½cï¿½dent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
     * consï¿½quent : retourne vrai si carte1 et carte 2 forment une sï¿½quence,
     *              peu importe leur couleur, faux sinon.  Une sï¿½quence de
     *              deux cartes sont deux cartes de valeur consï¿½cutive.  L'as
     *              et le 2 sont considï¿½rï¿½es comme consï¿½cutives ainsi que l'as
     *              et le roi.
     *
    
        int sorte1 = laSorte ( carte1 );
        int sorte2 = laSorte ( carte2 );
    
        return sorte1 == sorte2 + 1 || 
               sorte1 == sorte2 - 1 ||
               sorte1 == 12 && sorte2 == 0 ||    // as et roi
               sorte2 == 12 && sorte1 == 0;
               
    	} // estUneSequence
    */
    
    /*
    public static boolean sommeEgaleOuInferieureASept ( int carte1, int carte2 ) { 

        * antecedent : 0 <= carte1 <= 51 et 0 <= carte2 <= 51
         * consequent : retourne vrai si la somme de carte1 et carte2 est egale
         *              ou inferieure a 7. Un As vaut 1, un valet vaut 11, une dame 
         *              vaut 12, un roi vaut 13 et toutes les autres cartes valent 
         *              leur nombre.
         *
        	System.out.println("Voici les cartes: " + (carte1 % 13 + 1) + " + " + (carte2 % 13 + 1) + " = " + ((carte1 % 13 + 1) + (carte2 % 13 + 1)));
        
            return laSorte ( carte1 ) + laSorte ( carte2 ) + 2 <= 7;
                   
        } // sommeEgaleOuInferieureASept
      */
    
    public static String chaineCouleur ( int carte ) {
        
        String reponse;
        
        int couleur = laCouleur ( carte );
        if (couleur == 0) {
            reponse = "coeur";
        } else if (couleur == 1) {
            reponse = "carreau";
        } else if (couleur == 2) {
            reponse = "trefle";
        } else {
            reponse = "pique";
        }
        
        return reponse;
    } // chaineCouleur
    
    public static String chaineSorte ( int carte ) {
        
        String reponse;
        
        int sorte = laSorte ( carte );
        if (sorte == 0) {
            reponse = "as";
        } else if (sorte == 10) {
            reponse = "valet";
        } else if (sorte == 11) {
            reponse = "dame";
        } else if (sorte == 12) {
            reponse = "roi";
        } else {
            reponse = String.valueOf ( sorte + 1 );
        }
        
        return reponse;
    } // chaineCouleur
    
    public static void afficherCarte ( int carte ) { 

    /* antï¿½cï¿½dent : 0 <= carte <= 51
     * consï¿½quent : Affiche la carte selon sa couleur et sa valeur
     */
    
        System.out.print ( chaineSorte ( carte ) + " " + chaineCouleur(carte)) ;
        
    } // afficherCarte
    
    public static void afficherLesDeuxCartes ( int carte1, int carte2 ) {
                          
        System.out.print ( "Voici la premiere carte : " );
        afficherCarte ( carte1 );
        System.out.println ();
            
        System.out.print ( "Voici la deuxieme carte : " );
        afficherCarte ( carte2 );
        System.out.println ( '\n' );
            
    } // afficherLesDeuxCartes

    public static void afficherFin ( int montant ) {
        
        System.out.println ( "Merci d'avoir joue avec moi !" );
        System.out.println ( "Vous quittez avec " + montant + " $ en poche." );
        
    } // afficherFin

    public static void initialiserJeuDeCarte () {
    	
    	System.out.println("Nombre de credits : " + montantJoueur);
    	System.out.println ();
        System.out.print ( "Entrez un nombre entier pour initialiser le jeu : " );
        JeuDeCartes.initialiserJeuDeCarte ( Clavier.lireInt () );
        System.out.println ();
        JeuDeCartes.brasser();
        
    } // initialiserJeuDeCarte
    
    /*Amélioration apportée
     * avant affichage dans le main
     * maintenant le main apelle cette fonction
     */
    public static void joueurGagnant(boolean gagant, int montantGagne){
    	if ( gagant ) {
            System.out.println ( "Bravo ! Vous avez gagne " + montantGagne + " $" );
            montantJoueur = montantJoueur + montantGagne;
        } else {
            System.out.println ( "Desole ! Vous avez perdu votre mise !" );
        }
    	
    }
    
    public static void setMontantJoueur(int montant){
    	montantJoueur = montant;
    }

    public static void main ( String [] arg ) {
                
        char    reponse;        // saisi : pour la reponse o ou n
        int     pari;           // saisi : pour la sorte de pari 1, 2 ou 3
        int     montantGagne;   // calcule : montant gagne selon le pari effectue
        Partie partie;			// 
        int     mise;           // saisi : montant mise par le joueur
        int     carte1;         // la premiere carte pigee
        int     carte2;         // la deuxieme carte pigee
        
        boolean joueurGagne;    // si le joueur a gagne ou non la partie 
        
        // Initialiser le procede aleatoire
        
        if (existePartieSauvegardee()){
        	System.out.print("Désirez-vous reprendre la partie enregistrée ? (o/n) : ");
        	reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
            System.out.println();
            
            while ( reponse != 'o' && reponse != 'n') {
                System.out.print ( "*** vous devez repondre par o ou n : " );
                reponse = Clavier.lireChar ();
                Clavier.lireFinLigne ();
            }
            
            if ( reponse == 'o' )
            	restaurer();
            else
            	supprimerSauvegarde();
        }
        initialiserJeuDeCarte();
        
        // Boucle pour les parties
        
        reponse = lireOption ();
        System.out.println ();
        
        while ( reponse == 'p' ) { 
            
            // saisie et validation du type de pari
            
            pari = lireSortePari ();
            System.out.println ();
            
            // saisie et validation du montant de la mise
            
            mise = lireMiseJoueur ( montantJoueur );
            System.out.println ();
            
            montantJoueur = montantJoueur - mise;
            
            // faire piger deux cartes par l'ordinateur
            //deuxCartes = JeuDeCartes.pigerDeuxCartes ();
            
            carte1 = JeuDeCartes.piger();
            carte2 = JeuDeCartes.piger();
            
            //carte1 = deuxCartes / 100;
            //carte2 = deuxCartes % 100;
            
            afficherLesDeuxCartes ( carte1, carte2 );
            
            // determiner si le joueur a gagne ou perdu
            
            joueurGagne = false;
            /*
             * Amélioration apportée
             * rajout de la varibale partie
             * rajout de la fonction de verification pour chauqe type de partie
             */
            if ( pari == 1 ) { // est-ce une paire ?
            	partie = new PartiePaire();
                joueurGagne = partie.partieEstGagnante( laSorte(carte1), laSorte(carte2));
                montantGagne = partie.mise() * mise;
            } else if ( pari == 2 ) { // est-ce une sequence ?
            	partie = new PartieSequence();
                joueurGagne = partie.partieEstGagnante( laSorte(carte1), laSorte(carte2));
                montantGagne = partie.mise() * mise;
            } else if ( pari == 3) { // deux de la meme couleur ?
            	partie = new PartieMemeCouleur();
                joueurGagne = partie.partieEstGagnante( laCouleur(carte1), laCouleur(carte2) );
                montantGagne = partie.mise() * mise;
            } else { // somme egale ou inferieure a 7 ?
            	System.out.println("Voici les cartes: " + (laSorte(carte1) + 1) + " + " + (laSorte(carte2) + 1) + " = " 
            				+ ((laSorte(carte1) + 1) + (laSorte(carte2) % 13 + 1)));
            	partie = new PartieInferieur7();
            	joueurGagne = partie.partieEstGagnante( laSorte(carte1) + 1, laSorte(carte2) + 1);
            	montantGagne = partie.mise() * mise;
            }
            
            // afficher si le joueur a gagne ou perdu ainsi que son gain s'il y a lieu
            
            joueurGagnant(joueurGagne, montantGagne);
            
            System.out.println ();
            System.out.println ( "Vous disposez maintenant de " + montantJoueur + " $" );
            System.out.println ();
            
            // determiner si on continue ou pas
            
            if ( montantJoueur > 0 ) {
                reponse = lireOption ();
            } else {
                System.out.println ( "Vous n'avez plus d'argent, vous ne pouvez continuer." );
                reponse = 'n';
            }

        } // boucle de jeu
        if ( reponse == 'e' ){
        	sauvegarder();
        }
        else if ( reponse == 'q' )
        	afficherFin ( montantJoueur );
        
    } // main
    
} // Tp2
