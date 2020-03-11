package mx.edu.ittepic.ladm_u2_practica2_ricardovilla

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

import mx.edu.ittepic.ladm_u2_practica2_ricardovilla.MainActivity

class Lienzo(p:MainActivity) : View(p) {

    var puntero = p

    //GRANDES
    var circulo = FiguraGeometrica(150, 150, 150)
    var circulo2 = FiguraGeometrica(500, 800, 150)

    //MEDIANAS
    var circulo3 = FiguraGeometrica(10, 150, 100)
    var circulo4 = FiguraGeometrica(200, 600, 100)

    //PEQUEÑAS
    var circulo5 = FiguraGeometrica(700, 40, 50)
    var circulo6 = FiguraGeometrica(8, 20, 50)



    var punteroFiguraGeometrica: FiguraGeometrica? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        canvas.drawColor(Color.rgb(5,199,217))

        //Dibujando 1er ciculo
        paint.color = Color.rgb(106,46,134)
        circulo.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo.pintar(canvas, paint)


       //Dibujando 2do ciculo
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(8,42,107)
        circulo2.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo2.pintar(canvas, paint)

        //Dibujando tercer ciculo
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(10,135,79)
        circulo3.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo3.pintar(canvas, paint)


        //Dibujando 4TO ciculo
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(182,115,53)
        circulo4.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo4.pintar(canvas, paint)


        //Dibujando 5TO ciculo
        paint.style = Paint.Style.FILL
        paint.color = Color.MAGENTA
        circulo5.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo5.pintar(canvas, paint)

        //Dibujando 6TO ciculo
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        circulo6.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 10f
        circulo6.pintar(canvas, paint)


    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //REVISAMOS QUIEN ESTA EN AREA
                if (circulo.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo
                    puntero.setTitle("TOCASTE CIRCULO")
                }
                /*if (cuadrado.estaEnArea(event)) {
                    punteroFiguraGeometrica = cuadrado
                    puntero.setTitle("TOCASTE CUADRADO")
                }
                if (rectangulo.estaEnArea(event)) {
                    punteroFiguraGeometrica = rectangulo
                    puntero.setTitle("TOCASTE RECTANGULO")
                }*/
                if (circulo2.estaEnArea(event)) {
                    punteroFiguraGeometrica = circulo2
                    puntero.setTitle("TOCASTE CIRCULO2")
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (punteroFiguraGeometrica != null) {
                    punteroFiguraGeometrica!!.arrastrar(event)

                    //EVALUAR LA COLISION DEL CIRCULO
                    if(punteroFiguraGeometrica == circulo){
                       //AQUI ENTRA SI Y SOLO A QUIEN ARRASTRO ES EL CIRCULO
                       /* if(punteroFiguraGeometrica!!.colision(cuadrado)){
                           //AQUI ENTRA SI CIRCULO 1 COLISIONO AL CUADRADO
                           puntero.setTitle("Circulo 1 colisiono cuadrado")
                        }*/

                        if(punteroFiguraGeometrica!!.colision(circulo2)){
                            //AQUI ENTRA SI CIRCULO 1 COLISIONO AL CUADRADO
                            puntero.setTitle("Circulo 1 colisiono circulo 2")
                        }
                    }

                    //EVALUAR LA COLISION DEL CIRCULO2
                    if(punteroFiguraGeometrica == circulo2){
                        //AQUI ENTRA SI Y SOLO A QUIEN ARRASTRO ES EL CIRCULO2
                        if(punteroFiguraGeometrica!!.colision(circulo)){
                            //AQUI ENTRA SI CIRCULO 1 COLISIONO AL CUADRADO
                            puntero.setTitle("Circulo 2 colisiono Circulo 1")
                        }

                        /*if(punteroFiguraGeometrica!!.colision(cuadrado)){
                            //AQUI ENTRA SI CIRCULO 1 COLISIONO AL CUADRADO
                            puntero.setTitle("Circulo 1 toco cuadrado")
                        }*/
                    }

                    //Como agregar imagenes al canvas

                }

            }
            MotionEvent.ACTION_UP -> {
                punteroFiguraGeometrica = null
            }
        }
        invalidate()
        return true
    }

    fun animarCirculo() {
        circulo.rebote(width,height)
        circulo2.rebote(width,height)
        circulo3.rebote(width,height)
        circulo4.rebote(width,height)
        circulo5.rebote(width,height)
        circulo6.rebote(width,height)
        invalidate()
    }

}