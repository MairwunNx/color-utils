package colorutils.helpers

internal fun calculateH(
    r: Double,
    g: Double,
    b: Double,
    delta: Double
): Double {
    return when {
        r == b && g == b -> 0.0
        r >= g && r >= b -> calculateHueTerm(0, g, b, delta)
        g >= r && g >= b -> calculateHueTerm(2, b, r, delta)
        else -> calculateHueTerm(4, r, g, delta)
    }
}

internal fun calculateHueTerm(
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
