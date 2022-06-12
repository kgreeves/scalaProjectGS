package cars

abstract class Voiture{

  val vitesse:Double
  val nom:String
  val acceleration:Double
  val moteur:String
  val prix:Double
  val nombreDeCourse:Int
  val marque:String

  def showStats (): String = {
    "Nom : " + nom +
      "\nVitesse : " + vitesse +
      "\nPrix : " + prix + "\n"

  }
}
