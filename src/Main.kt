import item.Arme
import item.Armure
import item.Bombe
import item.Qualite
import item.TypeArme
import item.TypeArmure
import jeu.Jeu
import personnage.Personnage
/**
 * Programme principal pour la gestion des objets, personnages et le lancement du jeu.
 */

//Créattion des qualités des objets
// Création des qualités des objets
/** Qualité d'objet commun avec une couleur verte. */
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures

//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    /**
     * Création des objets de type Arme.
     */
    val BloodSword = Arme("Epée de sang","Epée qui provoque du saignement", TypeArme("BloodSword",2,5,8,9),qualiteLegendaire)
    val gant = Arme("Epée de sang","Epée qui provoque du saignement", TypeArme("gant",2,5,8,9),qualiteCommun)
    val Hache = Arme("Epée de sang","Epée qui provoque du saignement", TypeArme("gant",2,5,8,9),qualiteCommun)
    val BatonMage = Arme("Epée de sang","Epée qui provoque du saignement", TypeArme("gant",2,5,8,9),qualiteCommun)

    /**
     * Création d'un objet de type Armure.
     */
    val DiamantARm = Armure("Armure en diamant","Une armure qui te protege", TypeArmure("Diamant",15),qualiteLegendaire)
    /**
     * Création d'un objet de type Bombe.
     */
    val BOOMBOT = Bombe(8,8,"KABOOM","UNE DENSE EXPLOSION",DiamantARm)
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )

    /**
     * Création des personnages (monstres).
     */
    //Création des monstres
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        inventaire = mutableListOf(gant))

    // TODO Intermission 1 : Ajouter d'autres monstres
    val Freezer = Personnage(
        "Freezer",
        pointDeVie = 30,
        pointDeVieMax = 35,
        attaque = 10,
        defense = 15,
        vitesse = 13,
        endurance = 9,
        inventaire = mutableListOf(Hache)
        )

    val HOLLOW = Personnage(
        "Hollow",
        pointDeVie = 30,
        pointDeVieMax = 35,
        attaque = 10,
        defense = 15,
        vitesse = 13,
        endurance = 9,
        inventaire = mutableListOf(BatonMage))





    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin))
    //Lancement du jeu
    jeu.lancerCombat()
}