package mx.edu.ittepic.ladm_u2_practica2_ricardovilla
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var lienzo  : Lienzo ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)
        HiloAnimacion(this).start()
    }
}
