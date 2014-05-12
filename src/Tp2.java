import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Piccolo
 * @version 1.0
 */
public class Tp2 {
	/* Am�lioration apport�e
    */
	private static int montantJoueur = 100;
    private static boolean joueurGagne;    // si le joueur a gagne ou non la partie 
    private static int montantGagne; // calcule : montant gagne selon le pari effectue
    private static int mise; // saisi : montant mise par le joueur

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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static char lireOption () {
        
        char reponse;
        
        System.out.print ( "Voulez-vous jouer une partie (p), enregistrer (e) ou quitter (q) ?" );
        reponse = Clavier.lireChar ();
        Clavier.lireFinLigne ();  
        
        while ( reponse != 'p' && reponse != 'e' && reponse != 'q' && reponse != 'P' && reponse != 'E' && reponse != 'Q') {
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
    
    /*Am�lioration apport�e
     * function lireMontantJoueur  
     * maintenat le joueur commence soit avec 100 jetons ou bien 
     * il reprend une partie souvegarder
     */

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
    
    
    /*Am�lioration apport�e
     * function laSorte
     * cette function est remplac�e par celle de la classe JeuDeCartes
     */
    
    /*Am�lioration apport�e
     * function laCouleur
     * cette function est remplac�e par celle de la classe JeuDeCartes
     */
    
    
    /* Am�lioration apport�e
     * function estUnePaire
     * cette fonction est maintenant situ�e dans la classe PartiePair
     */

    /*
     * Am�lioration apport�e
     * function sontMemeCouleur
     * cette fonction est maintenant situ/ dans la classe PartieMemeCouleur
	*/
    
    /* Am�lioration apport�e
     * function estUneSequence
     * cette fonction est maintenant situ�e dans la classe PartieSequence
    */
    
    /*
     * Am�lioration apport�e
     * function chaineCouleur, function chaineSorte et function afficherCarte
     * maintenant function gui qui permet d<afficher la valeur ainsi que la sorte de la carte
     */
    
    public static void afficherLesDeuxCartes ( int carte1, int carte2 ) {
        GUI.afficherCartes(carte1, carte2);   
    } // afficherLesDeuxCartes

    public static void afficherFin () {
        
        System.out.println ( "Merci d'avoir joue avec moi !" );
        System.out.println ( "Vous quittez avec " + montantJoueur + " $ en poche." );
        
    } // afficherFin

    public static void initialiserJeuDeCarte () {
    	
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
        
    } // initialiserJeuDeCarte
    
    /*Am�lioration apport�e
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
    
    /* Am�lioration apport�e
	 * methode pour mettre l'argent du joueur dans la variable de classe
	 */
    public static void setMontantJoueur(int montant){
    	montantJoueur = montant;
    }
    
    /* Am�lioration apport�e
	 * methode pour afficher la somme des cartes
	 */
    public static void afficherSommeCarte(int carte1, int carte2){
    	System.out.println("Voici les cartes: " + JeuDeCartes.valeur(carte1) + " + " + JeuDeCartes.valeur(carte2) + " = " 
                + (JeuDeCartes.valeur(carte1) + JeuDeCartes.valeur(carte2)));
    }

    /* Am�lioration apport�e
     * rajout de la varibale partie
     * rajout de la fonction de verification pour chauqe type de partie
     * rajout de la finction mise 
    */
    public static void pariFait(int parie, int carte1, int carte2){
        Partie partie;

        if ( parie == 1 ) { // est-ce une paire ?
                partie = new PartiePaire();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) - 1, JeuDeCartes.valeur(carte2) - 1);
                montantGagne = partie.mise() * mise;
                
            } else if ( parie == 2 ) { // est-ce une sequence ?
                partie = new PartieSequence();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1) -1, JeuDeCartes.valeur(carte2) -1);
                montantGagne = partie.mise() * mise;
                
            } else if ( parie == 3) { // deux de la meme couleur ?
                partie = new PartieMemeCouleur();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.couleur(carte1), JeuDeCartes.couleur(carte2) );
                montantGagne = partie.mise() * mise;
                
            } else { // somme egale ou inferieure a 7 
                partie = new PartieInferieur7();
                joueurGagne = partie.partieEstGagnante( JeuDeCartes.valeur(carte1), JeuDeCartes.valeur(carte2));
                montantGagne = partie.mise() * mise;
            }

    }
    
    /* Am�lioration apport�e
	 * le jeu affiche le montant du joueur au depart
	 */
    public static void afficherMontantJoueur(){
    	System.out.println ( "Vous disposez maintenant de " + montantJoueur + " $" );
    }

    public static void main ( String [] arg ) {
                
        char    reponse;        // saisi : pour la reponse o ou n
        int     pari;           // saisi : pour la sorte de pari 1, 2 ou 3
        			 
        int     carte1;         // la premiere carte pigee
        int     carte2;         // la deuxieme carte pigee
        
        // Initialiser le procede aleatoire
        initialiserJeuDeCarte();
        
        if (existePartieSauvegardee()){
        	System.out.print("D�sirez-vous reprendre la partie enregistr�e ? (o/n) : ");
        	reponse = Clavier.lireChar ();
            Clavier.lireFinLigne ();
            System.out.println();
            
            while ( reponse != 'o' && reponse != 'n' && reponse != 'O' && reponse != 'N' ) {
                System.out.print ( "*** vous devez repondre par o ou n : " );
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
        	/* Am�lioration apport�e
        	 * le jeu affiche le montant du joueur au depart
        	 */
        	afficherMontantJoueur();
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
            afficherSommeCarte(carte1, carte2);
            
            
            // determiner si le joueur a gagne ou perdu
            
            joueurGagne = false;
            
            /* Am�lioration apport�e
             * rajout de la function parie
             */
            pariFait(pari, carte1, carte2);

            // afficher si le joueur a gagne ou perdu ainsi que son gain s'il y a lieu
            
            joueurGagnant(joueurGagne, montantGagne);
            
            System.out.println ();
            System.out.println ();
            
            // determiner si on continue ou pas
            
            if ( montantJoueur > 0 ) {
                reponse = lireOption ();
            } else {
                System.out.println ( "Vous n'avez plus d'argent, vous ne pouvez continuer." );
                reponse = 'q';
            }

        } // boucle de jeu
        if ( reponse == 'e' || reponse == 'E' ){
        	sauvegarder();
        }
        else if ( reponse == 'q' || reponse == 'Q' ) {
        	afficherFin();
        	supprimerSauvegarde();
        }
        System.exit(-1);
        
    } // main
    
} // Tp2
