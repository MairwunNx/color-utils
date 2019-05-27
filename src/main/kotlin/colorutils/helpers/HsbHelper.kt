package colorutils.helpers

import colorutils.HSB
import colorutils.toRgb
import kotlin.math.roundToInt

internal fun hexToHsb(hexColor: String): HSB {
    return rgbToHsb(
        toRgb(hexColor).toString()
            .replace("rgb(", "")
            .replace(")", "")
    )
}

internal fun hex8ToHsb(hexColor: String, compensateOpacity: Boolean): HSB {
    throw NotImplementedError()
}

internal fun rgbToHsb(rgbColor: String): HSB {
    val color = removeUnnecessaryChars(rgbColor)
    val colorArray = color.split(",")
    val result = hsbAndHsvToRgb(colorArray)
    return HSB(
        result[0].roundToInt(),
        (result[1] * 100).roundToInt(),
        (result[2] * 100).roundToInt()
    )
}

internal fun rgbaToHsb(rgbaColor: String): HSB {
    throw NotImplementedError()
}

internal fun hsvToHsb(hsvColor: String): HSB {
    val color = removeUnnecessaryChars(hsvColor)
    val colorArray = color.split(",")
    return HSB(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}

internal fun hslToHsb(hslColor: String): HSB {
    throw NotImplementedError()
}

internal fun hsbToHsb(hsbColor: String): HSB {
    val color = removeUnnecessaryChars(hsbColor)
    val colorArray = color.split(",")
    return HSB(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}
