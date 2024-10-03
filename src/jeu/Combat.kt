package jeu

import personnage.Personnage


/**
 * Classe représentant un combat entre le joueur et un monstre dans le jeu.
 *
 * @property jeu Le jeu dans lequel le combat se déroule.
 * @property monstre Le monstre contre lequel le joueur combat.
 * @property nombreTours Le nombre de tours écoulés pendant le combat.
 */

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur

    /**
     * Simule le tour de combat du joueur. Le joueur peut attaquer, passer son tour, boire une potion ou consulter son inventaire.
     */
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
        println("Pour attaquer taper 1 sinon taper 2 taper 3 pour boire taper 4 pour inventaire")
        //TODO Mission 1.2
        var res = readln().toInt()
        if (res == 1) {
            this.jeu.joueur.attaque(monstre)
        }
        else if (res == 2) {
            println("Je passe mon tour ")
        }
        else if (res ==3){
            this.jeu.joueur.boirePotion()
        }
        else if (res == 4){
            this.jeu.joueur.afficheInv()
        }


        println("\u001b[0m")
}

    // Méthode pour simuler un tour de combat du monstre

    /**
     * Simule le tour de combat du monstre. Le monstre attaque le joueur avec une chance de 70%, sinon il passe son tour.
     */
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
        //TODO Mission 1.3
        if ((1.. 100).random() <= 70) {
            this.monstre.attaque(this.jeu.joueur)

        }
        else {
            println("Le monstre passe sont tour")

        }
        println("\u001b[0m")
    }


    /**
     * Exécute un combat complet entre le joueur et le monstre, en alternant les tours en fonction de la vitesse de chaque personnage.
     * Le combat continue jusqu'à ce que l'un des deux personnages soit vaincu.
     */
    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}