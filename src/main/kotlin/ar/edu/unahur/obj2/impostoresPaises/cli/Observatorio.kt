package ar.edu.unahur.obj2.impostoresPaises.cli

object observatorio {
    val paises = mutableListOf<Pais>()

    fun agregarPais(pais: Pais): Unit {
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
        paises.sortByDescending { it.densidadPoblacional() }
        return paises.subList(0, 5)
    }
}
