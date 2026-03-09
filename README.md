# Représentation d'images en couleurs

Ce projet est un TP fait à Aix-Marseille Université, un modèle (template) Java pour la manipulation et la représentation d'images en couleurs, développé avec Gradle. Il explore différentes approches pour stocker et gérer les images, en mettant l'accent sur l'efficacité mémoire et les performances.

## Fonctionnalités principales

Le projet implémente quatre types d'images via des classes spécialisées :

- **BruteRasterImage** : Représentation raster classique où chaque pixel est stocké directement dans une matrice de couleurs. Simple mais potentiellement gourmand en mémoire pour les grandes images.

- **PaletteRasterImage** : Utilise une palette de couleurs limitée pour indexer les pixels, réduisant considérablement l'espace mémoire requis, idéal pour les images avec peu de couleurs distinctes.

- **SparseRasterImage** : Représentation creuse optimisée pour les images contenant beaucoup de pixels identiques (par exemple, des arrière-plans uniformes ou transparents), évitant de stocker les valeurs répétitives.

- **VectorImage** : Représentation vectorielle basée sur des formes géométriques (cercles, rectangles, etc.), permettant un rendu à n'importe quelle résolution sans perte de qualité.

## Architecture

- **Interface Image** : Définit les méthodes communes (`getPixelColor`, `getWidth`, `getHeight`).
- **Classes abstraites** : `RasterImage` pour les images matricielles, avec des implémentations concrètes pour chaque type.
- **Factories** : Des classes comme `BlankImageFactory`, `RasterFlagFactory`, `LogoLISFactory` permettent de créer des images prédéfinies (drapeaux, logos, formes simples).
- **Utilitaires** : `Matrices.java` pour les opérations sur les matrices de couleurs.
- **Interface graphique** : Un viewer JavaFX (`Display.java`, `Main.java`) avec un fichier FXML pour afficher les images de manière interactive.

## Tests et build

- Tests unitaires présents dans `test/java/`.
- Build automatisé avec Gradle (fichiers `build.gradle`, `settings.gradle`).
- Compatible avec les environnements Java standard.



