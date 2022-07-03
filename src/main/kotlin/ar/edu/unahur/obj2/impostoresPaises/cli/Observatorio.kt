package ar.edu.unahur.obj2.impostoresPaises.cli

object observatorio {
    fun sonLimítrofes(pais: Pais, otroPais: Pais): Boolean {
        return pais.esLimitrofeA(otroPais)
    }

    fun necesitanTraducción(pais: Pais, otroPais: Pais): Boolean {
        return true
    }
}
