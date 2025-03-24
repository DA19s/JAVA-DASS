public class Vide {
     //Fonction qui cherche une case vide et il prend juste la grille en parametre
     public int[] vide(int[][] grille) {
        //On parcoure juste la grille comme une matrice de dimension 9x9 et on retourne la premiere case qu'on trouve 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            if (grille[i][j] == 0) {
                /* Quand on trouve une case vide on cree un tableau simple qui va contenir:
                Le numero de la ligne i dans tab[0]
                Le numero de la colonne dans tab[1]
                */
                int[] tab = new int[2];
                tab[0] = i;
                tab[1] = j;
                return tab;
            }
            }
        }
        //Si on ne trouve aucune case vide on retourne null
        return null;
    }
}
