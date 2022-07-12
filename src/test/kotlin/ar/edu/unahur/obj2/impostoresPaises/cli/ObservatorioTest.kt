package ar.edu.unahur.obj2.impostoresPaises.cli

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ObservatorioTest: DescribeSpec({
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

        }

        describe("necesitanTraducción") {

        }

        describe("sonPotencialesAliados") {

        }

        describe("convieneIrDeCompras") {

        }

        describe("aCuántoEquivale") {

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
