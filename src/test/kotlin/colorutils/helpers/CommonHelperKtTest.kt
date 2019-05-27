package colorutils.helpers

import colorutils.RGB
import colorutils.RGBA
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

internal class CommonHelperKtTest {
    @Test
    internal fun compensateOpacityTest() {
        val elapsed = measureTimeMillis {
            assertEquals(
                "rgb(64, 64, 64)",
                compensateOpacity(
                    RGBA(43, 43, 43, 230),
                    RGB(255, 255, 255)
                ).toString()
            )
        }
        println("compensateOpacityTest done with ${elapsed}ms.")
    }
}
