package colorutils.helpers

import colorutils.RGB
import colorutils.toRgb
import colorutils.toRgba

internal fun hexToRgb(hexColor: String): RGB {
    val color = completeColor(hexColor)
    return RGB(
        Integer.valueOf(color.substring(0, 2), 16),
        Integer.valueOf(color.substring(2, 4), 16),
        Integer.valueOf(color.substring(4, 6), 16)
    )
}

internal fun hex8ToRgb(
    hex8Color: String,
    compensateOpacity: Boolean,
    opacityBackground: String
): RGB {
    return if (compensateOpacity) {
        compensateOpacity(
            toRgba(hex8Color),
            toRgb(opacityBackground)
        )
    } else {
        toRgb(hex8Color.dropLast(2))
    }
}
