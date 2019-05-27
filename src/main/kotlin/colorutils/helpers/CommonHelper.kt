package colorutils.helpers

internal fun calculateH(
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

    val h: Double = calculateH(r, g, b, delta)
    val s: Double = if (cMax < 0.00001) 0.0 else delta / cMax

    return arrayOf(h, s, cMax)
}
