package colorutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RgbTests {
    @Test
    fun rgbToString() {
        assertEquals(
            "rgb(155, 155, 155)",
            RGB(155, 155, 155).toString()
        )
    }

    @Test
    fun rgbToStringDouble() {
        assertEquals(
            "rgb(0.6, 0.6, 0.6)",
            RGB(155, 155, 155).toString(RGBOutputFormat.DOUBLE)
        )
    }

    @Test
    fun rgbToStringPercentage() {
        assertEquals(
            "rgb(61%, 61%, 61%)",
            RGB(155, 155, 155).toString(RGBOutputFormat.PERCENTAGE)
        )
    }
}
