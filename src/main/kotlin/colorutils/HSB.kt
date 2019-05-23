package colorutils

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "unused"
)
public class HSB(
    public val h: Int,
    public val s: Int,
    public val b: Int
) {
    public override fun toString(): String {
        return "hsb($h, $s%, $b%)"
    }

    public fun toString(degreeIsVisible: Boolean): String {
        return when {
            degreeIsVisible -> "hsb($h°, $s%, $b%)"
            else -> toString()
        }
    }

    public override fun equals(other: Any?): Boolean {
        return if (other is HSB) {
            other.h == h && other.s == s && other.b == b
        } else false
    }

    override fun hashCode(): Int {
        var result = h
        result = 31 * result + s
        result = 31 * result + b
        return result
    }
}
