package item

import personnage.Personnage

class Potion(val soin: Int, nom: String, description: String): Item(nom,description) {



   override fun utiliser(cible: Personnage){
       cible.pointDeVie += soin
       if (cible.pointDeVie>cible.pointDeVieMax){
           cible.pointDeVie= cible.pointDeVieMax
       }

    }
}