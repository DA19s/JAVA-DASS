import java.util.Scanner;

public class Saisir {

    // Fonction pour saisir manuellement la grille en cas d'absence de paramètre
    public static int[][] saisirGrilleManuellement() {
        Scanner scanner = new Scanner(System.in);
        // On initialise la grille
        int[][] grille = new int[9][9];

        // On parcourt la grille ligne par ligne en demandant a l'utilisateur de remplir
        for (int i = 0; i < 9; i++) {
            while (true) {
                System.out.print("Entrez la ligne " + (i + 1) + " avec des chiffres séparés par des espaces : ");
                String input = scanner.nextLine().trim();
                String[] chiffres = input.split("\\s+");

                // Vérifier que la ligne contient exactement 9 chiffres
                if (chiffres.length != 9) {
                    System.out.println("Erreur : Vous devez entrer exactement 9 chiffres !");
                    continue; // Pour recommencer
                }

                // On cree une variable qui stocke la validité des valeurs
                boolean ligneValide = true;
                for (int j = 0; j < 9; j++) {
                    try {
                        int valeur = Integer.parseInt(chiffres[j]);
                        // On verifie si la valeur est comprise entre 0 et 9
                        if (valeur < 0 || valeur > 9) {
                            System.out.println("Erreur : Chaque chiffre doit être entre 0 et 9 !");
                            // Si la valeur n'est pas dans l'intervalle alors ligneValide prend false et on sort de la boucle
                            ligneValide = false;
                            break;
                        }
                        grille[i][j] = valeur;
                    } catch (NumberFormatException e) {
                        // On verifie qu'on ecrit uniquement des chiffres
                        System.out.println("Erreur : Veuillez entrer uniquement des chiffres !");
                        // Si la valeur n'est pas un chiffre alors ligneValide prend false et on sort de la boucle
                        ligneValide = false;
                        break;
                    }
                }

                // On verifie si ligneValide est true on break pour sortir du while(true) sinon le while va recommencer
                if (ligneValide) {
                    break; // Ligne correctement saisie, passer à la suivante
                }
            }
        }

        return grille;
    }
}



