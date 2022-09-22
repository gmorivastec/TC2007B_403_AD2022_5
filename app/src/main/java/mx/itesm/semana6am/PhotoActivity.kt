package mx.itesm.semana6am

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class PhotoActivity : AppCompatActivity() {

    lateinit var imageView : ImageView

    var resultLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->

        // posibles resultados de toma de foto

        // obtener thumbnail (lo que vamos a hacer)
        val image = result.data?.extras?.get("data") as Bitmap
        imageView.setImageBitmap(image)

        // ubicación en almacenamiento local
        // para esta se necesita un provider de archivos


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        imageView = findViewById(R.id.imageView)
/*
        // pruebas de POO
        var ballena = Mamifero(10, "Ballenin")
        var jirafa = Mamifero(5, "Jifarin", 500f)
        var chango = Mamifero(2, "Changuin", 2f, "cafe")

        ballena.saludar()
        jirafa.saludar()
        chango.saludar()
*/
        var fifi = Perrito(3, "fifi", "French Poodle")
        var killer = Perrito(5, "Killer", "Chihuahueño", 0)

        fifi.saludar()
        killer.saludar()
        fifi.comer()
        killer.comer()
        fifi.pasear()
        killer.pasear()

        // polimorfismo en POO
        var fifiMamifero : Mamifero = fifi
        var fifiPaseador : Paseador = fifi

        // podemos invocar los métodos que conformen
        // el contrato del tipo
        fifiMamifero.saludar()
        fifiMamifero.comer()

        fifiPaseador.pasear()

        // casting
        // cambio entre tipos válidos
        var fifi2 = fifiPaseador as Perrito
        fifi2.comer()
    }

    fun tomarFoto(view : View?) {

        // 2 maneras de declarar el intent
        // 1era - con tipo explícito
        // 2da - con una acción (qué quiero que suceda)
        val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        resultLauncher.launch(photoIntent)
    }
}