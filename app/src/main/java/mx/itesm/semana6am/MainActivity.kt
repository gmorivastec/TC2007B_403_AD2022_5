package mx.itesm.semana6am

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

// API DE UBICACIÓN
// - requiere registro de tarjeta

// shared prefs
// localización
// firma de binarios (qué son y para qué sirven)

// shared prefs
// - almacenamiento local
// -- uso de DB local
// -- guardar / cargar info de un archivo en resources
// -- cargar archivos de assets
// -- shared prefs

// SHARED PREFS -
// - mecanismo para guardar información de manera local
// - guarda un XML con montón de datos con estructura llave - valor

class MainActivity : AppCompatActivity() {

    private var ARCHIVO_PREFS = "preferencias.prefs"
    private var PREF_NOMBRE = "nombre"
    private var PREF_CIUDAD = "ciudad"
    private lateinit var sharedPrefs : SharedPreferences

    lateinit var sharedPrefsOutput : TextView
    lateinit var sharedPrefsInput : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefsOutput = findViewById(R.id.mainSharedPref)
        sharedPrefsInput = findViewById(R.id.mainInput)

        // objeto contiene el "archivo" traducido interpretado en memoria
        sharedPrefs = getSharedPreferences(ARCHIVO_PREFS, Context.MODE_PRIVATE)


        // en inicio cargar datos de shared prefs
        sharedPrefsOutput.text = sharedPrefs.getString(PREF_NOMBRE, "no hubo nombre")

        // guardar valor en sharedprefs
        with(sharedPrefs.edit()){

            putString(PREF_NOMBRE, "Juan")

            // actualiza objeto en memoria
            // apply()

            // guarda en almacenamiento local
            // como es síncrono hay que evaluar donde lo ponemos
            // ejemplo: onDestroy
            commit()

        }

        // prueba de lectura
        Toast.makeText(
            this,
            getString(R.string.main_toast),
            Toast.LENGTH_SHORT
        ).show()


    }

    fun guardar(v : View?){

        with(sharedPrefs.edit()){

            putString(PREF_CIUDAD, sharedPrefsInput.text.toString())

            commit()
        }
    }

    fun borrar(v : View?){
        with(sharedPrefs.edit()){
            remove(PREF_CIUDAD)
            commit()
        }
    }

    fun borrarTodos(v : View?){

        with(sharedPrefs.edit()){
            clear()
            commit()
        }
    }

    fun mostrar(v : View?){

        // prueba de lectura
        Toast.makeText(
            this,
            sharedPrefs.getString(PREF_NOMBRE, "no hubo nombre"),
            Toast.LENGTH_SHORT
        ).show()

        // prueba de lectura
        Toast.makeText(
            this,
            sharedPrefs.getString(PREF_CIUDAD, "no hubo ciudad"),
            Toast.LENGTH_SHORT
        ).show()
    }


    fun cambiarAPhoto(v: View?){

        var intent = Intent(this, PhotoActivity::class.java)
        startActivity(intent)
    }
}