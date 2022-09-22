package mx.itesm.semana6am

import android.util.Log

// declaraciones de clase
// se puede tener una clase vacía:
// class Mamifero

// en la declaración de la clase se define también
// los parámetros del constructor principal
// OJO:
// pueden ser sólo parámetros de entrada
// parámetros del principal son los valores básicos
// requeridos

// las clases en kotlin por default se consideran finales
// que significa que no pueden heredarse
// para poder heredar agrega el modificador "open"

// clase abstracta -
// - no se puede instanciar
// - se utiliza para forzar la implementación de algo de lógica
abstract class Mamifero (edad: Int, nombre: String) {

    var peso = 0f
    var color = ""

    // los parámetros pueden ser utilizados para
    // inicializar propiedades
    val edadProp = edad

    // el constructor principal no tiene cuerpo
    // PERO podemos hacer n bloques de inicialización
    init {
        Log.wtf("PRUEBA CLASE", edadProp.toString())
    }

    // propiedades y bloques de inicializacion pueden ir
    // intercalados

    val nombreProp = nombre

    // los bloques de inicialización se corren en el orden
    // en el que estén escritos
    init {
        Log.wtf("PRUEBA CLASE", nombreProp)
        Log.wtf("PRUEBA CLASE", "BLOQUES DE INICIALIZACION")
    }

    // constructores secundarios
    // podemos tener cualquier cantidad de constructores secundarios
    // TODOS están obligados a llamar al principal
    // (o a otro secundario que llama al principal)

    // todos los constructores secundarios se llaman
    // constructor
    constructor(edad: Int, nombre:String, peso: Float): this(edad, nombre){
        this.peso = peso
        Log.wtf("PRUEBA CLASE", "LLAMANDO A CONSTRUCTOR SECUNDARIO")
    }

    constructor(
        edad:Int,
        nombre: String,
        peso: Float,
        color: String
    ) : this(edad, nombre, peso) {

        this.color = color
        Log.wtf("PRUEBA CLASE", "LLAMANDO A CONSTRUCTOR SECUNDARIO 2")
    }

    open fun saludar() {

        Log.wtf("PRUEBA CLASE", "hola soy $nombreProp, como te va?")
    }

    // método abstracto
    // en definición es una acción que todos los de este tipo pueden hacer
    // pero la implementación varía
    abstract fun comer()
}