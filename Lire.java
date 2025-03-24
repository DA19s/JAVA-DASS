import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lire {
    public int[][] lireDoku(String cheminFichier) throws IOException, NumberFormatException {
        int[][] grille = new int[9][9];
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int row = 0;

            while ((ligne = br.readLine()) != null) {
                String[] chiffres = ligne.trim().split("\\s+");

                // Vérifie que chaque ligne contient exactement 9 chiffres
                if (chiffres.length != 9) {
                    throw new IOException("Format invalide : la ligne " + (row + 1) + " ne contient pas 9 chiffres.");
                }

                for (int col = 0; col < 9; col++) {
                    try {
                        grille[row][col] = Integer.parseInt(chiffres[col]);
                        if (grille[row][col] < 0 || grille[row][col] > 9) {
                            throw new NumberFormatException("Valeur invalide à la ligne " + (row + 1) + ", colonne " + (col + 1));
                        }
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Erreur de format à la ligne " + (row + 1) + ", colonne " + (col + 1) + " : " + chiffres[col]);
                    }
                }
                row++;
            }

            // Vérifie qu'on a bien 9 lignes
            if (row != 9) {
                throw new IOException("Format invalide : le fichier contient " + row + " lignes au lieu de 9.");
            }
        }

        return grille;
    }
}
