public class Valide {

    // Fonction pour verifier si la grille est valide
    public static boolean estGrilleValide(int[][] grille) {
        //Si la grille est nulle ou que la taille est differente de 9 on se retourne false
        if (grille == null || grille.length != 9) return false;
        
        for (int i = 0; i < 9; i++) {
            if (grille[i].length != 9) return false;
            for (int j = 0; j < 9; j++) {
                //Si on a pas des chiffres entre 0 et 9 on retourne false
                if (grille[i][j] < 0 || grille[i][j] > 9) return false; // Valeurs invalides
            }
        }
        // Si tout est bon on retourne true
        return true;
    }
}

