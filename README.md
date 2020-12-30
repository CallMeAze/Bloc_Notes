# Bloc_Notes

## Présentation

Ce projet de création d'un bloc-notes est un projet de quatrième année d'école d'ingénieur. Cette application permet la saisie et l'affichage de notes divers et variés

# Consignes respectées : 

- Création d'une base de données à l'aide de **Room**
- **Clean architecture**
- Affichage d'une liste
- Architecture **MVVM**
- **Design**
- **Fonctionnalités supplémentaires :**
  - Utilisation de **LifeCycle**
  - Utilisation de **LiveData**


# Fonctionnalités: 

## Ecran Home 

- Affichage de deux TextView et d'un bouton de sauvegarde.

<img src ="https://github.com/CallMeAze/Bloc_Notes/blob/master/Img_github/basic_layout.PNG" width="250"/>

Dans la première zone de texte l'utilisateur doit saisir le nom qu'il veut donner à sa note.
Dans la deuxième zone de texte l'utilisateur doit saisir ses notes, enfin lorsque l'utilisateur a fini il clique sur le bouton save afin de sauvegarder ses notes.

## Insertion des données :

Une fois que l'utilisateur à cliqué sur le bouton de sauvegarde, les éléments sont insérés dans la base de données et réacfficher à l'utilisateur avec l'aide d'une recyclerview.
L'utilisateur peut par la suite interagir avec les données précedement inscrites.

<img src ="https://github.com/CallMeAze/Bloc_Notes/blob/master/Img_github/Insert_notes.PNG" width="250"/>

## Mise à jour des données :

Lorsque l'utilisateur clique sur un élément créé, il va pouvoir le modifier (faire une Update). Pour ce faire l'utilisateur doit changer un texte, peu importe que celui-ci
soit le nom ou le contenu de la note. Une fois qu'il aura fini l'update de la note il n'y a plus qu'à cliquer sur le bouton UPDATE.

<img title ="Mis à jour en cours" src ="https://github.com/CallMeAze/Bloc_Notes/blob/master/Img_github/updating_notes.PNG" width="250"/> <img title ="Résultat des mise à jours" src ="https://github.com/CallMeAze/Bloc_Notes/blob/master/Img_github/results_after_update.PNG" width="250"/>

## Suppresion des données : 

Quand une note n'est plus utilisé par l'utilisateur, ce dernier peut la supprimer, pour ce faire une icône symbolisant la suppression à été ajouté à droite des notes.
Sur cette image nous pouvons voir que les notes intitulés "First Note" et "Important" ont été supprimés.

<img src ="https://github.com/CallMeAze/Bloc_Notes/blob/master/Img_github/deleted_notes.PNG" width="250"/>
