import java.io.IOException;

public class Sudoku { 

    public static void main(String[] args) {
        int[][] grille;
    // On verifie si un chemin de fichier a été fourni en argument
    if (args.length < 1) {
        System.out.println("Veuillez saisir la grille de Sudoku chiffre par chiffre.");
       // Saisir saisir = new Saisir();
        grille = Saisir.saisirGrilleManuellement();
    }
    else {

    // On recupere le fichier
      String cheminFichier = args[0];
            Lire lire = new Lire();
            
            try {
                grille = lire.lireDoku(cheminFichier);

                // Vérification de la grille
                if (!Valide.estGrilleValide(grille)) {
                    System.out.println("Erreur : la grille fournie est invalide.");
                    return;
                }

            } catch (IOException e) {
                System.out.println("Erreur de lecture du fichier : " + e.getMessage());
                return;
            } catch (NumberFormatException e) {
                System.out.println("Erreur de format dans le fichier : " + e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Erreur inattendue : " + e.getMessage());
                return;
            }
        }
        // On appelle afficherGrille pour la grille initiale
        System.out.println("Grille initiale :");
        Afficher afficher = new Afficher();
        afficher.afficherGrille(grille);

        // Si reponse renvoit true alors alors on afficher la nouvelle grille
        Reponse reponse = new Reponse();
        if (reponse.reponse(grille)) {
            System.out.println("\nGrille résolue :");
            afficher.afficherGrille(grille);

            //Sinon on dit qu'on a trouve aucune solution
        } else {
            System.out.println("Aucune solution trouvée.");
        }
    }
}
