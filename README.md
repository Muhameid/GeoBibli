📚GeoBibli

GeoBibli est une application web développée avec Spring Boot dans le cadre d'un projet scolaire. Elle permet de gérer une bibliothèque numérique tout en intégrant une carte interactive pour localiser et rechercher des villes dans le monde.

Fonctionnalités
Ajout de livres via un onglet Catégorie, avec :

Le titre du livre

L’auteur

La catégorie

Onglet Sélection affichant une liste concise (titre, auteur, catégorie)

Onglet Accueil :

Géolocalisation automatique

Affichage d’une carte interactive

Recherche de ville dans le monde

Technologies utilisées
Spring Boot (Java)

Thymeleaf (moteur de templates)

OkHttpClient pour les appels réseau

Leaflet.js pour la carte interactive

HTML / CSS / JavaScript

Installation et exécution
Prérequis
Java JDK 17

Gradle (ou utiliser le Gradle Wrapper inclus)

Étapes
Cloner le dépôt :

bash
Copier
Modifier
git clone https://github.com/Muhameid/GeoBibli.git
cd GeoBibli
Construire le projet :

Avec le wrapper :

bash
Copier
Modifier
./gradlew build
Ou avec Gradle installé :

bash
Copier
Modifier
gradle build
Lancer l'application :

bash
Copier
Modifier
./gradlew bootRun
Accéder à l'application dans le navigateur :

http://localhost:8090

Structure du projet
src/main/java : code Java

src/main/resources/templates : vues Thymeleaf

src/main/resources/static : ressources statiques

build.gradle : configuration du projet

Remarques
Ce projet a été réalisé dans un cadre scolaire pour démontrer l'intégration d'une gestion de bibliothèque avec des fonctionnalités de géolocalisation sur carte interactive.
