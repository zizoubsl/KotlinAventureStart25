package personnage

import item.Arme
import item.Armure
import item.Bombe
import item.Item
import item.Potion
import kotlin.math.max

/**
 * Représente un personnage dans le jeu avec des attributs comme points de vie, attaque, défense, etc.
 *
 * @property nom Le nom du personnage.
 * @property pointDeVie Les points de vie actuels du personnage.
 * @property pointDeVieMax Les points de vie maximum que le personnage peut avoir.
 * @property attaque Le niveau d'attaque du personnage.
 * @property defense Le niveau de défense du personnage.
 * @property endurance Le niveau d'endurance du personnage.
 * @property vitesse La vitesse du personnage.
 * @property armureP L'armure actuellement équipée par le personnage, si disponible.
 * @property ArmeP L'arme actuellement équipée par le personnage, si disponible.
 * @property inventaire La liste des objets que possède le personnage (armes, armures, potions, etc.).
 */


open class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armureP: Armure?=null,
    var ArmeP: Arme?=null,
    var inventaire: MutableList<Item> =mutableListOf(),
) {
    /**
     * Équipe une arme du personnage si elle est présente dans l'inventaire.
     *
     * @param arme L'arme à équiper.
     */
    fun equipeArme(arme: Arme){
        for (item in inventaire){
            if (item == arme){
                this.ArmeP = arme
                println("${this.nom} equipe ${this.ArmeP?.nom}")            }
        }
    }

    /**
     * Calcule la défense totale du personnage, prenant en compte l'armure équipée.
     *
     * @return La défense totale du personnage.
     */
     fun calculeDefense():Int{
         //TODO Mission 4.2
         fun calculTotDef(): Int{
             var res = this.defense/2
             if(this.armureP !=null){
                 res += this.armureP !!.calculProtection()
             }
             return res
         }
        return this.defense/2;
     }
    /**
     * Équipe une armure du personnage si elle est présente dans l'inventaire.
     *
     * @param armure L'armure à équiper.
     */
    fun equipeArmure(armure: Armure){
        for (item in inventaire){
            if (item == armure){
                this.armureP = armure
                println("${this.nom} equipe ${this.armureP?.nom}")
            }
        }
    }
    /**
     * Attaque un autre personnage et inflige des dégâts en fonction de l'attaque et de l'arme du personnage.
     *
     * @param adversaire Le personnage à attaquer.
     */
     // Méthode pour attaquer un adversaire
     open fun attaque(adversaire: Personnage) {
         //TODO Mission 4.1
         var degats = this.attaque / 2
         if (ArmeP != null) {
             degats += ArmeP!!.calculerDegats()
             println("$nom attaque ${adversaire.nom} avec une $ArmeP et met $degats points de dégâts.")

         } else {
             println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")


         }
         degats -= adversaire.calculeDefense()
         degats = max(1,degats)
         adversaire.pointDeVie -= degats
     }

    /**
     * Vérifie si le personnage possède une potion dans son inventaire.
     *
     * @return `true` si une potion est présente, sinon `false`.
     */

    fun avoirPotion(): Boolean {
        for (item in this.inventaire) {
            if (item is Potion) {
                return true
            }
        }
        return false
    }

    /**
     * Vérifie si le personnage possède une bombe spécifique dans son inventaire.
     *
     * @param bombe La bombe à vérifier.
     * @return `true` si la bombe est présente, sinon `false`.
     */

    fun avoirBombe(bombe: Bombe): Boolean {
        for (item in this.inventaire) {
            if (item is Bombe) {
                return true
            }
        }
        return false
    }

    /**
     * Permet au personnage de boire une potion depuis son inventaire.
     * Affiche la liste des potions disponibles et permet de choisir laquelle utiliser.
     */


    fun boirePotion(){
        if (avoirPotion()){
            var potion: MutableList<Potion> = mutableListOf()
            for (item in this.inventaire){
                if (item is Potion)
                potion.add(item)
            }
            println("la liste des potions")
            var i = 0
            for (laPotion in potion){
                println("$i => ${laPotion.nom}")
            }
            println("la potion :")
            var popoIndexes = readln().toInt()
            var cettePotion =potion[popoIndexes]
            cettePotion.utiliser(this)
        }


    }
    /**
     * Affiche l'inventaire du personnage avec une liste d'indices.
     */
    fun afficheInv(){
        println("inventaire de ${this.nom}")
        for (i in inventaire.indices){
            println("$i => ${inventaire[i]}")
        }
    }

    /**
     * Permet au personnage de looter un autre personnage si ce dernier a été vaincu.
     * Retire les armes et armures du personnage vaincu.
     *
     * @param cible Le personnage vaincu à looter.
     */

    fun loot(cible: Personnage){
        if (cible.pointDeVie <=0 ){
            cible.ArmeP = null
            cible.armureP = null
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du personnage, incluant son nom, points de vie, attaque, défense, etc.
     *
     * @return Une chaîne décrivant le personnage.
     */



    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}