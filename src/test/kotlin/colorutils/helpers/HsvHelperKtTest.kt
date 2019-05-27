package colorutils.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

internal class HsvHelperKtTest {
    @Test
    internal fun hexToHsvTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                "hsv(0, 0%, 17%)",
                hexToHsv("2b2b2b").toString()
            )
        }
        println("hexToHsvTest done with ${elapsed}ms.")
    }

    @Test
    internal fun hex8WithoutOpacityWithoutCompensateOpacityToHsvTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                "hsv(0, 0%, 17%)",
                hex8ToHsv("2b2b2b", false).toString()
            )
        }
        println("hex8WithoutOpacityWithoutCompensateOpacityToHsvTest done with ${elapsed}ms.")
    }

    @Test
    internal fun hex8WithOpacityWithoutCompensateOpacityToHsvTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                "hsv(0, 0%, 17%)",
                hex8ToHsv("2b2b2b66", false).toString()
            )
        }
        println("hex8WithOpacityWithoutCompensateOpacityToHsvTest done with ${elapsed}ms.")
    }

    @Test
    internal fun hex8WithoutOpacityWithCompensateOpacityToHsvTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                "hsv(0, 0%, 17%)",
                hex8ToHsv("2b2b2b", true).toString()
            )
        }
        println("hex8WithoutOpacityWithCompensateOpacityToHsvTest done with ${elapsed}ms.")
    }

    @Test
    internal fun hex8WithOpacityWithCompensateOpacityToHsvTest() {
        val elapsed = measureTimeMillis {
            Assertions.assertEquals(
                "hsv(0, 0%, 25%)",
                hex8ToHsv("2b2b2be6", true).toString()
            )
        }
        println("hex8WithOpacityWithCompensateOpacityToHsvTest done with ${elapsed}ms.")
    }
}
