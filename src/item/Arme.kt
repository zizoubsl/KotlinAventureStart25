package item
import jeu.TirageDes


class Arme (nom:String, description: String, val typeArme: TypeArme, val qualite: Qualite ): Item(nom,description) {

    fun calculerDegats(): Int{

        var armeDegat = TirageDes(typeArme.nombreDes,typeArme.valeurDeMax).lance()
        var critiqueDegat = TirageDes(1,20).lance()
        if (critiqueDegat >= typeArme.activationCritque){
            println("coup critique")
            armeDegat = armeDegat * typeArme.multiplicateurCritque

        }
        armeDegat += qualite.bonusQualite
        return armeDegat





    }
}