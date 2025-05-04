package com.example;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque laBanque) {
        this.banque = laBanque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        // Vérifier si le jeu est ouvert
        if (!estOuvert()) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        try {
            // Prélever la mise au joueur
            int mise = joueur.mise();
            joueur.debiter(mise);
            
            // Créditer la banque avec la mise
            banque.crediter(mise);
            
            // Lancer les dés
            int resultatDe1 = de1.lancer();
            int resultatDe2 = de2.lancer();
            int somme = resultatDe1 + resultatDe2;
            
            // Si la somme est 7, le joueur gagne
            if (somme == 7) {
                int gain = mise * 2;
                banque.debiter(gain);
                joueur.crediter(gain);
                
                // Vérifier si la banque est toujours solvable
                if (!banque.est_solvable()) {
                    fermer();
                }
            }
        } catch (DebitImpossibleException e) {
            // Le joueur est insolvable, rien à faire
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
} 