public class Reponse {
    //Fonction pour remplir la grille jusqu'a reussir ou echouer
    public boolean reponse(int[][] grille) {
        //On verifie d'abord si la grille contient des cases vides
        Vide vide = new Vide();
        if (vide.vide(grille) == null)
        //Si la grille est rempli alors on a reussi et on renvoit true
        return true;

        //Sinon on recupere la position exacte de la case vide renvoye par la fonction vide et on teste avec la fonction test
        else {
            int row = vide.vide(grille)[0]; // On verifie la ligne dans la position 0 du tableau renvoye par vide
            int col = vide.vide(grille)[1]; // On verifie la colonne dans la position 1 du tableau renvoye par vide
            // On va parcourir les chiffres de 1 a 9 et les tester dans la grille grace a la fonction test
            for (int i = 1; i < 10; i++){
                // Si le test renvoit true alors on place le chiffre dans la case vide
                Test_Chiffre test = new Test_Chiffre();
                if (test.test(i, row, col, grille)) {
                    grille[row][col] = i;

                    //On rappelle ensuite directement reponse pour qu'il continue de remplir la grille de la meme maniere
                    if (reponse(grille)) {
                        // Lorsque reponse retourne true alors on retourne ce qui nous permettra de remonter et renvoyer true
                        return true;
                    }
                    //Si reponse renvoi false on remet on remet la case a 0 et on avance
                    grille[row][col] = 0;
    
                }
            }
        }

        //Si reponse n'a pas pu retourner true alors on a echouer et on retourne false
        return false;
    }
}
