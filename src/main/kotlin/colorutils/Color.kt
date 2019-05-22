@file:Suppress(
    "RedundantVisibilityModifier",
    "unused"
)

// todo: add cmy and cmyk color conversions.

package colorutils

import colorutils.helpers.*
import javafx.scene.paint.Color

/**
 *
 */
public fun isLightColor(color: String): Boolean = !isDarkColor(color)

/**
 *
 */
public fun isDarkColor(color: String): Boolean = getBrightness(color) < 128

/**
 *
 */
public fun getBrightness(color: String): Int {
    //val rgb = toRGB(color)
    //return (rgb.r * 299 + rgb.g * 587 + rgb.b * 114) / 1000
    throw NotImplementedError()
}

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
public fun toHtml(color: String): String {
    throw NotImplementedError()
}

/**
 *
 */
public fun toHex(color: String): String {
    throw NotImplementedError()
}

/**
 *
 */
public fun toRgb(color: String): RGB {
    throw NotImplementedError()
}

/**
 *
 */
public fun toRgba(color: String): RGBA {
    throw NotImplementedError()
}

/**
 *
 */
public fun toHsv(color: String): HSV {
    var colorCode = color

    when {
        colorCode.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|0x([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
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
        colorCode.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|0x([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return numberToHsv(colorCode)
        }
        else -> {
            throw IllegalArgumentException("Invalid color specification.")
        }
    }
}

/**
 *
 */
public fun toHsb(color: String): HSB {
    var colorCode = color

    when {
        colorCode.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|0x([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return hexToHsb(colorCode)
        }
        colorCode.startsWith("rgb(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbToHsb(colorCode)
        }
        colorCode.startsWith("rgba(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbaToHsb(colorCode)
        }
        colorCode.startsWith("hsv(", true) -> {
            colorCode = colorCode.substring(3)
            return hsvToHsb(colorCode)
        }
        colorCode.startsWith("hsl(", true) -> {
            colorCode = colorCode.substring(3)
            return hslToHsb(colorCode)
        }
        colorCode.startsWith("hsb(", true) -> {
            colorCode = colorCode.substring(3)
            return hsbToHsb(colorCode)
        }
        colorCode.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|0x([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return numberToHsb(colorCode)
        }
        else -> {
            throw IllegalArgumentException("Invalid color specification.")
        }
    }
}

/**
 *
 */
public fun toHsl(color: String): HSL {
    var colorCode = color

    when {
        colorCode.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})|0x([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return hexToHsl(colorCode)
        }
        colorCode.startsWith("rgb(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbToHsl(colorCode)
        }
        colorCode.startsWith("rgba(", true) -> {
            colorCode = colorCode.substring(3)
            return rgbaToHsl(colorCode)
        }
        colorCode.startsWith("hsv(", true) -> {
            colorCode = colorCode.substring(3)
            return hsvToHsl(colorCode)
        }
        colorCode.startsWith("hsl(", true) -> {
            colorCode = colorCode.substring(3)
            return hslToHsl(colorCode)
        }
        colorCode.startsWith("hsb(", true) -> {
            colorCode = colorCode.substring(3)
            return hsbToHsl(colorCode)
        }
        else -> {
            throw IllegalArgumentException("Invalid color specification.")
        }
    }
}
