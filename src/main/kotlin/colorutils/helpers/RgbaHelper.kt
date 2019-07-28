package colorutils.helpers

import colorutils.RGBA

internal fun hexToRgba(hexColor: String): RGBA {
    val color = completeColor(hexColor, true)
    return RGBA(
        Integer.valueOf(color.substring(0, 2), 16),
        Integer.valueOf(color.substring(2, 4), 16),
        Integer.valueOf(color.substring(4, 6), 16),
        Integer.valueOf(color.substring(6, 8), 16)
    )
}

internal fun hex8ToRgba(hex8Color: String): RGBA {
    val color = completeColor(hex8Color, true)
    return RGBA(
        Integer.valueOf(color.substring(0, 2), 16),
        Integer.valueOf(color.substring(2, 4), 16),
        Integer.valueOf(color.substring(4, 6), 16),
        Integer.valueOf(color.substring(6, 8), 16)
    )
}

internal fun rgbaToRgba(rgbaColor: String): RGBA {
    val color =
        removeUnnecessaryChars(rgbaColor)
            .split(",")
            .toMutableList()

    for (i in 0..3) {
        if (color[i].isEmpty()) {
            color[i] = "0"
        }
    }

    return RGBA(
        color[0].toInt(), color[1].toInt(), color[2].toInt(), color[3].toInt()
    )
}
