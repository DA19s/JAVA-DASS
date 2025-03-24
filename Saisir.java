import java.util.Scanner;

public class Saisir {
    // Fonction pour saisir manuellement la grille en cas d'abscencre de parametre
     public static int[][] saisirGrilleManuellement() {
        Scanner scanner = new Scanner(System.in);
        // On initialise la grille
        int[][] grille = new int[9][9];
        // On cree une instance de Afficher pour retourner la grille apres chaque saisit
        Afficher afficher = new Afficher();

        // On parcours la grille en demandant a l'utilisateur de saisir un chiffre a la position actuelle
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                while (true) {
                    System.out.print("Entrez le chiffre à la position [" + (i + 1) + "][" + (j + 1) + "] (0 pour une case vide) : ");
                    String input = scanner.nextLine().trim();

                    try {
                        // On recupere l'input
                        int valeur = Integer.parseInt(input);
                        if (valeur >= 0 && valeur <= 9) {
                            // On verifie si la valeur est valide, si oui on remplit
                            grille[i][j] = valeur;
                            afficher.afficherGrille(grille); // Affichage après chaque saisie
                            break;
                        } else {
                            // Si la valeur n'est pas valide on envoit une erreur
                            System.out.println("Erreur : entrez un chiffre entre 0 et 9 !");
                        }
                        // On verifie qu'on saisit uniquement des chiffres
                    } catch (NumberFormatException e) {
                        System.out.println("Erreur : veuillez entrer uniquement des chiffres !");
                    }
                }
            }
        }
        // Quand tout est bon on renvoit la grille
        return grille;
    }
}

