package ar.edu.unahur.obj2.impostoresPaises.cli

object observatorio {
    val paises = mutableListOf<Pais>()
    val continentes = mutableListOf<String>()

    fun agregarPais(pais: Pais): Unit {
        if(!continentes.contains(pais.continente)) {
            continentes.add(pais.continente)
        }
        paises.add(pais)
    }

    fun sonLimítrofes(pais: Pais, otroPais: Pais): Boolean {
        return pais.sonLimitrofes(otroPais)
    }

    fun necesitanTraducción(pais: Pais, otroPais: Pais): Boolean {
        return pais.necesitanTraduccion(otroPais)
    }

    fun sonPotencialesAliados(pais: Pais, otroPais: Pais): Boolean {
        return pais.sonPotencialesAliados(otroPais)
    }

    fun convieneIrDeCompras(pais: Pais, otroPais: Pais): Boolean {
        return pais.convieneIrDeCompras(otroPais)
    }

    fun aCuántoEquivale(pais: Pais, otroPais: Pais, monto: Double): Double {
        return pais.aCuantoEquivale(otroPais, monto)
    }

    fun obtener5TopPaises(): List<Pais> {
        paises.sortBy { it.densidadPoblacional() }
        return if (paises.size > 5) paises.reversed().subList(0, 5) else paises.reversed()
    }

    fun paisesDeContinente(continente: String): List<Pais> {
        return paises.filter { it.continente === continente }
    }

    fun continenteConMasPlurinacionales(): String {
        val continenteConMas = object {
            var nombre = ""
            var cantidad = 0
        }
        continentes.forEach {
            val paisesDeContinente = this.paisesDeContinente(it)
            var contadorDePlurinacionalidad = 0
            paisesDeContinente.forEach { pais ->
                if (pais.esPlurinacional()) {
                    contadorDePlurinacionalidad += 1
                }
            }
            if (contadorDePlurinacionalidad > continenteConMas.cantidad) {
                continenteConMas.nombre = it
                continenteConMas.cantidad = contadorDePlurinacionalidad
            }
        }
        return continenteConMas.nombre
    }

    fun paisesInsulares(): List<Pais> {
        return paises.filter { it.esUnaIsla() }
    }

    fun conocerPromedioPoblacionalInsular(): Int {
        val paisesInsulares = this.paisesInsulares()
        return (paisesInsulares.sumBy { it.densidadPoblacional() }) / paisesInsulares.size
    }
}
