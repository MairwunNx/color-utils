package jfxcolorutils

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate"
)
public class RGB(
    public val R: Int,
    public val G: Int,
    public val B: Int
) {
    public override fun toString(): String = "rgb($R, $G, $B)"

    public override fun equals(other: Any?): Boolean {
        if (other is RGB) {
            return other.R == R && other.G == G && other.B == B
        }

        return false
    }
}
