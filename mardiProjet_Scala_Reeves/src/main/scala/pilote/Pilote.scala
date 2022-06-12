package pilote

import sun.font.TrueTypeFont

class Pilote(classement:Map[String,Int],nom:String, prenom:String, age:Int, voiture:String, experience:Int){

  val agePilot = age
  val nomPilot = nom
  val prenomPilote = prenom

  def dejaChampion(): Boolean = {
    classement.values.toSeq.contains(1)
  }
  def nombreDeVictoire() : Int = {
    classement.values.toSeq.count(_ == 1)
  }

  def enPodium() : Int = {
    classement.values.toSeq.count(_ <= 3)
  }

  def totalDesGain() : Double = {

    val gains:Map[Int,Double] = Map(1 -> 5000.00, 2 -> 2500.00, 3->1000.00)
    var gainSum:Double = 0.0

    var pos = 0;
    for( pos <- 1 to 3){
      gainSum += gains(pos)*classement.values.toSeq.count(_ == pos)
    }
    gainSum
  }

  def validAge() = {
    if (age < 18) throw new Exception("Too young!")
  }
}
