package ar.edu.unahur.obj2.impostoresPaises.cli

class Observatorio() {
    val paises = mutableListOf<Pais>()
    val continentes = mutableListOf<String>()

    companion object {
        private var instance: Observatorio? = null

        fun getInstance(): Observatorio {
            var checkInstance = instance
            if (checkInstance === null) {
                checkInstance = Observatorio()
            }
            return checkInstance
        }
    }

    fun agregarPais(masPaises: List<Pais>): Unit {
        masPaises.forEach {
            if (!this.continentes.contains(it.continente)) {
                this.continentes.add(it.continente)
            }
        }
        this.paises += masPaises
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
        this.paises.sortBy { it.densidadPoblacional() }
        return if (this.paises.size > 5) this.paises.reversed().subList(0, 5) else this.paises.reversed()
    }

    fun paisesDeContinente(continente: String): List<Pais> {
        return this.paises.filter { it.continente === continente }
    }

    fun continenteConMasPlurinacionales(): String {
        val continenteConMas = object {
            var nombre = ""
            var cantidad = 0
        }
        this.continentes.forEach {
            val paisesDeContinente = this.paisesDeContinente(it)
            var contadorDePlurinacionalidad = 0
            paisesDeContinente.forEach { pais ->
                if (pais.esPlurinacional()) {
                    contadorDePlurinacionalidad += 1
                }
            }
            if (contadorDePlurinacionalidad > continenteConMas.cantidad || continenteConMas.nombre === "") {
                continenteConMas.nombre = it
                continenteConMas.cantidad = contadorDePlurinacionalidad
            }
        }
        return continenteConMas.nombre
    }

    fun paisesInsulares(): List<Pais> {
        return this.paises.filter { it.esUnaIsla() }
    }

    fun conocerPromedioPoblacionalInsular(): Int {
        val paisesInsulares = this.paisesInsulares()
        return (paisesInsulares.sumBy { it.densidadPoblacional() }) / paisesInsulares.size
    }
}


