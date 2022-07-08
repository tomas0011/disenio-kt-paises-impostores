package ar.edu.unahur.obj2.impostoresPaises.cli

import java.text.DecimalFormat
import kotlin.math.roundToInt

class Pais(
   val nombre: String,
  private val codigoiso3: String,
  private val poblacion: Int,
  private val superficie: Double,
  private val continente: String,
  private val codigoMoneda: String,
  private val cotizacionDolar: Double,
  private val bloquesRegionales: List<BloquesRegionales>,
   val idiomasOficiales: List<String>
){
  var paisesLimitrofes = listOf<Pais>()

  fun addPaisesLimitrofes(paises: List<Pais>){
    paisesLimitrofes = paises
  }

  fun esPlurinacional() = idiomasOficiales.size > 1

  fun esUnaIsla() = paisesLimitrofes.isEmpty()

  fun densidadPoblacional() = (poblacion / superficie).roundToInt()

  fun vecinoMasPoblado(): String {
    var paisMasPoblado = nombre
    var poblacionDelMasPoblado = poblacion
    paisesLimitrofes.map{
      pais ->
      if(pais.poblacion > poblacionDelMasPoblado){
        paisMasPoblado = pais.nombre
        poblacionDelMasPoblado = pais.poblacion
      }
    }
    return paisMasPoblado
  }

  fun sonLimitrofes(pais: Pais) = pais.paisesLimitrofes.any{ it.nombre == nombre }

  fun necesitanTraduccion(pais: Pais) = !idiomasOficiales.any{ pais.idiomasOficiales.contains(it) }

  fun sonPotencialesAliados(pais: Pais) = bloquesRegionales.any{ pais.bloquesRegionales.contains(it) } && !necesitanTraduccion(pais)

  fun convieneIrDeCompras(pais: Pais) = pais.cotizacionDolar > cotizacionDolar

  fun aCuantoEquivale(pais: Pais, monto: Double): Double {
    var equivalente = pais.cotizacionDolar * (monto/cotizacionDolar)
    return (equivalente * 100.0).roundToInt() / 100.0
  }

}
