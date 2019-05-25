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
public fun toHex(color: String, compensateOpacity: Boolean = false): String {
    throw NotImplementedError()
}

/**
 *
 */
public fun toHex8(color: String): String {
    throw NotImplementedError()
}

/**
 *
 */
public fun toRgb(color: String, compensateOpacity: Boolean = false): RGB {
    var colorCode = color

    when {
        colorCode.matches(Regex("^#([A-Fa-f0-9]*)|([A-Fa-f0-9]*)|0x([A-Fa-f0-9]*)$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return hexToRgb(colorCode)
        }
        else -> {
            throw IllegalArgumentException("Not supported color specification.")
        }
    }
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
public fun toHsv(color: String, compensateOpacity: Boolean = false): HSV {
    var colorCode = color

    when {
        colorCode.matches(Regex("^#([A-Fa-f0-9]*)|([A-Fa-f0-9]*)|0x([A-Fa-f0-9]*)$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return hexToHsv(colorCode)
        }
        colorCode.matches(Regex("^#([A-Fa-f0-9]{8})|([A-Fa-f0-9]{8})|0x([A-Fa-f0-9]{8})$")) -> {
            colorCode = colorCode
                .replace("#", "")
                .replace("0x", "")
            return hex8ToHsv(colorCode, compensateOpacity)
        }
        colorCode.startsWith("rgb(", true) -> {
            colorCode = colorCode.substring(3)
            // done
            return rgbToHsv(colorCode)
        }
        colorCode.startsWith("rgba(", true) -> {
            colorCode = colorCode.substring(4)
            return rgbaToHsv(colorCode, compensateOpacity)
        }
        colorCode.startsWith("hsv(", true) -> {
            colorCode = colorCode.substring(3)
            return hsvToHsv(colorCode)
        }
        colorCode.startsWith("hsva(", true) -> {
            colorCode = colorCode.substring(4)
            return hsvaToHsv(colorCode, compensateOpacity)
        }
        colorCode.startsWith("hsb(", true) -> {
            colorCode = colorCode.substring(3)
            return hsbToHsv(colorCode)
        }
        colorCode.startsWith("hsba(", true) -> {
            colorCode = colorCode.substring(4)
            return hsbaToHsv(colorCode, compensateOpacity)
        }
        colorCode.startsWith("hsl(", true) -> {
            colorCode = colorCode.substring(3)
            return hslToHsv(colorCode)
        }
        colorCode.startsWith("hsla(", true) -> {
            colorCode = colorCode.substring(3)
            return hslaToHsv(colorCode, compensateOpacity)
        }
        else -> {
            throw IllegalArgumentException("Not supported color specification.")
        }
    }
}

/**
 *
 */
//public fun toHsva(color: String): HSVA {
//    throw NotImplementedError()
//}

/**
 *
 */
public fun toHsb(color: String, compensateOpacity: Boolean = false): HSB {
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
//public fun toHsba(color: String): HSBA {
//    throw NotImplementedError()
//}

/**
 *
 */
public fun toHsl(color: String, compensateOpacity: Boolean = false): HSL {
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

/**
 *
 */
//public fun toHsla(color: String): HSLA {
//    throw NotImplementedError()
//}
