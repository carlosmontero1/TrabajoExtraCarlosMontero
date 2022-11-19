def isEven(k: Int): Int = (k % 2) match {
  case 0 => 1
  case _ => 0
}

def countEven(s: List[Int]): Int = s.map(isEven).sum

def countEven(s: List[Int]): Int = {
  def isEven(k: Int): Int = (k % 2) match {
    case 0 => 1
    case _ => 0
  }

  s.map(isEven).sum
}

def countEven(s: List[Int]): Int = {
  val isEven = (k: Int) => k % 2 match {
    case 0 => 1
    case _ => 0
  }
  s.map(isEven).sum
}

// mapear una lista de cadenas de texto a lista de enteros que representan la longitud del texto

val names: List[String] = List("Leo", "Cristiano", "Enner", "Felipe")

names.map(_.length)

// mal codigo
// names.map(length)

// Dada una lista de numeros enteros, desarrollar las funciones necesarias que le permitan contar
// cuantos elementos de la lista son numeros primos

val numbers = List(3, 4, 7, 11, 12)

val isPrime = (nro: Int) => (2 to nro - 1).forall(nro % _ != 0)
numbers.map(isPrime(_) match {
  case true => 1
  case false => 0
}).sum

// Dada una lista de numeros enteros, desarrollar

// Filtrar y truncar secuencias
// Otras operaciones

// sum
// product
// map
// forall

// max
// min
// size
// exists
// filter
// takeWhile

val numbers = List(6, 28, 15, 12, 11, 24)
numbers.max
//res26: Int = 28
numbers.min
//res27: Int = 6
numbers.size
//res28: Int = 6

// exists, filter, takeWhile se le envia un predicado

// forall -> devuelve true si y solo si el predicado devuelve true para todos los valores de la lista
def isPrime(nro: Int): Boolean = (2 until nro).forall(nro % _ != 0)
// to incluye segundo numero, until no incluye

// exists -> devuelve true si y solo si el predicado devuelve true para por lo mneos un valor de la lista
def isPrime(nro: Int): Boolean = !(2 until nro).exists(nro % _ == 0)

// filter -> devuelve una lista que unicamente contiene los valores que cumplen con el predicado
List(1, 2, 3, 4, 5).filter(k => k % 3 != 0)
// res: List[Int] = List(1, 2, 4, 5)

// takeWhile -> trunca la lista cuando encuentra un valor que no cumple con el predicado
List(1, 2, 3, 4, 5).takeWhile(k => k % 3 != 0)

// map/reduce
// transformar, una funcion toma una lista y devuelve otra
// funiones: map, filter, etc...
// agregar, toma una lista y devuelve un unico valor
// funciones: max, sum, etc...
// Escribir programas que concatenan transformaciones y agregaciones se conocen como programacion map/reduce

val divP = (n: Int) => (1 until n).filter(div => n % div == 0)
divP(6)

val sumDiv = (n: Int) => (1 until n).filter(div => n % div == 0).sum

val numbers = List(6, 28, 15, 12, 11, 24)
val sumDiv = (nro: Int) => (1 until nro).filter(div => nro % div == 0).sum

//perfecto
numbers.filter(nro => nro == sumDiv(nro))
// deficiente
numbers.filter(nro => nro > sumDiv(nro))
// abundante
numbers.filter(nro => nro < sumDiv(nro))

val numP = numbers.filter(nro => nro == sumDiv(nro)).size
val numD = numbers.filter(nro => nro > sumDiv(nro)).size
val numA = numbers.filter(nro => nro < sumDiv(nro)).size

// ejercicio 1

def !!(n: Int): Int = {
  n % 2 match {
    case 0 => (2 to n by 2).product
    case _ => (1 to n by 2).product
  }
}

!!(8)
!!(9)

val numbers = (1 to 20).toList

// Contar Pares

numbers.filter(nro => nro % 2 == 0).size
numbers.count(nro => nro % 2 == 0)

// Contar impares
numbers.filter(nro => nro % 2 != 0).size
numbers.count(nro => nro % 2 != 0)

// Contar primos
def contarPrimos(nros: List[Int]): Int = {
  val isPrime = (n: Int) => (2 until n).forall(n % _ != 0)
  //nros.filter(isPrime).size
  //nros.count(isPrime(_))
  nros.count(n => isPrime(n))
}

contarPrimos(numbers)

// Presentar 3 factores

def tresFactores(nros: List[Int]): List[Int] = {
  val factores = (n: Int) => (2 until n).filter(n % _ == 0)
  nros.filter(nro => factores(nro).size == 3)
}

tresFactores((1 to 1000).toList)
