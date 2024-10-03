package jeu

import personnage.Personnage

/**
 * Classe représentant le jeu. Elle gère les combats entre le joueur et une liste de monstres.
 *
 * @property joueur Le personnage du joueur, créé lors de l'initialisation du jeu.
 * @property combats La liste des combats qui seront exécutés.
 * @property score Le score du joueur, calculé en fonction des tours de combat.
 */



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur
    lateinit var joueur: Personnage
    //La liste des monstre a combatre
     var combats: MutableList<Combat> = mutableListOf()
    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    /**
     * Lance tous les combats dans la liste et met à jour le score en fonction du nombre de tours nécessaires pour chaque combat.
     */

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    /**
     * Calcule le score du joueur en fonction du nombre de tours nécessaires pour finir un combat.
     * Moins il y a de tours, plus le score est élevé.
     *
     * @param tours Le nombre de tours pris pour terminer un combat.
     * @return Le score calculé pour ce combat.
     */

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    /**
     * Crée le personnage du joueur en demandant des informations comme le nom, l'attaque, la défense, l'endurance et la vitesse.
     * L'utilisateur doit entrer des valeurs jusqu'à ce que le total des statistiques ne dépasse pas 40.
     *
     * @return Le personnage créé par le joueur.
     */
    fun creerPersonnage(): Personnage {
        println("Création votre personnage:")
        // TODO Mission 1.1
        val nomPerso = readln()
        var ScoreAttaque = readln().toInt()
        var defense = readln().toInt()
        var endurance = readln().toInt()
        var vitesse = readln().toInt()
        var pvmax = 50 + 10 + endurance

        while (ScoreAttaque + defense + endurance + vitesse > 40 ){
            println("Veuillez ne pas dépasser la limite de 40 ")
            ScoreAttaque = readln().toInt()
            defense = readln().toInt()
            endurance = readln().toInt()
            vitesse = readln().toInt()

        }




        val hero = Personnage("$nomPerso",150,150,12,8,8,12)
        this.joueur= hero
        return hero
    }

    

}