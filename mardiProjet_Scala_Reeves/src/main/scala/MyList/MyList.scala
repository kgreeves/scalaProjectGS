package MyList
import scala.annotation.tailrec


sealed trait MyList[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends MyList[Nothing] // A `List` data constructor representing the empty list
/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `MyList.Nil` or another `MyList.Cons`.
 */
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList { // `List` companion object. Contains functions for creating and working with lists.


  def sum(ints: MyList[Int]): Int = {
    @tailrec
        //Auxiliary Function
        def addRec( ints: MyList[Int], accumulator : Int): Int = {
            ints match {
            case Nil => accumulator
            case  Cons(x,tail) => addRec(tail, accumulator + x )
            }
        }
          addRec(ints,0)     //Call Auxiliary Function with Accumulator initialized to 0.
  }

  def product(ds: MyList[Double]): Double = {
    @tailrec
    //Auxiliary Function
    def productRec( ds: MyList[Double], accumulator : Double): Double = {
      ds match {
        case Nil => accumulator
        case Cons(x, tail) => productRec(tail, accumulator * x)
      }
    }
    productRec(ds,1)     //Call Auxiliary Function with Accumulator initialized to 1.
  }

  def apply[A](as: A*): MyList[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def append[A](a1: MyList[A], a2: MyList[A]): MyList[A] = {

    @tailrec
    //Auxiliary Function
    def appendRec( a2: MyList[A], tempList : MyList[A]): MyList[A] = {
      a2 match {
        //case MyList.Nil => tempList
        case Nil => tempList
        case Cons(x, tail) => appendRec(tail, Cons(x,tempList)) // Mauvais ordre
      }
    }
    appendRec(a1,a2)

         }

         // Bonus should throw exception
  //



  def tail[A](l: MyList[A]): MyList[A] = l match {
        case Cons(x,tail) => tail
      }

  def head[A](l: MyList[A]): A = l match {
      case Cons(x,tail) => x
    }

  def setHead[A](l: MyList[A], h: A): MyList[A] = l match {
    case Cons(x,tail) => Cons(h,tail)
  }

  def drop[A](l: MyList[A], n: Int): MyList[A] = {

    var i = 0;
      //@tailrec
      def dropRec(l: MyList[A], accumulator: MyList[A]): MyList[A] = l match {
        case Nil => accumulator;
        case Cons(x,tail) => {
          i+=1
          if ( i != n ) Cons(x,dropRec(tail,accumulator))
          else accumulator
        }
      }
    dropRec(l,Nil)

  }

  def dropWhile[A](l: MyList[A], f: A => Boolean): MyList[A] = {
           if ( f(head(l)) == false )  l
           else dropWhile(tail(l),f)
         }

  def filter[A](l: MyList[A], f: A => Boolean): MyList[A] = {

    var tempListe:MyList[A] = MyList()

    def auxFunc(l: MyList[A], f: A => Boolean, pt:Int, tempListe:MyList[A],longeur:Int): MyList[A] =  {


        if ((f(head(l)) == true) && (pt < longeur)) {
          println(head(l))
          println(tempListe)
          println(pt.toString + "/" + longeur)
          //println(tempListe2)
          auxFunc(tail(l), f, pt+1, Cons(head(l),tempListe), longeur)
        }
        else if (!f(head(l)) && (pt < length(l))) {
          println(head(l))
          println(tempListe)
          println(pt.toString + "/" + longeur)
          auxFunc(tail(l), f, pt+1, tempListe, longeur)
        }

      tempListe
    }
    auxFunc(l,f,0,MyList(),length(l))

  }

         def init[A](l: MyList[A]): MyList[A] = ???

         def length[A](l: MyList[A]): Int = {
           @tailrec
           def countElements( l: MyList[A], accumulator:Int): Int = {
               l match {
               case Nil => accumulator
               case Cons(x,tail) => countElements(tail,accumulator+1)
             }
           }
           countElements(l,0)
         }

         def reverse[A](l: MyList[A]): MyList[A] = ???

  def getRandom[A](l: MyList[A]): A = {
    val randomNumber = scala.util.Random
    get(randomNumber.nextInt(length(l)),l)
  }

  def get[A](n: Int, ls: MyList[A]): A  = {
    if ( n <= 1) head(ls)
    else get(n-1,tail(ls))
  }



}
