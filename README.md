# Application Lemonade

Une application Android interactive développée avec Jetpack Compose. Cette application guide l'utilisateur à travers les étapes de préparation d'une citronnade, depuis la cueillette du citron jusqu'à la dégustation du jus.

Ce projet fait partie du module de formation Android Basics avec Compose (Chapitre 7 : S'entraîner : associer un comportement à un clic).

---

## Fonctionnalités

- **Machine à états interactive :** Mise à jour dynamique de l'interface utilisateur (images et textes) en fonction des clics de l'utilisateur sur 4 étapes séquentielles.
- **Logique de pression aléatoire :** L'étape 2 nécessite d'appuyer sur le citron un nombre aléatoire de fois (entre 2 et 4 inclus) avant de pouvoir passer à l'étape suivante.
- **Interface Material 3 :** Design personnalisé respectant les couleurs officielles du projet, des angles arrondis sur le bouton et la prise en charge de l'accessibilité.

---

## Cycle de fonctionnement

1. **Sélectionner un citron :** Appuyer sur le citronnier pour cueillir un citron.
2. **Presser le citron :** Appuyer sur le citron à plusieurs reprises (2 à 4 fois de manière aléatoire) pour le presser.
3. **Boire la citronnade :** Appuyer sur le verre plein pour la boire.
4. **Recommencer :** Appuyer sur le verre vide pour réinitialiser l'application et revenir à la première étape.

---

## Prérequis et configuration

- **IDE :** Android Studio (version récente)
- **SDK minimum :** 24 (Android 7.0 Nougat)
- **Langage :** Kotlin
- **Framework UI :** Jetpack Compose (Material 3)

### Ressources requises
Assurez-vous que les fichiers vectoriels suivants sont placés dans le dossier `app/src/main/res/drawable/` :
- `lemon_tree.xml`
- `lemon_squeeze.xml`
- `lemon_drink.xml`
- `lemon_restart.xml`

---

## Spécifications de design

| Élément | Option de personnalisation | Valeur / Couleur |
| :--- | :--- | :--- |
| **Top App Bar** | Couleur de fond | `#F9E44C` (Jaune) |
| **Bouton d'image** | Couleur de fond | `#C3ECD2` (Vert menthe) |
| **Bouton d'image** | Forme de bordure | `RoundedCornerShape(40.dp)` |
| **Typographie** | Taille du texte d'instruction | `18.sp` |
| **Espacement** | Espace entre l'image et le texte | `16.dp` |
