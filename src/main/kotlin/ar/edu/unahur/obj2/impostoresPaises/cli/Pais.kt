package ar.edu.unahur.obj2.impostoresPaises.cli

class Pais (
  nombre: String,
  codigoiso3: String,
  poblacion: Int,
  superficie: Double,
  continente: String,
  codigoMoneda: String,
  cotizacionDolar: Double,
  paisesLimitrofes: List<Pais>,
  bloquesRegionales: List<String>,
  idiomasOficiales: List<String>
){}
