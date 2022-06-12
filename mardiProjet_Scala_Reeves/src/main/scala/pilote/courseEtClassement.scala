package pilote

class courseEtClassement() {

//  // Map pour lier la course et le classement
//  var courseClassementAA = scala.collection.immutable.Map[String, Int]()
//  var courseClassementBB = scala.collection.immutable.Map[String, Int]()
//  var courseClassementCC = scala.collection.immutable.Map[String, Int]()


  // Map pour lier un pilote et son Map "courseClassement"
  var piloteCourseClassement = scala.collection.mutable.Map[String, Map[String,Int]]()

  //POPULATE MAP

  //Pilote AA
  piloteCourseClassement += ("AA" -> courseClassementAA)
  val courseClassementAA:Map[String,Int] = Map("Course 1" -> 1, "Course 2" -> 3 , "Course 3" -> 1)

  //Pilote BB
  piloteCourseClassement += ("BB" -> courseClassementBB)
  val courseClassementBB:Map[String,Int] = Map("Course 1" -> 3, "Course 2" -> 2 , "Course 3" -> 2)

  //Pilote CC
  piloteCourseClassement += ("CC" -> courseClassementCC)
  val courseClassementCC:Map[String,Int] = Map("Course 1" -> 2, "Course 2" -> 1 , "Course 3" -> 3)

  def returnMap(nom:String): Map[String,Int] = {
    piloteCourseClassement(nom)
  }


}
