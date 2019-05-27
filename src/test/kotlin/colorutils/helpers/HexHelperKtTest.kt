package colorutils.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

internal class HexHelperKtTest {
    @Test
    internal fun completeColor1LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "EE0000",
                    completeColor("E")
            )
        }
        println("completeColor1LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor1Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "EE0000FF",
                    completeColor("E", true)
            )
        }
        println("completeColor1Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor2LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "AAAA00",
                    completeColor("AA")
            )
        }
        println("completeColor2LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor2Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "AAAA00FF",
                    completeColor("AA", true)
            )
        }
        println("completeColor2Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor3LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "555555",
                    completeColor("555")
            )
        }
        println("completeColor3LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor3Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "555555FF",
                    completeColor("555", true)
            )
        }
        println("completeColor3Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor4LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "121200",
                    completeColor("1212")
            )
        }
        println("completeColor4LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor4Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "121200FF",
                    completeColor("1212", true)
            )
        }
        println("completeColor4Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor5LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "456210",
                    completeColor("45621")
            )
        }
        println("completeColor5LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor5Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "456210FF",
                    completeColor("45621", true)
            )
        }
        println("completeColor5Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor6LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "666666",
                    completeColor("666666")
            )
        }
        println("completeColor6LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor6Hex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "666666FF",
                    completeColor("666666", true)
            )
        }
        println("completeColor6Hex8LengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor6AndMoreLengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "DFDF96",
                    completeColor("DFDF96AAF")
            )
        }
        println("completeColor6AndMoreLengthTest done with ${elapsed}ms.")
    }

    @Test
    internal fun completeColor6AndMoreHex8LengthTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                    "DFDF96D6",
                    completeColor("DFDF96D6FE", true)
            )
        }
        println("completeColor6AndMoreHex8LengthTest done with ${elapsed}ms.")
    }
}
