package ar.edu.unahur.obj2.impostoresPaises.cli
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

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

            listOf(BloquesRegionales.MERCOSUR, BloquesRegionales.MCCA,BloquesRegionales.CARICOM, BloquesRegionales.ALADI),
            listOf(Idiomas.Español)
        )

        var Chile = Pais(
            "Chile",
            "a",
            19200000,
            100.0,
            "América",
            "Chi",
            932.58,
            listOf(BloquesRegionales.UNASUR, BloquesRegionales.CELAC),
            listOf(Idiomas.Español)
        )

        var Uruguay = Pais(
            "Uruguay",
            "a",
            3400000,
            100.0,
            "América",
            "Uru",
            39.47,

            listOf(BloquesRegionales.MERCOSUR, BloquesRegionales.TLC),
            listOf(Idiomas.Español)
        )

        var Brasil = Pais(
            "Brasil",
            "a",
            212600000,
            100.0,
            "América",
            "Br",
            5.33,

            listOf(BloquesRegionales.MERCOSUR),
            listOf(Idiomas.Portugues)
        )

        Argentina.addPaisesLimitrofes( listOf(Chile, Brasil, Uruguay))
        Chile.addPaisesLimitrofes(listOf(Argentina))
        Uruguay.addPaisesLimitrofes( listOf(Argentina, Brasil))
        Brasil.addPaisesLimitrofes(listOf(Argentina, Uruguay))


        Argentina.idiomasOficiales.map{ println("Arg  " + it)}
        Chile.idiomasOficiales.map{ println("BR  " + it)}


        describe("Paises plurinacionales"){
            it("Argentina no deberia ser un pais plurinacional"){
                Argentina.esPlurinacional().shouldBeFalse()
            }
            it("Chile no deberia ser un pais plurinacional"){
                Chile.esPlurinacional().shouldBeFalse()
            }
            it("Brasil no deberia ser un pais plurinacional"){
                Brasil.esPlurinacional().shouldBeFalse()
            }
            it("Uruguay no deberia ser un pais plurinacional"){
                Uruguay.esPlurinacional().shouldBeFalse()
            }
        }

        describe("Son islas"){
            it("Argentina no deberia ser una isla"){
                Argentina.esUnaIsla().shouldBeFalse()
            }
            it("Chile no deberia ser una isla"){
                Chile.esUnaIsla().shouldBeFalse()
            }
            it("Brasil no deberia ser una isla"){
                Brasil.esUnaIsla().shouldBeFalse()
            }
            it("Uruguay no deberia ser una isla"){
                Uruguay.esUnaIsla().shouldBeFalse()
            }
        }

        describe("Densidad poblacional"){
            it("La densidad poblacional de Argentina deberia ser 470.000"){
                Argentina.densidadPoblacional().shouldBe(470000)
            }
            it("La densidad poblacional de Chile deberia ser 192.000"){
                Chile.densidadPoblacional().shouldBe(192000)
            }
            it("La densidad poblacional de Brasil deberia ser 2.126.000"){
                Brasil.densidadPoblacional().shouldBe(2126000)
            }
            it("La densidad poblacional de Uruguay deberia ser 34.000"){
                Uruguay.densidadPoblacional().shouldBe(34000)
            }
        }

        describe("Vecino mas poblado"){
            it("El vecino mas poblado de Argentina deberia ser Brasil"){
                Argentina.vecinoMasPoblado().shouldBe("Brasil")
            }
            it("El vecino mas poblado de Chile deberia ser Argentina"){
                Chile.vecinoMasPoblado().shouldBe("Argentina")
            }
            it("El vecino mas poblado de Brasil deberia ser el mismo"){
                Brasil.vecinoMasPoblado().shouldBe("Brasil")
            }
            it("El vecino mas poblado de Uruguay deberia ser Brasil"){
                Uruguay.vecinoMasPoblado().shouldBe("Brasil")
            }
        }


        describe("Paises limitrofes"){
            it("Brasil deberia limitar con Argentina"){
                Argentina.sonLimitrofes(Brasil).shouldBeTrue()
            }
            it("Argentina deberia limitar con Brasil"){
                Brasil.sonLimitrofes(Argentina).shouldBeTrue()
            }
            it("Chile no deberia limitar con Uruguay"){
                Uruguay.sonLimitrofes(Chile).shouldBeFalse()
            }
        }

        describe("Necesitan traduccion"){
            it("Argentina no deberia necesitar traduccion con Chile"){
                Argentina.necesitanTraduccion(Chile).shouldBeFalse()
            }
            it("Argentina no deberia necesitar traduccion con Uruguay"){
                Argentina.necesitanTraduccion(Uruguay).shouldBeFalse()
            }
            it("Argentina deberia necesitar traduccion con Brasil"){
                Argentina.necesitanTraduccion(Brasil).shouldBeTrue()
            }
        }

        describe("Son potenciales aliados"){
            it("Chile no deberia ser potencial Aliado de Brasil"){
                Brasil.sonPotencialesAliados(Chile).shouldBeFalse()
            }
            it("Uruguay no deberia ser potencial aliado de Chile"){
                Uruguay.sonPotencialesAliados(Chile).shouldBeFalse()
            }
            it("Argentina deberia ser potencial aliado de Uruguay"){
                Uruguay.sonPotencialesAliados(Argentina).shouldBeTrue()
            }
            it("Argentina no deberia ser potencial aliado de Brasil"){
                Argentina.sonPotencialesAliados(Brasil).shouldBeFalse()
            }
        }

        describe("Conviene ir de compras"){
            describe("A Brasil le conviene ir de compras a todos los paises "){
                it("A Brasil deberia convenirle ir de compras a Argentina"){
                    Brasil.convieneIrDeCompras(Argentina).shouldBeTrue()
                }
                it("A Brasil deberia convenirle ir de compras a Uruguay"){
                    Brasil.convieneIrDeCompras(Uruguay).shouldBeTrue()
                }
                it("A Brasil deberia convenirle ir de compras a Chile"){
                    Brasil.convieneIrDeCompras(Chile).shouldBeTrue()
                }
            }

            describe("A Chile no deberia convenirle ir a comprar a ningun pais"){
                it("A Chile no deberia convenirle ir de compras a Argentina"){
                    Chile.convieneIrDeCompras(Argentina).shouldBeFalse()
                }
                it("A Chile no deberia convenirle ir de compras a Brasil"){
                    Chile.convieneIrDeCompras(Brasil).shouldBeFalse()
                }
                it("A Chile no deberia convenirle ir de compras a Uruguay"){
                    Chile.convieneIrDeCompras(Uruguay).shouldBeFalse()
                }
            }
        }

        describe("A cuanto equivale"){
            it("100 pesos argentinos deberian ser 396.84"){
                Argentina.aCuantoEquivale(Chile, 100.0).shouldBe(396.84)
            }

            it("5 reales deberian ser 37.02 pesos Uruguayos"){
                Brasil.aCuantoEquivale(Uruguay, 5.0).shouldBe(37.03)
            }
        }
    }
})
