package colorutils

import kotlin.math.roundToInt

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate"
)
public class RGB(
    public val r: Int,
    public val g: Int,
    public val b: Int
) {
    public override fun toString(): String = "rgb($r, $g, $b)"

    public fun toString(format: RGBOutputFormat): String {
        return when (format) {
            RGBOutputFormat.INTEGER -> toString()
            RGBOutputFormat.DOUBLE -> "rgb(${((r.toDouble() / 255 * 100.00).toInt() / 100.00)}, ${((g.toDouble() / 255 * 100.00).toInt() / 100.00)}, ${((b.toDouble() / 255 * 100.00).toInt() / 100.00)})"
            RGBOutputFormat.PERCENTAGE -> "rgb(${((r.toDouble() / 255) * 100).roundToInt()}%, ${((g.toDouble() / 255) * 100).roundToInt()}%, ${((b.toDouble() / 255) * 100).roundToInt()}%)"
        }
    }

    public override fun equals(other: Any?): Boolean {
        if (other is RGB) {
            return other.r == r && other.g == g && other.b == b
        }

        return false
    }

    override fun hashCode(): Int {
        var result = r
        result = 31 * result + g
        result = 31 * result + b
        return result
    }
}
