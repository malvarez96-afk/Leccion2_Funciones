package edu.example.funciones

fun main() {
    println("Taller: Laboratorio de automatización")

    val instrumentos = listOf(
        Pair("Osciloscopio Digital", 1500.0),
        Pair("Voltímetro Digital", 120.0),
        Pair("Generador de Ondas", 980.0),
        Pair("Cable BNC", 15.0),
        Pair("Resistencia 1kΩ", 0.10),
        Pair("Protoboard", 25.0)
    )

    instrumentos.forEach { println("${it.first} -> ${it.second}") }

    val costosos = instrumentos.filter { it.second > 500 }
    println("\nInstrumentos costosos (> 500):")
    costosos.forEach { println(it.first) }

    val baratos = instrumentos.filter { it.second < 50 }
    println("\nInstrumentos baratos (< 50):")
    baratos.forEach { println(it.first) }

    val nombres = instrumentos.map { it.first }
    println("\nNombres de instrumentos:")
    nombres.forEach { println(it) }

    instrumentos.forEach { println("${it.first} cuesta  ${it.second}") }

    val total = instrumentos.sumOf { it.second }
    println("\nCosto total del laboratorio: $total")

    val plus100 = instrumentos.filter { it.second > 100 }.sumOf{it.second}
    println(plus100)

    val ordenados = instrumentos.sortedBy { it.second }
    println("\nInstrumentos ordenados por precio:")
    ordenados.forEach { println("${it.first} - ${it.second}") }

    val ordescending = instrumentos.sortedByDescending { it.second }
    ordescending.forEach { println("${it.first} - ${it.second}") }

    val costosos2 = filtrarInstrumentos(instrumentos) { it.second > 500 }
    println("\n(Con función de orden superior) Costosos (> 500):")
    costosos2.forEach { println(it.first) }

    val Cables = filtrarInstrumentos(instrumentos) {it.first.contains("Cable")}
    Cables.forEach { println("\n${it.first}") }

    val nombres2 = transformarInstrumentos(instrumentos) { it.first }
    println("\n(Con función de orden superior) Nombres:")
    nombres2.forEach { println(it) }


    val precios = transformarInstrumentos(instrumentos) { it.second }
    println("\n(Con función de orden superior) Precios:")
    precios.forEach { println(it) }

    val total2 = calcular(instrumentos) { lista -> lista.sumOf { it.second } }
    println("\n(Con función de orden superior) Total: $total2")

    val total3 = calcular(instrumentos.filter {
        it.first.contains("Osciloscopio") || it.first.contains("Voltímetro")
    }) { lista ->
        lista.sumOf { it.second }
    }
    println(total3)

}

fun filtrarInstrumentos(
    lista: List<Pair<String, Double>>,
    criterio: (Pair<String, Double>) -> Boolean
): List<Pair<String, Double>> {
    return lista.filter(criterio)
}

fun <T> transformarInstrumentos(
    lista: List<Pair<String, Double>>,
    transformacion: (Pair<String, Double>) -> T
): List<T> {
    return lista.map(transformacion)
}

fun calcular(
    lista: List<Pair<String, Double>>,
    operacion: (List<Pair<String, Double>>) -> Double
): Double {
    return operacion(lista)
}