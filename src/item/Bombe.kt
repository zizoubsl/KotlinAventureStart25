package item
import jeu.TirageDes
import personnage.Personnage

class Bombe(val nombreDes: Int, val maxDes: Int, nom: String, description: String, val armure: Armure ): Item(nom,description) {



    override fun utiliser(cible: Personnage){
        var bombeDegat = TirageDes(3,8).lance()
        var resultatBombe = bombeDegat - armure.calculProtection()
        if (resultatBombe<1){
            resultatBombe = 1
        }
        cible.pointDeVie -=resultatBombe
        print("La $cible prend $resultatBombe de dégâts")


    }


}