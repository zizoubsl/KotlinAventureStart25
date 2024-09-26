package item

import personnage.Personnage

class Potion(val soin: Int, nom: String, description: String): Item(nom,description) {



   override fun utiliser(cible: Personnage){

    }
}