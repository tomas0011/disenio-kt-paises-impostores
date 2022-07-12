package ar.edu.unahur.obj2.impostoresPaises.cli

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ObservatorioTest: DescribeSpec({
    val observatorio: Observatorio = Observatorio.getInstance()

    val Argentina = Pais(
        "Argentina",
        "ARG",
        47000000,
        100.0,
        "América",
        "ARS",
        235.0,
        listOf(BloquesRegionales.MERCOSUR, BloquesRegionales.MCCA,BloquesRegionales.CARICOM, BloquesRegionales.ALADI),
        listOf(Idiomas.Español)
    )
    val Uruguay = Pais(
        "Uruguay",
        "UR",
        3400000,
        100.0,
        "América",
        "Uru",
        39.47,
        listOf(BloquesRegionales.MERCOSUR, BloquesRegionales.TLC),
        listOf(Idiomas.Español)
    )
    val Brasil = Pais(
        "Brasil",
        "BR",
        212600000,
        100.0,
        "América",
        "Br",
        5.33,
        listOf(BloquesRegionales.MERCOSUR),
        listOf(Idiomas.Portugues)
    )
    val Chile = Pais(
        "Chile",
        "CH",
        19200000,
        100.0,
        "América",
        "Chi",
        932.58,
        listOf(BloquesRegionales.UNASUR, BloquesRegionales.CELAC),
        listOf(Idiomas.Español)
    )
    val Sudafrica = Pais(
        "Sudafrica",
        "SA",
        19200000,
        100.0,
        "Africa",
        "Chi",
        932.58,
        listOf(),
        listOf(Idiomas.Español, Idiomas.Portugues, Idiomas.Frances)
    )
    val Nigeria = Pais(
        "Nigeria",
        "NG",
        19200000,
        100.0,
        "Africa",
        "Chi",
        932.58,
        listOf(),
        listOf(Idiomas.Portugues, Idiomas.Frances)
    )
    val Malvinas = Pais(
        "Malvinas",
        "MV",
        19200000,
        100.0,
        "América",
        "Chi",
        932.58,
        listOf(),
        listOf(Idiomas.Ingles)
    )
    val Hawaii = Pais(
        "Hawaii",
        "HW",
        100000,
        100.0,
        "América",
        "Hw",
        932.58,
        listOf(),
        listOf(Idiomas.Hawaiano)
    )

    Argentina.addPaisesLimitrofes(listOf(Chile, Brasil, Uruguay))
    Uruguay.addPaisesLimitrofes(listOf(Argentina, Brasil))
    Brasil.addPaisesLimitrofes(listOf(Argentina, Uruguay))
    Chile.addPaisesLimitrofes(listOf(Argentina))
    Nigeria.addPaisesLimitrofes(listOf(Sudafrica))
    Sudafrica.addPaisesLimitrofes(listOf(Nigeria))

    observatorio.agregarPais(listOf(Argentina, Uruguay, Brasil, Chile))

    describe("metodos de observatorio") {
        describe("sonLimítrofes") {
            it("Brasil deberia limitar con Argentina") {
                observatorio.sonLimítrofes(Argentina, Brasil).shouldBeTrue()
            }
            it("Argentina deberia limitar con Brasil") {
                observatorio.sonLimítrofes(Brasil,Argentina).shouldBeTrue()
            }
            it("Chile no deberia limitar con Uruguay") {
                observatorio.sonLimítrofes(Uruguay,Chile).shouldBeFalse()
            }
        }

        describe("necesitanTraducción") {
            it("Argentina no deberia necesitar traduccion con Chile"){
                observatorio.necesitanTraducción(Argentina, Chile).shouldBeFalse()
            }
            it("Argentina no deberia necesitar traduccion con Uruguay"){
                observatorio.necesitanTraducción(Argentina, Uruguay).shouldBeFalse()
            }
            it("Argentina deberia necesitar traduccion con Brasil"){
                observatorio.necesitanTraducción(Argentina, Brasil).shouldBeTrue()
            }
        }

        describe("sonPotencialesAliados") {
            it("Chile no deberia ser potencial Aliado de Brasil"){
                observatorio.sonPotencialesAliados(Brasil, Chile).shouldBeFalse()
            }
            it("Uruguay no deberia ser potencial aliado de Chile"){
                observatorio.sonPotencialesAliados(Uruguay, Chile).shouldBeFalse()
            }
            it("Argentina deberia ser potencial aliado de Uruguay"){
                observatorio.sonPotencialesAliados(Uruguay, Argentina).shouldBeTrue()
            }
            it("Argentina no deberia ser potencial aliado de Brasil"){
                observatorio.sonPotencialesAliados(Argentina,Brasil).shouldBeFalse()
            }
        }

        describe("convieneIrDeCompras") {
            describe("A Brasil le conviene ir de compras a todos los paises "){
                it("A Brasil deberia convenirle ir de compras a Argentina"){
                    observatorio.convieneIrDeCompras(Brasil,Argentina).shouldBeTrue()
                }
                it("A Brasil deberia convenirle ir de compras a Uruguay"){
                    observatorio.convieneIrDeCompras(Brasil,Uruguay).shouldBeTrue()
                }
                it("A Brasil deberia convenirle ir de compras a Chile"){
                    observatorio.convieneIrDeCompras(Brasil,Chile).shouldBeTrue()
                }
            }

            describe("A Chile no deberia convenirle ir a comprar a ningun pais"){
                it("A Chile no deberia convenirle ir de compras a Argentina"){
                    observatorio.convieneIrDeCompras(Chile,Argentina).shouldBeFalse()
                }
                it("A Chile no deberia convenirle ir de compras a Brasil"){
                    observatorio.convieneIrDeCompras(Chile, Brasil).shouldBeFalse()
                }
                it("A Chile no deberia convenirle ir de compras a Uruguay"){
                    observatorio.convieneIrDeCompras(Chile, Uruguay).shouldBeFalse()
                }
            }
        }

        describe("aCuántoEquivale") {
            it("100 pesos argentinos deberian ser 396.84"){
                observatorio.aCuántoEquivale(Argentina, Chile, 100.0).shouldBe(396.84)
            }

            it("5 reales deberian ser 37.02 pesos Uruguayos"){
                observatorio.aCuántoEquivale(Brasil, Uruguay, 5.0).shouldBe(37.03)
            }
        }
    }

    describe("metodos de conjunto de observatorio") {
        describe("obtener5TopPaises") {
            it("deberia devolver al de mayor densidad primero") {
                val top5Paises = observatorio.obtener5TopPaises()
                (top5Paises[0].densidadPoblacional() >= top5Paises[1].densidadPoblacional()).shouldBeTrue()
                (top5Paises[0].densidadPoblacional() >= top5Paises[2].densidadPoblacional()).shouldBeTrue()
            }
        }

        describe("continenteConMasPlurinacionales") {
            observatorio.agregarPais(listOf(Sudafrica))

            it("Africa deberia ser el continente con mas plurinacionales") {
                observatorio.continenteConMasPlurinacionales().shouldBe("Africa")
            }
        }

        describe("conocerPromedioPoblacionalInsular") {
            observatorio.agregarPais(listOf(Malvinas, Hawaii))

            it("El promedio de poblacion insular deberia ser de 100") {
                observatorio.conocerPromedioPoblacionalInsular().shouldBe(96500)
            }
        }
    }
})
