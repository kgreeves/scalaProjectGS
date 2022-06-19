package pilote
import MyList.MyList


import scala.annotation.tailrec

class ListPilotes (listePilotes:MyList[Pilote]) {

  var pilotList:MyList[Pilote] = listePilotes;

  def ajouterPilot(nouveauPilote: Pilote): Unit = {
    pilotList = MyList.append(pilotList,MyList(nouveauPilote))
  }

  def filtreParVoiture(voiture:String): MyList[Pilote] = {
    val listFiltre:MyList[Pilote] = MyList.filter(pilotList,(x:Pilote)=>x.voiturePilote.equals(voiture))
    println("Les pilotes avec une voiture '" + voiture + "' sont : ")
    MyList.echoListeFiltre(listFiltre)
    listFiltre
  }


 // def supprimerPilot(listPilotes: ListPilotes: MyList.MyList[A]): MyList.MyList[A] = {}

}
