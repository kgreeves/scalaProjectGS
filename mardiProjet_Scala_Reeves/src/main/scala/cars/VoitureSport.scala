package cars

case class VoitureSport(vitesse:Double, nom:String, acceleration:Double, moteur:String, prix:Double, nombreDeCourse:Int, marque:String)
  extends Voiture {

  val nomCar = nom
  val vitesseCar = vitesse

}
