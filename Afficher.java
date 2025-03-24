public class Afficher { 
    // Fonction pour afficher la grille 
    public void afficherGrille(int[][] grille) { 

        // Création d'une copie de la grille initiale pour éviter de modifier l'originale 
        int[][] grilleResolu = new int[9][9]; 
        for (int i = 0; i < 9; i++) { 
            System.arraycopy(grille[i], 0, grilleResolu[i], 0, 9); 
        }

        // Création d'un objet de la classe Reponse (supposée résoudre le Sudoku) 
        Reponse reponse = new Reponse(); 

        // Tentative de résolution de la grille 
        reponse.reponse(grilleResolu); 

        // Vérification si la grille a pu être résolue 
        if (reponse.reponse(grilleResolu)) { 

            // Affichage du titre des grilles 
            System.out.println("Grille initiale:                               Grille résolue:");
            System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗     ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");

            for (int i = 0; i < 9; i++) {
                // Première grille (grille initiale) 
                System.out.print("║ "); 
                for (int j = 0; j < 9; j++) { 
                    if (grille[i][j] == 0) 
                        System.out.print("  "); // Affichage des cases vides
                    else 
                        System.out.print(grille[i][j] + " "); // Affichage des chiffres

                    // Affichage des séparateurs verticaux 
                    if ((j + 1) % 3 == 0) { 
                        System.out.print("║ ");  
                    } else { 
                        System.out.print("| "); 
                    }
                }

                // Séparateur entre les deux grilles 
                System.out.print("    ");

                // Deuxième grille (grille résolue) 
                System.out.print("║ ");
                for (int j = 0; j < 9; j++) { 
                    System.out.print(grilleResolu[i][j] + " "); 

                    // Affichage des séparateurs verticaux 
                    if ((j + 1) % 3 == 0) { 
                        System.out.print("║ ");  
                    } else { 
                        System.out.print("| "); 
                    }
                }

                System.out.println(); // Passage à la ligne 

                // Affichage des séparateurs horizontaux entre les lignes 
                if ((i + 1) % 3 == 0 && i != 8) {  
                    System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣     ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");  
                } else { 
                    if (i != 8) 
                        System.out.println("╠───|───|───║───|───|───║───|───|───╣     ╠───|───|───║───|───|───║───|───|───╣");  
                }
            }

            // Affichage de la dernière ligne des deux grilles 
            System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝     ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
        } else { 
            // Si aucune solution n'est trouvée, affichage uniquement de la grille initiale
            System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");

            for (int i = 0; i < 9; i++) { 
                // Début de la ligne de la grille
                System.out.print("║ ");  
                for (int j = 0; j < 9; j++) { 
                    // Affichage des chiffres ou des cases vides 
                    if (grille[i][j] == 0) 
                        System.out.print("  ");  
                    else 
                        System.out.print(grille[i][j] + " "); 

                    // Affichage des séparateurs verticaux 
                    if ((j + 1) % 3 == 0) { 
                        System.out.print("║ ");  
                    } else { 
                        System.out.print("| ");  
                    }
                }

                System.out.println(); // Passage à la ligne 

                // Affichage des séparateurs horizontaux entre les lignes 
                if ((i + 1) % 3 == 0 && i != 8) {  
                    System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");  
                } else { 
                    if (i != 8) 
                        System.out.println("╠───|───|───║───|───|───║───|───|───╣");  
                }
            }

            // Fin de la grille
            System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝"); 

            // Message indiquant que le Sudoku est impossible à résoudre 
            System.out.println("\n\n Sudoku impossible\n\n"); 
        }
    }
}
