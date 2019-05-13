@file:Suppress(
    "RedundantVisibilityModifier",
    "unused"
)

package jfxcolorutils

import javafx.scene.paint.Color

public fun isLightColor(color: Color): Boolean = !isDarkColor(color)

public fun isLightColor(colorCode: String): Boolean = !isDarkColor(colorCode)

public fun isDarkColor(color: Color): Boolean {
    throw NotImplementedError()
}

public fun isDarkColor(colorCode: String): Boolean {
    throw NotImplementedError()
}

public fun toRGB(color: Color): RGB {
    val value = color.toString().split("x")[1]

    return RGB(
        Integer.valueOf(value.substring(0, 2), 16),
        Integer.valueOf(value.substring(2, 4), 16),
        Integer.valueOf(value.substring(4, 6), 16)
    )
}

public fun toRGB(colorCode: String): RGB {
    throw NotImplementedError()
}

public fun toRGBA(color: Color): RGBA {
    val value = color.toString().split("x")[1]

    return RGBA(
        Integer.valueOf(value.substring(0, 2), 16),
        Integer.valueOf(value.substring(2, 4), 16),
        Integer.valueOf(value.substring(4, 6), 16),
        Integer.valueOf(value.substring(6, 8), 16)
    )
}

public fun toRGBA(colorCode: String): RGBA {
    throw NotImplementedError()
}

public fun toHTML(color: Color): String {
    throw NotImplementedError()
}

public fun toHTML(colorCode: String): String {
    throw NotImplementedError()
}

public fun toHEX(color: Color): String {
    throw NotImplementedError()
}

public fun toHEX(colorCode: String): String {
    throw NotImplementedError()
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
