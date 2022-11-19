// Problema
// Resolucion de prueba parcial

// lista
val nros = List(727.7, 1086.5, 1091.0, 1361.3, 1490.5, 1956.1)

// promedio, recibe una lista de tipo Double
def promedio(valores: List[Double]): Double = valores.sum / valores.size

// calculo de promedio de la lista nros
promedio(nros)

// funcion de desviacion estandar
def desvEst(valores: List[Double]): Double = {
  def avg = (promedio(valores))

  def varianza(valores: List[Double]): Double =
    valores.map(x => Math.pow(x - avg, 2)).sum * (1.0 / (valores.size - 1))

  Math.sqrt(varianza(valores))
}

// calculo desciacion estandar de la lista nros
desvEst(nros)

def clasifica(valores: List[Double]): Unit = {
  val s = desvEst(valores)
  val avg = promedio(valores)

  (1 to 3).foreach(i =>
    println(valores.filter(x =>
      x >= (avg - i * s) && x <= (avg + i * s)).size))
}

clasifica(nros)

// Tuplas
// Juntar varios datos para que sean tratados como unica estructura de datos
// 1 hasta 22 elementos
// Contenedor de datos en donde cada elemento puede ser de diferente tipo

val par = (1, "Abad Ana")

// Se accede a cada elemento utilizando punto, guion bajo y un indice

println(par._1)
println(par._2)

val student = (1, "Abad Ana")
val datos = ("jorgaf", 'M', 45, 95.2, true)

// El tipo depende del numero de elementos y el tipo de dato de cada uno

val student: Tuple2[Int, String]
val datos: Tuple5[String, Char, Int, Double, Boolean]

print(datos)

val student = (1, "Abad Ana")
val (edad, nombre) = student
print(edad)
print(nombre)

// swap orden
student.swap

// see if it is equal
student.canEqual((1, "Abad Ana"))

// Estructuras de datos funcionales

// La programacion implica principalmente la manipulacion de datos

// Tanto las estructuras de datos, como los datos en si son manipulados
// de forma diferente en los paradigmas de programacion

// Nocion con la nocion de una coleccion de datos

// Conjunto listado con valores unicos
// Secuencias Listado con valores
// Mapas Listado de pares (Key/Value)

// Listas

// Son inmutables, representan lista enlazada

val values = List(42, 31, 36, 40, 43)
val names = List("Jorge", "Rene", "Ma. del Carmen", "Nelson")

val fruit: List[String] = List("apple", "orange", "pears")
def numes: List[Int] = List(1, 2, 3, 4)

val myList = List(10, 20, 30, 40, 50, 60)
myList.isEmpty
myList.drop(2)
myList.dropWhile(_ < 25)
myList.slice(2, 4)
myList.tail
myList.take(3)
myList.takeWhile(_ < 30)
myList.sorted
myList.sorted(Ordering.Int.reverse)

// fold left

// aplica un operador binario a un valor inicial y a todos los elementos
// de esta secuencia de izquierda a derecha

myList.foldLeft(0)((x, y) => x + y)
myList.foldLeft(0)(_ + _)

// fold right

// aplica un operador binario a todos los elementos de esta lista
// y un valor inicial, de derecha a izquierda

myList.foldRight(0)((x, y) => x + y)
myList.foldRight(0)(_ + _)

def average(valores: Seq[Double]): Double = {
  val t = valores.foldLeft((0.0, 0))((acc, currVal) => (acc._1 + currVal, acc._2 + 1))
  t._1 / t._2
}

def average2(valores: Seq[Double]) : Double = {
  val t = valores.foldLeft((0.0, 0)) { (acc, currVal) =>
    val sum = acc._1 + currVal
    val cont = acc._2 + 1
    printf("suma: %f - contador: %d%n", sum, cont)
    (sum, cont)
  }
  t._1 / t._2
}

average(nros)
average2(nros)

// zip
val myList = List(10, 20, 30, 40, 50, 60)
val names = List("Guido", "Armando", "Patricio", "Manuel", "Germania", "Fanny")
names.zip(myList)

// unzip

val zippedList : List[(String, Int)] =
  List(("Guido",10), ("Armando",20), ("Patricio",30), ("Manuel",40), ("Germania",50), ("Fanny",60))

val unzippedLists : (List[String], List[Int]) = zippedList.unzip

unzippedLists._1
unzippedLists._2

val goleadores = List(
  ("Oscar Becerra", 17),
  ("Luis amarilla", 16),
  ("Michael Estrada", 16),
  ("Fidel Martinez", 16),
  ("Gonzalo Mastriani", 13),
  ("Leonel Vides", 13),
  ("Rodrigo Aguirre", 12 ),
  ("Carlos Garces", 12),
  ("Jonathan Borja", 11)
)

