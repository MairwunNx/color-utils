package colorutils.helpers

import colorutils.RGB

internal fun hexToRgb(hexColor: String): RGB {
    val color = completeColor(hexColor)
    return RGB(
        Integer.valueOf(color.substring(0, 2), 16),
        Integer.valueOf(color.substring(2, 4), 16),
        Integer.valueOf(color.substring(4, 6), 16)
    )
}
