package pilote
import org.scalatest._
import org.scalatest.funspec.AnyFunSpec
import  org.scalatest.matchers.should.Matchers

class PiloteTest extends AnyFunSpec with Matchers {

  describe("Statistiques du pilote"){

    it("should determine if the pilote has already won before.") {
      //GIVEN
      val piloteClassementMapAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)
      val piloteClassementMapBB:Map[String,Int] = Map("Course 1" -> 3, "Course 2" -> 2 , "Course 3" -> 2)
      val piloteClassementMapCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 5)

      val pilotA = new Pilote(piloteClassementMapAA, "AA","Aa",35,"SuperSport",8);
      val pilotB = new Pilote(piloteClassementMapBB,"BB","Bb",25,"Classic",3);
      val pilotC = new Pilote(piloteClassementMapCC,"CC","Cc",47,"Sport",18);

      //WHEN
      val resultA = pilotA.dejaChampion()
      val resultB = pilotB.dejaChampion()
      val resultC = pilotC.dejaChampion()

      //THEN
      resultA.shouldBe(true)
      resultB.shouldBe(false)
      resultC.shouldBe(true)
    }

    it("should give the number of victories (first place only)") {
      //GIVEN
      val piloteClassementMapAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)
      val piloteClassementMapBB:Map[String,Int] = Map("Course 1" -> 3, "Course 2" -> 2 , "Course 3" -> 2)
      val piloteClassementMapCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 5)

      val pilotA = new Pilote(piloteClassementMapAA, "AA","Aa",35,"SuperSport",8);
      val pilotB = new Pilote(piloteClassementMapBB,"BB","Bb",25,"Classic",3);
      val pilotC = new Pilote(piloteClassementMapCC,"CC","Cc",47,"Sport",18);

      //WHEN
      val resultA = pilotA.nombreDeVictoire()
      val resultB = pilotB.nombreDeVictoire()
      val resultC = pilotC.nombreDeVictoire()

      //THEN
      resultA.shouldBe(2)
      resultB.shouldBe(0)
      resultC.shouldBe(1)
    }

    it("should give the number of times on the podium (1,2 or 3)") {
      //GIVEN
      val piloteClassementMapAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)
      val piloteClassementMapBB:Map[String,Int] = Map("Course 1" -> 6, "Course 2" -> 4 , "Course 3" -> 2)
      val piloteClassementMapCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 5)

      val pilotA = new Pilote(piloteClassementMapAA, "AA","Aa",35,"SuperSport",8);
      val pilotB = new Pilote(piloteClassementMapBB,"BB","Bb",25,"Classic",3);
      val pilotC = new Pilote(piloteClassementMapCC,"CC","Cc",47,"Sport",18);

      //WHEN
      val resultA = pilotA.enPodium()
      val resultB = pilotB.enPodium()
      val resultC = pilotC.enPodium()

      //THEN
      resultA.shouldBe(3)
      resultB.shouldBe(1)
      resultC.shouldBe(2)
    }

    it("should give provide the total money won") {
      //GIVEN
      val piloteClassementMapAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)
      val piloteClassementMapBB:Map[String,Int] = Map("Course 1" -> 6, "Course 2" -> 4 , "Course 3" -> 2)
      val piloteClassementMapCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 5)

      val pilotA = new Pilote(piloteClassementMapAA, "AA","Aa",35,"SuperSport",8);
      val pilotB = new Pilote(piloteClassementMapBB,"BB","Bb",25,"Classic",3);
      val pilotC = new Pilote(piloteClassementMapCC,"CC","Cc",47,"Sport",18);

      //WHEN
      //First Prize = 5000, Second Prize = 2500, Third Prize = 1000
      val resultA = pilotA.totalDesGain()
      val resultB = pilotB.totalDesGain()
      val resultC = pilotC.totalDesGain()

      //THEN
      resultA.shouldBe(11000)
      resultB.shouldBe(2500)
      resultC.shouldBe(7500)
    }

  }

}
