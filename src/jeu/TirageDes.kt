package jeu

/**
 * Classe représentant un tirage de dés.
 * Cette classe permet de lancer plusieurs dés et d'obtenir un résultat total.
 *
 * @property nbDe Le nombre de dés à lancer.
 * @property maxDe Le nombre de faces sur chaque dé (valeur maximale possible).
 */

class TirageDes(val nbDe:Int, val maxDe:Int) {

    /**
     * Lance les dés en fonction du nombre de dés et du nombre de faces, puis retourne le résultat total.
     *
     * Par exemple, pour un lancer de "3d8" (3 dés à 8 faces) :
     * - Lance le premier dé, ajoute son résultat.
     * - Lance le deuxième dé, ajoute son résultat au précédent.
     * - Lance le troisième dé, ajoute son résultat au total.
     *
     * @return Le total des dés lancés.
     */

    fun lance():Int{
        // Si on lance 3d8
        // nbDe = 3 correspond au nombre de dés que l'on souhaite lancer
        // maxDe = 8 correspond au nombre de face du dé et aussi a la valeur maximum du dé
        // resultat =0
        // on lance le premier dé on fait un 4
        // resultat =4
        // on lance le deuxième dé on fait un 3
        // resultat =7
        // on lance le troisème dé on fait un 8
        // resultat = 15
        // la méthode retourne 15
        var resultat=0
        repeat(this.nbDe){
            resultat+=(1..this.maxDe).random()
        }
        return resultat
    }
}