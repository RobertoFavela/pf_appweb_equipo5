/*
* Práctica 1: MasterMind
* Nombre: Jesús Morales
* ID: 00000245335
*/

data class Evaluacion(val PosicionExacta: Int, val PosicionIncorrecta: Int)

fun main() {

    println(evaluar("ABCD", "ABCD"))
    println(evaluar("ABCD", "CDBA"))
    println(evaluar("ABCD", "ABDC"))
    println(evaluar("AABC", "ADFE"))
    println(evaluar("AABC", "DEAA"))

}

fun evaluar(secreto: String, intento: String): Evaluacion {

    var catidadPosicionExacta = 0
    var catidadPosicionIncorrecta = 0

    for (i in secreto.indices) {
        var posicionExacta = secreto[i].toString() == intento[i].toString()

        if (posicionExacta) {
            catidadPosicionExacta++
        }else{
            if (secreto.contains(intento[i].toString())) {
                catidadPosicionIncorrecta++
            }
        }
    }

    return Evaluacion(catidadPosicionExacta, catidadPosicionIncorrecta)
}