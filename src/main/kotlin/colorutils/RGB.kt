package colorutils

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
