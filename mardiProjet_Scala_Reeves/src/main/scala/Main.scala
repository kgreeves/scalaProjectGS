import MyList.MyList
import cars._
import pilote._
import MyList._

import scala.util.{Failure, Success, Try}

object Main {

  def main(args:Array[String]):Unit= {

    //Classic,Sport,SuperSport de Voiture parent
    val carClassic = new VoitureClassic(10, "classic", 3, "oui", 89000, 6, "AAA")
    val carSport = new VoitureSport(15, "sport", 5, "oui", 105000, 8, "BBB")
    val carSuperSport = new VoitureSuperSport(18, "super sport", 8, "oui", 125000, 15, "CCC")

    val carList:List[Voiture] = List(carClassic,carSport,carSuperSport)

    carList.foreach( s => println( s.showStats() ) )

    val piloteClassementMapAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)
    val piloteClassementMapBB:Map[String,Int] = Map("Course 1" -> 3, "Course 2" -> 2 , "Course 3" -> 2)
    val piloteClassementMapCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 3)


    // Instancier Pilotes A,B,and C
    val pilotA = new Pilote(piloteClassementMapAA, "AA","Aa",35,"SuperSport",8);
    val pilotB = new Pilote(piloteClassementMapBB,"BB","Bb",25,"Classic",3);
    val pilotC = new Pilote(piloteClassementMapCC,"CC","Cc",47,"Sport",18);

    println("Pilote A déjà champion : " + pilotA.dejaChampion() + ", " + pilotA.nombreDeVictoire() + " fois. Total gains : " + pilotA.totalDesGain() + "." )
    println("Pilote B déjà champion : " + pilotB.dejaChampion() + ", " + pilotB.nombreDeVictoire() + " fois. Total gains : " + pilotB.totalDesGain() + "." )
    println("Pilote C déjà champion : " + pilotC.dejaChampion() + ", " + pilotC.nombreDeVictoire() + " fois. Total gains : " + pilotC.totalDesGain() + ".\n" )


    // Générer la liste de pilotes
    val pilotList = new ListPilotes(MyList(pilotA,pilotB,pilotC))



    //TEST MyList Methods
//    val testList=MyList(1,2,3,4,5,19)
//    val testList2=MyList(6,7,8,9,10)
//
//    print(sum(testList))
//
//    println("head : "+MyList.head(testList2))
//    println("tail : "+MyList.tail(testList2))
//
//
//    println("length : "+MyList.length(testList))
//    println("random element : "+MyList.getRandom(testList))
//
//    val el:Int = 3
//    println("Element " + el + " of testList is : " + MyList.get(el,testList))
//
//    println(testList)
//    println("Drop While x  % 2 != 0 : " + MyList.dropWhile(testList,(x:Int)=>(x%2!=0)))
//    println("Filter While x  % 2 != 0 : " + MyList.filter(testList,(x:Int)=>(x%2!=0)))




    //EXCEPTIONS
    //InvalidAgeException
    println("Test Age of Pilot\n==================")

    val pilotD = new Pilote(piloteClassementMapCC,"CCCCC","Ccccc",15,"Sport",18);
    ////Method 1
    //pilotD.validAge()

    ////Method 2
    def validateAge(pilot:Pilote): Try[Boolean] = {
      Try(pilot.agePilot >= 18)
    }
    validateAge(pilotD) match {
      case Success(true)  => println("Age OK")
      case Success(false) => println(pilotD.prenomPilote + " " + pilotD.nomPilot +
        " est trop jeune ! Il/elle n'a que " + pilotD.agePilot +" ans !")
    }

    //SpeedRangeException
    println("\nTest Speed Range of Cars\n==================")

    def validateCarSpeed[A](car:A): Try[Boolean] = car match {
      case car:VoitureClassic => Try( (car.vitesse < 260) && (car.vitesse > 0))
      case car:VoitureSport => Try( (car.vitesse < 330) && (car.vitesse > 0))
      case car:VoitureSuperSport => Try( (car.vitesse < 400) && (car.vitesse > 0))
    }

    val carClassicA = new VoitureClassic(265, "classic", 3, "oui", 89000, 6, "AAA")
    val carSportA = new VoitureSport(300, "sport", 3, "oui", 105000, 8, "BBB")
    val carSuperSportA = new VoitureSuperSport(100, "super sport", 3, "oui", 135000, 15, "CCC")

    validateCarSpeed(carClassicA) match {
      case Success(true) => println(s"Speed of the ${carClassicA.nomCar} car (${carClassicA.vitesse}km/h) is OK.")
      case Success(false) => println(s"The speed of the ${carClassicA.nomCar} car (${carClassicA.vitesse}km/h) car exceeds the allowed maximum !")
    }

    validateCarSpeed(carSportA) match {
      case Success(true) => println(s"Speed of the ${carSportA.nomCar} car (${carSportA.vitesse}km/h) is OK.")
      case Success(false) => println(s"The speed of the ${carSportA.nomCar} car (${carSportA.vitesse}km/h) car exceeds the allowed maximum !")
    }

    validateCarSpeed(carSuperSportA) match {
      case Success(true) => println(s"Speed of the ${carSuperSportA.nomCar} car (${carSuperSportA.vitesse}km/h) is OK.")
      case Success(false) => println(s"The speed of the ${carSuperSportA.nomCar} car (${carSuperSportA.vitesse}km/h) car exceeds the allowed maximum !")
    }



  }


}