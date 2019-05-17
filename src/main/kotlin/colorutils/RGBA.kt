package colorutils

import kotlin.math.roundToInt

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "unused"
)
public class RGBA(
    public val r: Int,
    public val g: Int,
    public val b: Int,
    public val a: Int
) {
    public override fun toString(): String {
        return "rgba($r, $g, $b, $a)"
    }

    public fun toString(opacityFormat: RGBAOpacityFormat): String {
        return when (opacityFormat) {
            RGBAOpacityFormat.INTEGER -> "rgba($r, $g, $b, $a)"
            RGBAOpacityFormat.DOUBLE -> "rgba($r, $g, $b, ${Math.round((a / 2.55 / 100) * 100) / 100.0})"
            RGBAOpacityFormat.PERCENTAGE -> "rgba($r, $g, $b, ${(a / 2.55).roundToInt()}%)"
        }
    }

    public override fun equals(other: Any?): Boolean {
        if (other is RGBA) {
            return other.r == r && other.g == g && other.b == b && other.a == a
        }

        return false
    }

    override fun hashCode(): Int {
        var result = r
        result = 31 * result + g
        result = 31 * result + b
        result = 31 * result + a
        return result
    }
}
