package colorutils.helpers

import colorutils.HSV
import colorutils.toRgb
import kotlin.math.roundToInt

internal fun hexToHsv(hexColor: String): HSV = rgbToHsv(
    toRgb(hexColor).toString().removeSurrounding("rgb(", ")")
)

internal fun hex8ToHsv(
    hex8Color: String,
    compensateOpacity: Boolean,
    opacityBackground: String = "#fff"
): HSV {
    return if (!compensateOpacity) {
        hexToHsv(hex8Color)
    } else {
        rgbToHsv(toRgb(
            hex8Color,
            compensateOpacity,
            opacityBackground
        ).toString().removeSurrounding("rgb(", ")"))
    }
}

internal fun rgbToHsv(rgbColor: String): HSV {
    val color = removeUnnecessaryChars(rgbColor)
    val colorArray = color.split(",")
    val result = hsbAndHsvToRgb(colorArray)
    return HSV(
        result[0].roundToInt(),
        (result[1] * 100).roundToInt(),
        (result[2] * 100).roundToInt()
    )
}

internal fun rgbaToHsv(rgbaColor: String, compensateOpacity: Boolean): HSV {
    throw NotImplementedError()
}

internal fun hsvToHsv(hsvColor: String): HSV {
    val color = removeUnnecessaryChars(hsvColor)
    val colorArray = color.split(",")
    return HSV(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}

internal fun hsvaToHsv(hsvaColor: String, compensateOpacity: Boolean): HSV {
    throw NotImplementedError()
}


internal fun hsbToHsv(hsbColor: String): HSV {
    val color = removeUnnecessaryChars(hsbColor)
    val colorArray = color.split(",")
    return HSV(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}

internal fun hsbaToHsv(hsbaColor: String, compensateOpacity: Boolean): HSV {
    throw NotImplementedError()
}

internal fun hslToHsv(hslColor: String): HSV {
    throw NotImplementedError()
}

internal fun hslaToHsv(hslaColor: String, compensateOpacity: Boolean): HSV {
    throw NotImplementedError()
}
