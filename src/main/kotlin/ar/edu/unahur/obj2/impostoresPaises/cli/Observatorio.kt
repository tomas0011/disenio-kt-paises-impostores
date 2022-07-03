package ar.edu.unahur.obj2.impostoresPaises.cli

object observatorio {
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
}
