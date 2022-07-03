package ar.edu.unahur.obj2.impostoresPaises.cli

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
}
