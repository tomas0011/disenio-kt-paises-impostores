package ar.edu.unahur.obj2.impostoresPaises.cli

import java.nio.DoubleBuffer
import kotlin.math.roundToInt

class Pais (
  private val nombre: String,
  private val codigoiso3: String,
  private val poblacion: Int,
  private val superficie: Double,
  private val continente: String,
  private val codigoMoneda: String,
  private val cotizacionDolar: Double,
  private val paisesLimitrofes: List<Pais>,
  private val bloquesRegionales: List<String>,
  private val idiomasOficiales: List<String>
){
  fun esPlurinacional() = idiomasOficiales.size > 1

  fun esUnaIsla() = paisesLimitrofes.isEmpty()

  fun densidadPoblacional() = (poblacion * superficie).roundToInt()

  fun vecinoMasPoblado(): String {
    var paisMasPoblado = nombre
    var poblacionDelMasPoblado = poblacion
    paisesLimitrofes.map{
      if(it.poblacion > poblacionDelMasPoblado){
        paisMasPoblado = it.nombre
        poblacionDelMasPoblado = it.poblacion
      }
    }
    return paisMasPoblado
  }

  fun sonLimitrofes(pais: Pais) = pais.paisesLimitrofes.contains(nombre)

  fun necesitanTraduccion(pais: Pais): Boolean{
    var contador = 0
    idiomasOficiales.map {
      if(pais.idiomasOficiales.contains(it)){
        contador++
      }
    }
    return contador == 0
  }

  fun sonPotencialesAliados(pais: Pais): Boolean {
    var contador = 0
    bloquesRegionales.map {
      if(pais.bloquesRegionales.contains(it)){
        contador++
      }
    }
    return contador == 0 && !necesitanTraduccion(pais)
  }

  fun convieneIrDeCompras(pais: Pais) = pais.cotizacionDolar > cotizacionDolar

  fun aCuantoEquivale(pais: Pais, monto: Double) = pais.cotizacionDolar * (monto/cotizacionDolar)

}
