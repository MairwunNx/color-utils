package colorutils

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "unused"
)
public class HSV(
    public var h: Int,
    public var s: Int,
    public var v: Int
) {
    public override fun toString(): String {
        return "hsv($h, $s%, $v%)"
    }

    public fun toString(degreeIsVisible: Boolean): String {
        return when {
            degreeIsVisible -> "hsv($h°, $s%, $v%)"
            else -> toString()
        }
    }

    public override fun equals(other: Any?): Boolean {
        return if (other is HSV) {
            other.h == h && other.s == s && other.v == v
        } else false
    }

    override fun hashCode(): Int {
        var result = h
        result = 31 * result + s
        result = 31 * result + v
        return result
    }
}
