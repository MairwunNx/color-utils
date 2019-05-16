package jfxcolorutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HsvTests {
    private val rgbColor: String = "rgb(0, 118, 214)"
    private val hsvColor: String = "hsv(207, 100%, 84%)"
    private val hsvColorDegree: String = "hsv(207°, 100%, 84%)"

    @Test
    fun convertRgbToHsv() {
        assertEquals(
            hsvColor,
            toHsv(rgbColor).toString()
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
}
