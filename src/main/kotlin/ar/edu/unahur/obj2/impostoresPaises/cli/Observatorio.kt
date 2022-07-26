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

    fun getPais(nombre: String): Pais {
        val pais = paises.find { it.nombre === nombre }
        if (pais === null) {
            throw Exception()
        }
        return pais
    }

    fun agregarPais(masPaises: List<Pais>): Unit {
        masPaises.forEach {
            if (!this.continentes.contains(it.continente)) {
                this.continentes.add(it.continente)
            }
        }
        this.paises += masPaises
    }

    fun sonLimítrofes(nombrePais: String, nombreOtroPais: String): Boolean {
        val pais = getPais(nombrePais)
        val otroPais = getPais(nombreOtroPais)
        return pais.sonLimitrofes(otroPais)
    }

    fun necesitanTraducción(nombrePais: String, nombreOtroPais: String): Boolean {
        val pais = getPais(nombrePais)
        val otroPais = getPais(nombreOtroPais)
        return pais.necesitanTraduccion(otroPais)
    }

    fun sonPotencialesAliados(nombrePais: String, nombreOtroPais: String): Boolean {
        val pais = getPais(nombrePais)
        val otroPais = getPais(nombreOtroPais)
        return pais.sonPotencialesAliados(otroPais)
    }

    fun convieneIrDeCompras(nombrePais: String, nombreOtroPais: String): Boolean {
        val pais = getPais(nombrePais)
        val otroPais = getPais(nombreOtroPais)
        return pais.convieneIrDeCompras(otroPais)
    }

    fun aCuántoEquivale(nombrePais: String, nombreOtroPais: String, monto: Double): Double {
        val pais = getPais(nombrePais)
        val otroPais = getPais(nombreOtroPais)
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
        return this.paises.groupBy { it.continente }
            .mapValues { paises -> paises.value.count { it.esPlurinacional() } }
            .maxByOrNull { it.value }!!.key
    }

    fun paisesInsulares(): List<Pais> {
        return this.paises.filter { it.esUnaIsla() }
    }

    fun conocerPromedioPoblacionalInsular(): Int {
        val paisesInsulares = this.paisesInsulares()
        return (paisesInsulares.sumBy { it.densidadPoblacional() }) / paisesInsulares.size
    }
}


