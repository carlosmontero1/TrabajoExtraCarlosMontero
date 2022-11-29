// El problema de los efectos colaterales

// FP se basa en funciones que no deben tener efectos colaterales

// Ejemplo 1
int cont = 0;
void addOne () {
  cont = cont + 1; // efecto colateral
}

// No debemos cambiar el mundo exterior

// Ejemplo 2

// La funcion print("hola") imprimira algo y no devolvera nada
print("hola")

newState = print("hola") + oldState

// EFECTOS COLATERALES

// Se considera que una funcion tiene efectos colaterales si:

// Modifica el valor de una variable o de una estructura de datos mutable
// Utiliza mecanismos de IO
// Lanza una excepcion
// Se detiene por error

// SOLUCION

// La solucion es dejar de usar efectos colaterales y codificarlos en el valor de retorno

def division(n1: Double, n2: Double) =
  if (n2 == 0) throw new RuntimeException("Division por 0")
  else n1 / n2

division(4, 2)
division(7, 0)

// no es una funcion pura, devuelve Excepcion o Double

def division(n1: Double, n2: Double) =
  if (n2 == 0) throw new RuntimeException("Division por 0")
  else n1 / n2

import scala.util.Try

def pureDivision(n1: Double, n2: Double): Try[Double] =
  Try { division(n1, n2) }

// Siempre va a devolver un try tipo double

pureDivision(5, 2)
pureDivision(7, 0)


// Try [Double] Representa al error como una estructura de datos

val result = pureDivision(1, 3)
import scala.util.{Success, Failure}

result match {
  case Success(v) => println(v)
  case Failure(e) => println(e.getMessage)
}

// Option / Some / None

// Ejemplo java

/*

JAVA

String search(String id) {
  var students = List.of("1-Valencia", "2-Caicedo", "3-Galindez");
  for(var student: students) {
    if(student.startsWith(id)) {
      return student;
    }
  }
  return null;
}

search("1")
search("5")

String split(String student) {
  return student.split("-")[1]
}

split(search("1"))
split(search("6"))

*/

def toInt(s: String) : Option[Int] = {
  try{
    Some(Integer.parseInt(s))
  } catch {
    case e: Exception => None
  }
}
toInt("1")
toInt("Uno")
val txtNumbers = List("1", "2", "foo", "3", "bar")
txtNumbers.map(toInt)
txtNumbers.map(toInt).flatten

toInt("10")
toInt("hola")
val numbers = List("1", "2", "3", "bar")

numbers.map(toInt)
numbers.map(toInt).flatten

// Scala OPTION

// Manejo de nulos

def toInt(s: String) : Option[Int] = {
  try {
    Some(Integer.parseInt(s))
  } catch {
    case e: Exception => None
  }
}


import scala.util.control.Exception._

def toInt(s:String) : Option[Int] = allCatch.opt(s.toInt)

// Usar getOrElse, foreach, match

val x = toInt("1").getOrElse(0)

toInt("1").foreach{ i => printf("Obtener un Int:%d", i) }

toInt("1") match {
  case Some(i) => println(i)
  case None => println("That didn't work.")
}

// EITHER / LEFT / RIGHT

def divideXByY(x:Int, y:Int): Either[String, Int] =
  if(y==0) Left("No se puede dividir por 0")
  else Right( x / y )

val x = divideXByY(1, 1).right.getOrElse(0)
val x = divideXByY(1, 0).right.getOrElse(0)

divideXByY(1, 0) match {
  case Left(s) => println("Answer: " + s)
  case Right(i) => println("Answer: " + i)
}

val x = divideXByY(1, 0)
x.isLeft
x.left

// Recomendacion usar: TRY SUCCESS FAILURE
