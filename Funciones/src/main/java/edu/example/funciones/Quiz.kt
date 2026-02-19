package edu.example.funciones

fun main() {
    val A = calcularArea(2.5, 4.0,"Rectangulo")
    val B = calcularArea(2.5, 4.0)
    println(A)
    println(B)
}

fun calcularArea(base: Double, altura : Double, figura : String = "Triangulo"): Double{
    val Area : Double
    if (figura == "Triangulo")
        Area = (base * altura)/2
    else
        Area = base * altura
    return Area

}