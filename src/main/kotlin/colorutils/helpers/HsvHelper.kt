package colorutils.helpers

import colorutils.HSV
import kotlin.math.roundToInt

internal fun numberToHsv(numberColor: String): HSV {
    throw NotImplementedError()
}

internal fun htmlToHsv(htmlColor: String): HSV {
    throw NotImplementedError()
}

internal fun hexToHsv(hexColor: String): HSV {
    throw NotImplementedError()
}

internal fun rgbToHsv(rgbColor: String): HSV {
    val color = rgbColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
    val colorArray = color.split(",")

    val r: Double = colorArray[0].toDouble() / 255
    val g: Double = colorArray[1].toDouble() / 255
    val b: Double = colorArray[2].toDouble() / 255

    val cMax: Double = maxOf(r, g, b)
    val cMin: Double = minOf(r, g, b)
    val delta: Double = cMax - cMin

    val h: Double = calculateH(r, g, b, delta)
    val s: Double = if (cMax < 0.00001) 0.0 else delta / cMax

    return HSV(
        h.roundToInt(),
        (s * 100).roundToInt(),
        (cMax * 100).roundToInt()
    )
}

internal fun rgbaToHsv(rgbaColor: String): HSV {
    throw NotImplementedError()
}

internal fun hsvToHsv(hsvColor: String): HSV {
    val color = hsvColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
        .replace("%", "")
        .replace("°", "")
    val colorArray = color.split(",")
    return HSV(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}

internal fun hslToHsv(hslColor: String): HSV {
    throw NotImplementedError()
}

internal fun hsbToHsv(hsbColor: String): HSV {
    val color = hsbColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
        .replace("%", "")
        .replace("°", "")
    val colorArray = color.split(",")
    return HSV(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}
