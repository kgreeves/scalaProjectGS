object tempMain{

        def tempMain(args:Array[String]):Unit={

        val testList=MyList(1,2,3,4,5)
        val testList2=MyList(6,7,8,9,10)

        println("head : "+MyList.head(testList2))
        println("tail : "+MyList.tail(testList2))

        println("length : "+MyList.length(testList))

        val value=100;
        println("\nOriginal List : "+testList)
        println("Set Head with "+value+" : "+MyList.setHead(testList,value))

        println(MyList.setHead(testList,100))

        val n=2;
        println("Drop element '"+n+"' : "+MyList.drop(testList,3))

        //val testListDouble:MyList.MyList[Double] = MyList.MyList(2.0,2.0,3.5,5.5)


        //println(MyList.MyList.sum(testList))
        //println(MyList.MyList.product(testListDouble))

        println("a1 : "+testList)
        println("a2 : "+testList2+"\n")

        val appendedList=MyList.append(testList,testList2)

        println("MyList.append(testList,testList2) : "+appendedList)
        }


        }
