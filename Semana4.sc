// SEMANA 4
// valores inmutables

// asignacion de valor
val cedula = "1108765432"
// no se puede reasignar valor a un val
cedula = "1108765432"

// Para que funcione es necesario volver a asignar al val
val cedula = "1108765431"

val cedula = "1108765321"
val cedula = "1109876320"
// el var permite reasignar un valor
var cedula = "1108765320"

// val valor
// var variable

// Higher Order Functions
// Una funcion que puede asignarse a un valor

// funcion
(x: Double) => -Math.pow(x,2)+8*x-12

// la asignamos a un valor
val f1 = (x: Double) => -Math.pow(x,2)+8*x-12
// de orden superior porque podemos asignarla a una variable

// invocacion
f1(12)

// tambien se puede utilizar sin asignarla a una variable
((x: Double) => -Math.pow(x,2)+8*x-12)(12)

val f1Val = f1(12)
f1(12) * 9 / 8 + 3
((x: Double) => -Math.pow(x,2)+8*x-12)(12) * 9 / 8 + 3

// Una funcion se envia como parametro

// parametros f(x): informacion que recibe: x, real
// que devuelve: valor numerico: real

// para definir
def integracion (a : Int, b : Int, f: Double => Double) = {

}

// ejemplo pizarra
// no pueden ser parametro de la funcion integracion porque:
// no reciben el mismo tipo y/o numero(s) de dato(s)
(x: String) => Int
(a: Char, b: String) => Double

def integracion (a : Int, b : Int, f: Double => Double) = {
  val intermedio = ((a+b)/2.0)
  val fa = f(a)
  val fi = f(intermedio)
  val fb = f(b)
  (b-a) * (fa + 4 * fi + fb) / 6
}

// ; es opcional

// Funcion que devuelve una funcion

def select (option: Char) : (Int, Int) => Double = {
  option match {
    case '+' => (a: Int, b: Int) => a + b
    case '-' => (a: Int, b: Int) => a - b
    case '*' => (a: Int, b: Int) => a * b
    case '/' => (a: Int, b: Int) => a / b.toDouble
    case _ => (a: Int, b: Int) => 0 / (a+b)
  }
}

// seleccionamos la opcion sumar: +
// devuelve la funcion segun nuestra seleccion de opcion
select('+')(2,1)
val operation = select('+')
operation(2,1)

// Obtener datos de secuencias
// Dada una lista de enteros [5, 6, 7, 8, 9] Cuantos son pares?

val isEven = (k: Int) => if (k % 2 == 0) 1 else 0

def isEven ( k: Int ) : Int = ( k % 2 )  match {
  case 0 => 1
  case _ => 0
}

// L -> Lista -> List[Int]

List(1, 2, 3)
List(1, 2, 3).sum

val lista = List(5,6,7,8,9)
lista.sum

List(1,2,3).map(x => x * x + 100 + x)
//res1: List[Int] = List(101,204,309)

def func1( x : Int) : Int = x * x + 100 * x
List(1, 2, 3).map(func1)
//res3: List[Int] = List(101, 204, 309)

val nums = List(1, 2, 3)
nums.map(x => x + 1)

def add1 (a: Int) : Int = a + 1
nums.map(add1)
nums.map(x => add1(x))
nums.map(add1(_))

val sumaDos = (a: Int, b: Int) => a + b
// cuando recive dos parametros, el lenguaje no
nums.map(x => sumaDos(x))
nums.map(sumaDos(_))

nums.map(x => sumaDos(x, x))

// guion no funciona cuando se necesitan dos parametros
nums.map(sumaDos(_, _))

nums map add1

def isEven( k : Int ) : Int = (k % 2) match {
  case 0 => 1
  case 1 => 0
}
def countEven( s : List [Int]) : Int = s.map( isEven ).sum

def countEven( s : List[Int] ) : Int = s.
  map(k => if (k % 2 == 0) 1 else 0).
  sum

def countEven(s: List[Int]) : Int = s.
  map(k => if (k % 2 == 0) 1 else 0).
  sum

def countEven ( s: List[Int] ) : Int = {
  def isEven(k: Int): Int = (k % 2) match {
    case 0 => 1
    case _ => 0
  }
  s.map( isEven ).sum
}

