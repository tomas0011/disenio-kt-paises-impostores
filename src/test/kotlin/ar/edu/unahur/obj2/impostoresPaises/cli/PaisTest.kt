package ar.edu.unahur.obj2.impostoresPaises.cli
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import kotlin.math.roundToInt

class PaisTest : DescribeSpec({
    describe("Pais"){




        var Argentina = Pais(
            "Argentina",
            "a",
            47000000,
            100.0,
            "América",
            "Arg",
            235.0,

            listOf("MERCOSUR", "MCCA", "CARICOM", "ALADI"),
            listOf("Español")
        )

        var Chile = Pais(
            "Chile",
            "a",
            19200000,
            100.0,
            "América",
            "Chi",
            932.58,

            listOf("UNASUR", "CELAC"),
            listOf("Español")
        )

        var Uruguay = Pais(
            "Uruguay",
            "a",
            3400000,
            100.0,
            "América",
            "Uru",
            39.47,

            listOf("MERCOSUR", "TLC"),
            listOf("Español")
        )

        var Brasil = Pais(
            "Brasil",
            "a",
            212600000,
            100.0,
            "América",
            "Br",
            5.33,

            listOf("MERCOSUR"),
            listOf("Portugues")
        )


        Argentina.addPaisesLimitrofes( listOf(Chile, Brasil, Uruguay))
        Chile.addPaisesLimitrofes(listOf(Argentina))
        Uruguay.addPaisesLimitrofes( listOf(Argentina, Brasil))
        Brasil.addPaisesLimitrofes(listOf(Argentina, Uruguay))


        describe("Paises plurinacionales"){
            it("Argentina no deberia ser un pais plurinacional"){
                Argentina.esPlurinacional().shouldBeFalse()
            }
            it("Chile no deberia ser un pais plurinacional"){
                Chile!!.esPlurinacional().shouldBeFalse()
            }
            it("Brasil no deberia ser un pais plurinacional"){
                Brasil!!.esPlurinacional().shouldBeFalse()
            }
            it("Uruguay no deberia ser un pais plurinacional"){
                Uruguay!!.esPlurinacional().shouldBeFalse()
            }
        }

        describe("Son islas"){
            it("Argentina no deberia ser una isla"){
                Argentina.esUnaIsla().shouldBeFalse()
            }
            it("Chile no deberia ser una isla"){
                Chile!!.esUnaIsla().shouldBeFalse()
            }
            it("Brasil no deberia ser una isla"){
                Brasil!!.esUnaIsla().shouldBeFalse()
            }
            it("Uruguay no deberia ser una isla"){
                Uruguay!!.esUnaIsla().shouldBeFalse()
            }
        }

        describe("Densidad poblacional"){
            it("La densidad poblacional de Argentina deberia ser 470.000"){
                Argentina.densidadPoblacional().shouldBe(470000)
            }
            it("La densidad poblacional de Chile deberia ser 192.000"){
                Chile!!.densidadPoblacional().shouldBe(192000)
            }
            it("La densidad poblacional de Brasil deberia ser 2.126.000"){
                Brasil!!.densidadPoblacional().shouldBe(2126000)
            }
            it("La densidad poblacional de Uruguay deberia ser 34.000"){
                Uruguay!!.densidadPoblacional().shouldBe(34000)
            }
        }

        describe("Vecino mas poblado"){
            it("El vecino mas poblado de Argentina deberia ser Brasil"){
                Argentina.vecinoMasPoblado().shouldBe("Brasil")
            }
            it("El vecino mas poblado de Chile deberia ser Argentina"){
                Chile!!.vecinoMasPoblado().shouldBe("Argentina")
            }
            it("El vecino mas poblado de Brasil deberia ser el mismo"){
                Brasil!!.vecinoMasPoblado().shouldBe("Brasil")
            }
            it("El vecino mas poblado de Uruguay deberia ser Brasil"){
                Uruguay!!.vecinoMasPoblado().shouldBe("Brasil")
            }
        }
    }
})
