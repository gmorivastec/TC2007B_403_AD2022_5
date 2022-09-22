package mx.itesm.semana6am

import android.util.Log

// herencia
// creamos una clase que es un subtipo de otra
// si lo vemos como conjuntos es un subconjunto
// al momento de declarar los parámetros del constructor principal
// si ponemos var / val se vuelven propiedades automáticamente

// generics
// <>
// - es posible parametrizar un tipo
class Perrito(
    edad: Int,
    nombre: String,
    var raza: String
    ) : Mamifero(edad, nombre), Paseador {

    var nivelDeEducacion = 0

    init {
        Log.wtf("PRUEBA CLASE", "INICIALIZACION EN PERRITO")
    }

    constructor(
        edad: Int,
        nombre: String,
        raza: String,
        nivelDeEducacion: Int
    ) : this(edad, nombre, raza) {

        this.nivelDeEducacion = nivelDeEducacion
        Log.wtf("PRUEBA CLASE", "CONSTRUCTOR SECUNDARIO EN PERRITO")
    }

    // sobrecarga???
    // - agregar lógica a lo que ya existe
    // - en el caso de un método es agregar otro con el mismo nombre
    // PERO DIFERENTE LISTA DE ARGUMENTOS (lo que cambia la firma)

    // sobreescritura
    // - reemplazar lógica de superclase en subclase

    override fun saludar() {
        // siempre podemos llamar la versión de la superclase
        super.saludar()
        Log.wtf("PRUEBA CLASE", "woof woof $nombreProp")
    }

    override fun comer() {
        Log.wtf("PRUEBA CLASE", "nom nom $nombreProp")
    }

    override fun pasear() {
        Log.wtf("PRUEBA CLASE", "VAMOS A PASEAR!")
    }
}