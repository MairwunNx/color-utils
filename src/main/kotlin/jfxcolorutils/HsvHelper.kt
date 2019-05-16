package jfxcolorutils

import kotlin.math.roundToInt

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

    var h = 0.0
    val s: Double
    val v: Double

    val cMax: Double = maxOf(r, g, b)
    val cMin: Double = minOf(r, g, b)
    val delta: Double = cMax - cMin

    v = cMax

    s = when {
        cMax <= 0.00001 -> 0.0
        else -> delta / cMax
    }

    if (s == 0.0) {
        h = 0.0
    } else {
        when {
            r == cMax -> h = ((g - b) / delta)
            g == cMax -> h = 2 + (b - r) / delta
            b == cMax -> h = 4 + (r - g) / delta
        }

        h *= 60

        if (h < 0.0) {
            h += 360
        }
    }

    return HSV(
        h.roundToInt(),
        (s * 100).roundToInt(),
        (v * 100).roundToInt()
    )
}

internal fun rgbaToHsv(rgbaColor: String): HSV {
    throw NotImplementedError()
}

internal fun hsvToHsv(hsvColor: String): HSV {
    throw NotImplementedError()
}

internal fun hslToHsv(hslColor: String): HSV {
    throw NotImplementedError()
}

internal fun hsbToHsv(hsbColor: String): HSV {
    throw NotImplementedError()
}

