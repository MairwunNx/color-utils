package colorutils.helpers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.system.measureTimeMillis

internal class RgbHelperKtTest {
    @Test
    internal fun hexToRgbTest() {
        val elapsed = measureTimeMillis {
            assertEquals(
                "rgb(34, 0, 0)",
                hexToRgb("2").toString()
            )
        }
        println("hexToRgbTest done with ${elapsed}ms.")
    }
}
