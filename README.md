# Projet : Algorithmes de Recherche de Chemin

## Description
Ce projet Java implémente deux algorithmes de recherche de chemin : **Dijkstra** et **A***. Il utilise une représentation graphique d'une grille pour visualiser le graphe et les chemins calculés. L'utilisateur peut choisir l'algorithme souhaité pour trouver le chemin le plus court entre un point de départ et un point d'arrivée.

## Fonctionnalités
- **Lecture de fichiers** pour construire une carte sous forme de graphe pondéré.
- **Visualisation des sommets et des arêtes** dans une grille colorée.
- **Calcul du chemin le plus court** avec les algorithmes Dijkstra ou A*.
- **Gestion d'un graphe pondéré** avec des sommets et des arêtes personnalisés.
- **Écriture du chemin trouvé** dans un fichier de sortie.

## Structure du Projet
- **`App.java`** : Contient la logique principale de l'application, y compris l'interface utilisateur, le traitement des fichiers d'entrée et la gestion des algorithmes.
- **`WeightedGraph.java`** : Définit la structure du graphe pondéré.
- **`Board`** : Gère l'affichage graphique.

## Compilation/ Execution 
- **Compilation** `javac MainApp/App.java MainApp/WeightedGraph.java`
- **Execution** `java MainApp.app`
