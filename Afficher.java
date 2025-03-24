public class Afficher {
     //Fonction pour afficher la grille:
     public void afficherGrille(int[][] grille) {
        // On utilise des doubles traits horizontaux et le double trait vertical pour les blocs
        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        for (int i = 0; i < 9; i++) {
            //On affiche les doubles traits pour le debut de la grille
            System.out.print("║ "); 
            for (int j = 0; j < 9; j++) {
                //On affiche le chiffre
                if (grille[i][j]==0)
                System.out.print(" " + " ");
                else
                System.out.print(grille[i][j] + " ");
                // On affiche le double trait a la fin du bloc
                if ((j + 1) % 3 == 0) {
                    System.out.print("║ "); 
                    // Sinon on affiche un trait simple
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println();
            
            if ((i + 1) % 3 == 0 && i != 8) { 
                // Pour les blocs
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣"); 
            } else {
                if ( i != 8 )
                System.out.println("╠───|───|───║───|───|───║───|───|───╣"); 

            }
        }
        // Pour le bas de la grille
        System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
    }
    
}
