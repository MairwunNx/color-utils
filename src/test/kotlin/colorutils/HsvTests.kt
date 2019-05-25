package colorutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

internal class HsvTests {
    private val hexColor: String = "#0078D7"
    private val rgbColor: String = "rgb(0, 118, 214)"
    private val hsvColor: String = "hsv(207, 100%, 84%)"
    private val hsvColorDegree: String = "hsv(207°, 100%, 84%)"

    @Test
    fun convertHexToHsv() {
        val elapsed = measureTimeMillis {
            toHsv(hexColor).toString()
        }
        println("convertHexToHsv: Done with $elapsed ms.")

        assertEquals(
            "hsv(207, 100%, 84%)",
            toHsv(hexColor).toString()
        )
    }

    @Test
    fun convertRgbToHsv() {
        assertEquals(
            hsvColor,
            toHsv(rgbColor).toString()
        )
    }

    @Test
    fun convertHsvToHsv() {
        assertEquals(
            hsvColor,
            toHsv(hsvColor).toString()
        )
    }

    @Test
    fun convertHsbToHsv() {
        assertEquals(
            "hsv(27, 84%, 100%)",
            toHsv("hsb(27°, 84%, 100%)").toString()
        )
    }

    @Test
    fun convertHsbToHsvWithDegree() {
        assertEquals(
            "hsv(27°, 84%, 100%)",
            toHsv("hsb(27°, 84%, 100%)").toString(true)
        )
    }

    @Test
    fun convertRgbToHsvWithDegree() {
        assertEquals(
            hsvColorDegree,
            toHsv(rgbColor).toString(true)
        )
    }

    @Test
    fun equalsHsvClasses() {
        assertEquals(
            HSV(207, 100, 84),
            HSV(207, 100, 84)
        )
    }

    @Test
    fun hashCodeEqualsHsvClasses() {
        assertEquals(
            HSV(207, 100, 84).hashCode(),
            HSV(207, 100, 84).hashCode()
        )
    }

    @Test
    fun invalidColor() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            toHsv("hwb(0, 17, 83)")
        }
        assertEquals("Not supported color specification.", exception.message)
    }
}
