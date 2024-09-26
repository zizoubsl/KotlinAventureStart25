package item
import personnage.Personnage

import jdk.jfr.Description

class Armure (nom: String, description: String,val typeArmure: TypeArmure ,val qualite: Qualite): Item(nom,description){

    fun calculProtection(): Int{
      val totalProtection = this.qualite.bonusQualite + this.typeArmure.bonusTypeArmure
        return totalProtection
    }
   override fun utiliser(cible: Personnage){

    }


}