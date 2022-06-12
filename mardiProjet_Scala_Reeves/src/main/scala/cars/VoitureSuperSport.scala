package cars

case class VoitureSuperSport(vitesse:Double, nom:String, acceleration:Double, moteur:String, prix:Double, nombreDeCourse:Int, marque:String)
  extends Voiture {

  val nomCar = nom
  val vitesseCar = vitesse

}
