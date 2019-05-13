package jfxcolorutils

import kotlin.math.roundToInt

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "unused"
)
public class RGBA(
    public val R: Int,
    public val G: Int,
    public val B: Int,
    public val A: Int
) {
    public override fun toString(): String {
        return "rgba($R, $G, $B, $A)"
    }

    public fun toString(opacityFormat: RGBAOpacityFormat): String {
        return when (opacityFormat) {
            RGBAOpacityFormat.INTEGER -> "rgba($R, $G, $B, $A)"
            RGBAOpacityFormat.DOUBLE -> "rgba($R, $G, $B, ${Math.round((A / 2.55 / 100) * 100) / 100.0})"
            RGBAOpacityFormat.PERCENTAGE -> "rgba($R, $G, $B, ${(A / 2.55).roundToInt()}%)"
        }
    }

    public override fun equals(other: Any?): Boolean {
        if (other is RGBA) {
            return other.R == R && other.G == G && other.B == B && other.A == A
        }

        return false
    }
}
