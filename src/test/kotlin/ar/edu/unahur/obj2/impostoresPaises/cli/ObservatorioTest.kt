package ar.edu.unahur.obj2.impostoresPaises.cli

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ObservatorioTest: DescribeSpec({
    describe("metodos de conjunto") {
        describe("continenteConMasPlurinacionales") {

            beforeEach {
                var Chile: Pais? = null
                var Brasil: Pais? = null
                var Uruguay: Pais? = null

                val Argentina = Pais(
                    "Argentina",
                    "ARG",
                    47000000,
                    100.0,
                    "América",
                    "ARS",
                    235.0,
                    listOf(Chile, Brasil, Uruguay) as List<Pais>,
                    listOf("MERCOSUR", "MCCA", "CARICOM", "ALADI"),
                    listOf("Español")
                )

                Uruguay = Pais(
                    "Uruguay",
                    "UR",
                    3400000,
                    100.0,
                    "América",
                    "Uru",
                    39.47,
                    listOf(Argentina, Brasil) as List<Pais>,
                    listOf("MERCOSUR", "TLC"),
                    listOf("Español")
                )

                Brasil = Pais(
                    "Brasil",
                    "BR",
                    212600000,
                    100.0,
                    "América",
                    "Br",
                    5.33,
                    listOf(Argentina, Uruguay) as List<Pais>,
                    listOf("MERCOSUR"),
                    listOf("Portugues")
                )

                Chile = Pais(
                    "Chile",
                    "CH",
                    19200000,
                    100.0,
                    "América",
                    "Chi",
                    932.58,
                    listOf(Argentina),
                    listOf("UNASUR", "CELAC"),
                    listOf("Español")
                )

                observatorio.agregarPais(Argentina)
                observatorio.agregarPais(Uruguay!!)
                observatorio.agregarPais(Brasil!!)
                observatorio.agregarPais(Chile!!)
            }

            it("deberia devolver al de mayor densidad primero") {
                val top5Paises = observatorio.obtener5TopPaises()
                (top5Paises[0].densidadPoblacional() >= top5Paises[1].densidadPoblacional()).shouldBeTrue()
                (top5Paises[0].densidadPoblacional() >= top5Paises[2].densidadPoblacional()).shouldBeTrue()
            }
        }
    }
})