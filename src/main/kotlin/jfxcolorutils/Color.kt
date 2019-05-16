@file:Suppress(
    "RedundantVisibilityModifier",
    "unused"
)

package jfxcolorutils

import javafx.scene.paint.Color

/**
 *
 */
public fun isLightColor(color: Color): Boolean = !isDarkColor(color)

public fun isLightColor(color: String): Boolean = throw NotImplementedError()

/**
 *
 */
public fun isDarkColor(color: Color): Boolean = getBrightness(color) < 128

public fun isDarkColor(color: String): Boolean = throw NotImplementedError()

/**
 *
 */
public fun getBrightness(color: Color): Int {
    val rgb = toRGB(color)
    return (rgb.R * 299 + rgb.G * 587 + rgb.B * 114) / 1000
}

public fun getBrightness(color: String): Int = throw NotImplementedError()

/**
 *
 */
public fun toRGB(color: Color): RGB {
    val value = color.toString().split("x")[1]

    return RGB(
        Integer.valueOf(value.substring(0, 2), 16),
        Integer.valueOf(value.substring(2, 4), 16),
        Integer.valueOf(value.substring(4, 6), 16)
    )
}

public fun toRGB(color: String): RGB = throw NotImplementedError()

/**
 *
 */
public fun toRGBA(color: Color): RGBA {
    val value = color.toString().split("x")[1]

    return RGBA(
        Integer.valueOf(value.substring(0, 2), 16),
        Integer.valueOf(value.substring(2, 4), 16),
        Integer.valueOf(value.substring(4, 6), 16),
        Integer.valueOf(value.substring(6, 8), 16)
    )
}

public fun randomRGBColor(): RGB {
    throw NotImplementedError()
}

public fun randomRGBAColor(): RGBA {
    throw NotImplementedError()
}

public fun randomHTMLColor(): String {
    throw NotImplementedError()
}

public fun randomHEXColor(): String {
    throw NotImplementedError()
}

/**
 *
 */
public fun toHsv(color: String): HSV {
    var colorCode = color

    when {
        colorCode.startsWith("#", true) -> {
            colorCode = colorCode.substring(1)
            return htmlToHsv(colorCode)
        }
        colorCode.startsWith("0x", true) -> {
            colorCode = colorCode.substring(2)
            return hexToHsv(colorCode)
        }
        colorCode.startsWith("rgb(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbToHsv(colorCode)
        }
        colorCode.startsWith("rgba(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbaToHsv(colorCode)
        }
        colorCode.startsWith("hsv(", true) -> {
            colorCode = colorCode.substring(3)
            return hsvToHsv(colorCode)
        }
        colorCode.startsWith("hsl(", true) -> {
            colorCode = colorCode.substring(3)
            return hslToHsv(colorCode)
        }
        colorCode.startsWith("hsb(", true) -> {
            colorCode = colorCode.substring(3)
            return hsbToHsv(colorCode)
        }
        else -> {
            throw IllegalArgumentException("Invalid color specification.")
        }
    }
}

public fun toHtml(color: String) {

}

public fun toHex(color: String) {

}
