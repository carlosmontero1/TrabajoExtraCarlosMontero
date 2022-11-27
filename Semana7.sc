// Tuplas y Listas

// Tupla maxima de 22
// Forma practica de representar los datos

val goleadores = List(
  ("Francisco Fydriszewski", 10),
  ("Joaquin Verges", 9),
  ("Santiago Giordana", 9),
  ("Ismael Diaz", 8),
  ("Tomas Molina", 7),
  ("Danny Luna", 7),
  ("Cristian Martinez", 7),
  ("Gabriel Cortez", 7),
  ("Leonardo Villagra", 6),
  ("Michael Hoyos", 6)
)

// pizarra
List[(String, Int)]

val goles = goleadores.map(_._2).map(_.toDouble)

val average = (values: List[Double]) => values.sum / values.length
val avgGol = average(goles)

// maxBy, minBy devuelve una tupla, ._1 devuelve la primera posicion

// jugador mas goles
goleadores.maxBy(_._2)._1

// jugador menos goles
goleadores.minBy(_._2)._1

// jugadores con goles mayores al promedio

val goles = goleadores.map(_._2).map(_.toDouble)
val average = (values: List[Double]) => values.sum / values.length
val avgGol = average(goles)

val mayoresAvg = goleadores.filter(_._2 > avgGol).map(_._1)

// jugadores con goles menores al promedio

val goles = goleadores.map(_._2).map(_.toDouble)
val average = (values: List[Double]) => values.sum / values.length
val avgGol = average(goles)

val menoresAvg = goleadores.filter(_._2 < avgGol).map(_._1)



// CONJUNTOS

// Grupo de valores unicos

val conj2: Set[Int] = Set()
val conjunto: Set[Int] = Set(1, 1, 2, 2, 3)

val conjunto: Set[Int] = Set(1, 2, 3)
// Se puede agregar un nuevo valor al final
val conNuevo = conjunto + 6

val conjunto: Set[Int] = Set(1, 2, 3)
val conNuevo = conjunto.concat(List(2, 3, 4, 5))

val conjunto: Set[Int] = Set(1, 2, 3)
val conNuevo = conjunto.concat(List(2, 3, 4, 5))
conNuevo.intersect(conjunto)



// MAPAS

// Diccionarios o mapa
// Clave-Key / Significado-Valor
// Clave-Valor

Map[K, V]

// k representa las claves
// v representa los valores

// k, v type parameters

Map(("apples", 3), ("oranges", 2), ("pears", 0))

// ejemplo de mal uso
Map((1, 2), ("ABC", 100))
Map((1, 2), ("ABC", 100.2), (10.10, true))

// Otra manera de declarar
Map(("apples", 3), ("oranges", 2), ("pears", 0))
Map("apples" -> 3, "oranges" -> 2, "pears" -> 0)

// Convertir lista de tuplas a un Map
List(("apples", 3), ("oranges", 2), ("pears", 0)).toMap
List("apples" -> 3, "oranges" -> 2, "pears" -> 0).toMap

// Convertir un Map en secuencia de pares
Map(("apples", 3), ("oranges", 2), ("pears", 0)).toSeq
Map("apples" -> 3, "oranges" -> 2, "pears" -> 0).toSeq

val fruitBasket = Map("apples" -> 3, "oranges" -> 2, "pears" -> 0)
fruitBasket.map(data => data match {
  case (fruit, count) => count * 2
})

fruitBasket.map{ case(fruit, count) => count * 2 }

val fruitBasket = Map("apples" -> 3, "oranges" -> 2, "pears" -> 0)
fruitBasket.map { case (fruit, count) => (fruit, count*2)}

fruitBasket.map{ case(fruit, count) => (fruit, count, count * 2) }.
  map{ case(fruit, _, count2) => (fruit, count2/2)}.toMap


// FILTER

val fruitBasket = Map("apples" -> 3, "oranges" -> 2, "pears" -> 0)
fruitBasket.filter { case (fruit, count) => count > 0}

// GROUP BY

// Reorganiza una secuencia en un mapa donde algunos elementos de
// la secuencia oridinal se agrupan en subsecuencias

// el argumento del metodo groupBy es una funcion que calcula
// el "key"  de cada elemento de secuencia

Seq( "wombat", "xanthan", "yogurt", "zebra").
  groupBy(s => if (s startsWith("y")) 1 else 2)

List(1, 2, 3, 4, 5).groupBy( k => k % 3)

// mi resolucion de ejercicio en clase
goleadores.groupBy(t => t._2).map{ case(num, j) => (num, j.length) }

goleadores.groupBy{ case(_,goals) => goals}

goleadores.groupBy( row => row match {
  case (_, goals) => goals
}).map(row => row match {
  case(goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2)

goleadores.groupBy {
  case (_, goals) => goals
}.map(row => row match {
  case (goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2)

goleadores.groupBy {
  case (_, goals) => goals
}.map(row => row match {
  case (goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2).reverse

goleadores.groupBy( row => row match {
  case (_, goals) => goals
}).map(row => row match {
  case(goles, lista) => (goles, lista.size)
}).toList.sortWith(_._2 < _._2)
