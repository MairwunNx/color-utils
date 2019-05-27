package colorutils.helpers

import colorutils.RGB
import colorutils.RGBA
import kotlin.math.roundToInt

internal fun calculateHue(
    r: Double,
    g: Double,
    b: Double,
    delta: Double
): Double {
    return when {
        r == b && g == b -> 0.0
        r >= g && r >= b -> calculateHueOffset(0, g, b, delta)
        g >= r && g >= b -> calculateHueOffset(2, b, r, delta)
        else -> calculateHueOffset(4, r, g, delta)
    }
}

internal fun calculateHueOffset(
    s: Int,
    g: Double,
    b: Double,
    delta: Double
): Double {
    val res = 60 * (s + (g - b) / delta)
    return if (res > 0) res else res + 360
}

internal fun removeUnnecessaryChars(color: String): String = color
    .replace("(", "")
    .replace(")", "")
    .replace(" ", "")
    .replace("%", "")
    .replace("°", "")

internal fun hsbAndHsvToRgb(rgbColorList: List<String>): Array<Double> {
    val r: Double = rgbColorList[0].toDouble() / 255
    val g: Double = rgbColorList[1].toDouble() / 255
    val b: Double = rgbColorList[2].toDouble() / 255

    val cMax: Double = maxOf(r, g, b)
    val cMin: Double = minOf(r, g, b)
    val delta: Double = cMax - cMin

    val h: Double = calculateHue(r, g, b, delta)
    val s: Double = if (cMax < 0.00001) 0.0 else delta / cMax

    return arrayOf(h, s, cMax)
}

internal fun compensateOpacity(
    rgbaColor: RGBA,
    rgbBackgroundColor: RGB
): RGB {
    val rb = rgbBackgroundColor.r / 255.0
    val gb = rgbBackgroundColor.g / 255.0
    val bb = rgbBackgroundColor.b / 255.0
    val a = rgbaColor.a / 255.0
    val r = rgbaColor.r / 255.0
    val g = rgbaColor.g / 255.0
    val b = rgbaColor.b / 255.0
    return RGB(
        (((1 - a) * rb + a * r) * 255).roundToInt(),
        (((1 - a) * gb + a * g) * 255).roundToInt(),
        (((1 - a) * bb + a * b) * 255).roundToInt()
    )
}
