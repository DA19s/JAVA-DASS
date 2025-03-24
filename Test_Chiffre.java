public class Test_Chiffre {
     /*fonction pour tester si un chiffre peut rentrer dans une case avec comme parametre:
    num: Le chiffre qu'on veut tester, row et col pour ligne et colonne et la grille*/
    public boolean test(int num, int row, int col, int[][] grille) { 
        //on va verifier les 9 cases de la ligne et de la colonne
        for (int i = 0; i < 9; i++) { 
            //On verifie si on retrouve num sur la ligne ou la colonne de la grille on retourne false
            if (grille[row][i] == num || grille[i][col] == num)
                return false;
        }

        //On fait pareil pour le bloc: 
        int startRow = row - row % 3; //startRow qui retrouve la ligne du debut du bloc
        int startCol = col - col % 3; //startRow qui retrouve la colonne du debut du bloc

        //On va parcourir juste 3 cases vu qu'on verifie juste le bloc
        // On utilise i pour se positionner sur la ligne
        for (int i = 0; i < 3; i++) {
                    // On utilise j pour se positionner sur la colonne
            for (int j = 0; j < 3; j++) {
                //Si on retrouve num on retourne false
            if (grille[startRow + i][startCol + j] == num)
                return false;
            }
        }

        //Si on a jamais retrouve num alors on retourne true pour dire qu'on peut mettre num sur la case
        return true;

    }       

}
