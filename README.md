📚GeoBibli

GeoBibli est une application web développée avec Spring Boot dans le cadre d'un projet scolaire. Elle permet de gérer une bibliothèque numérique tout en intégrant une carte interactive pour localiser et rechercher des villes dans le monde.

* Fonctionnalités
   - Ajout de livres via un onglet Catégorie, avec : le titre du livre , l’auteur, la catégorie

  - Onglet Sélection affichant une liste concise (titre, auteur, catégorie)

  - Onglet Accueil : Géolocalisation automatique, Affichage d’une carte interactive, Recherche de ville dans le monde

* Technologies utilisées : Spring Boot (Java) , Thymeleaf (moteur de templates), OkHttpClient pour les appels réseau, Leaflet.js pour la carte interactive, HTML / CSS / 

* Installation et exécution
 - Prérequis: Java JDK 17, Gradle (ou utiliser le Gradle Wrapper inclus)

* Étapes
 1- Cloner le dépôt :
 - git clone https://github.com/Muhameid/GeoBibli.git

 - cd GeoBibli

2- Construire le projet :

Avec le wrapper : ./gradlew build
Ou avec Gradle installé : gradle build

3- Lancer l'application : ./gradlew bootRun

4- Accéder à l'application dans le navigateur : http://localhost:8090


* Structure du projet
src/main/java : code Java

src/main/resources/templates : vues Thymeleaf

src/main/resources/static : ressources statiques

build.gradle : configuration du projet

* Remarques :
Ce projet a été réalisé dans un cadre scolaire pour démontrer l'intégration d'une gestion de bibliothèque avec des fonctionnalités de géolocalisation sur carte interactive.
