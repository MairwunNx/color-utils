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
}
