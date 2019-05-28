package colorutils

import javafx.scene.paint.Color
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ColorKtTest {
    private val colorRGB: Color = Color.web("0078D7")
    private val colorRGBA: Color = Color(
        0.0,
        0.120,
        0.215,
        0.6
    )

    @Test
    fun hexToRgbaTest() {
        assertEquals(
            "rgba(85, 102, 68, 255)",
            toRgba("564").toString() // #556644
        )
    }

    @Test
    fun hex8ToRgbaTest() {
        assertEquals(
            "rgba(85, 102, 68, 230)",
            toRgba("556644E6").toString() // #556644
        )
    }

//    @Test
//    fun validateToRGB() {
//        assertEquals(
//            RGB(
//                (colorRGB.red * 255).roundToInt(),
//                (colorRGB.green * 255).roundToInt(),
//                (colorRGB.blue * 255).roundToInt()
//            ), toRGB(colorRGB)
//        )
//    }

//    @Test
//    fun validateRGBToString() {
//        assertEquals(
//            "rgb(${(colorRGB.red * 255).roundToInt()}, ${(colorRGB.green * 255).roundToInt()}, ${(colorRGB.blue * 255).roundToInt()})",
//            toRGB(colorRGB).toString()
//        )
//    }

//    @Test
//    fun validateToRGBA() {
//        assertEquals(
//            RGBA(
//                (colorRGBA.red * 255).roundToInt(),
//                (colorRGBA.green * 255).roundToInt(),
//                (colorRGBA.blue * 255).roundToInt(),
//                (colorRGBA.opacity * 255).roundToInt()
//            ), toRGBA(colorRGBA)
//        )
//    }

//    @Test
//    fun validateRGBAToString() {
//        assertEquals(
//            "rgba(${(colorRGBA.red * 255).roundToInt()}, ${(colorRGBA.green * 255).roundToInt()}, ${(colorRGBA.blue * 255).roundToInt()}, ${(colorRGBA.opacity * 255).roundToInt()})",
//            toRGBA(colorRGBA).toString()
//        )
//    }

//    @Test
//    fun validateRGBAToStringDouble() {
//        assertEquals(
//            "rgba(${(colorRGBA.red * 255).roundToInt()}, ${(colorRGBA.green * 255).roundToInt()}, ${(colorRGBA.blue * 255).roundToInt()}, ${Math.round(
//                colorRGBA.opacity * 100
//            ) / 100.0})",
//            toRGBA(colorRGBA).toString(RGBAOpacityFormat.DOUBLE)
//        )
//    }

//    @Test
//    fun validateRGBAToStringPercentage() {
//        assertEquals(
//            "rgba(${(colorRGBA.red * 255).roundToInt()}, ${(colorRGBA.green * 255).roundToInt()}, ${(colorRGBA.blue * 255).roundToInt()}, ${(colorRGBA.opacity * 100).roundToInt()}%)",
//            toRGBA(colorRGBA).toString(RGBAOpacityFormat.PERCENTAGE)
//        )
//    }
}
