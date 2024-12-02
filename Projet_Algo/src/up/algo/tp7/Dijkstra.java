package up.algo.tp7;

import java.util.*;

class Graphe {
    private final int nbSommets;
    private final List<List<Arete>> listeAdjacence;

    public Graphe(int nbSommets) {
        this.nbSommets = nbSommets;
        listeAdjacence = new ArrayList<>();
        for (int i = 0; i < nbSommets; i++) {
            listeAdjacence.add(new ArrayList<>());
        }
    }

    // Convertit une lettre en un indice (A -> 0, B -> 1, ...)
    private int lettreEnIndice(char lettre) {
        return lettre - 'A';
    }

    // Ajouter une arête entre deux sommets donnés en lettres
    public void ajouterArete(char source, char destination, int poids) {
        int indiceSource = lettreEnIndice(source);
        int indiceDestination = lettreEnIndice(destination);

        listeAdjacence.get(indiceSource).add(new Arete(indiceDestination, poids));
        listeAdjacence.get(indiceDestination).add(new Arete(indiceSource, poids)); // Graphe non orienté
    }

    // Accéder à la liste d'adjacence
    public List<List<Arete>> getListeAdjacence() {
        return listeAdjacence;
    }

    public int getNbSommets() {
        return nbSommets;
    }
}

class Arete {
    int destination;
    int poids;

    public Arete(int destination, int poids) {
        this.destination = destination;
        this.poids = poids;
    }
}

public class Dijkstra {
    public static void dijkstra(Graphe graphe, char sommetDepart) {
        int nbSommets = graphe.getNbSommets();
        int[] dist = new int[nbSommets];
        boolean[] visite = new boolean[nbSommets];
        int[] predecesseur = new int[nbSommets];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(predecesseur, -1);

        int indiceDepart = sommetDepart - 'A';
        dist[indiceDepart] = 0;

        for (int i = 0; i < nbSommets; i++) {
            int sommetCourant = selectionnerSommet(dist, visite);
            visite[sommetCourant] = true;

            for (Arete voisin : graphe.getListeAdjacence().get(sommetCourant)) {
                if (!visite[voisin.destination] && dist[sommetCourant] + voisin.poids < dist[voisin.destination]) {
                    dist[voisin.destination] = dist[sommetCourant] + voisin.poids;
                    predecesseur[voisin.destination] = sommetCourant;
                }
            }
        }

        // Affichage des résultats
        afficherResultats(dist, predecesseur, sommetDepart);
    }

    private static int selectionnerSommet(int[] dist, boolean[] visite) {
        int minDist = Integer.MAX_VALUE;
        int sommetMin = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visite[i] && dist[i] < minDist) {
                minDist = dist[i];
                sommetMin = i;
            }
        }

        return sommetMin;
    }

    private static void afficherResultats(int[] dist, int[] predecesseur, char sommetDepart) {
        System.out.println("Résultats de l'algorithme de Dijkstra :");
        System.out.println("Sommet de départ : " + sommetDepart);
        for (int i = 0; i < dist.length; i++) {
            System.out.print((char) (i + 'A') + " - Distance : " + dist[i]);
            if (predecesseur[i] != -1) {
                System.out.println(", Prédecesseur : " + (char) (predecesseur[i] + 'A'));
            } else {
                System.out.println(", Prédecesseur : Aucun");
            }
        }
    }

    public static void main(String[] args) {
        Graphe graphe = new Graphe(9); 

        graphe.ajouterArete('H', 'A', 1);
        graphe.ajouterArete('A', 'C', 2);
        graphe.ajouterArete('C', 'F', 3);
        graphe.ajouterArete('F', 'I', 3);
        graphe.ajouterArete('G', 'I', 1);
        graphe.ajouterArete('E', 'G', 2);
        graphe.ajouterArete('E', 'F', 2);
        graphe.ajouterArete('C', 'G', 4);
        graphe.ajouterArete('D', 'C', 1);
        graphe.ajouterArete('D', 'E', 1);
        graphe.ajouterArete('C', 'E', 1);
        graphe.ajouterArete('A', 'D', 3);
        graphe.ajouterArete('B', 'D', 2);
        graphe.ajouterArete('H', 'B', 3);
        graphe.ajouterArete('F', 'G', 2);






        dijkstra(graphe, 'H'); // Dijkstra à partir du sommet A
    }
}

