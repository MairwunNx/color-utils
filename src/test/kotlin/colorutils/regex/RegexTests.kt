package colorutils.regex

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class RegexTests {
    @Test
    internal fun rgbaRegexMatchDecimalRGBAndDecimalOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(255, 255, 255, 165)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchDecimalRGBAndDoubleOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(255, 255, 255, 0.6)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchDoubleRGBAndDoubleOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(0.4, 0.8, 0.1, 0.6)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchDoubleRGBAndDecimalOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(0.4, 0.8, 0.1, 255)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchDecimalRGBAndPercentageOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(255, 255, 255, 60%)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchPercentageRGBAndPercentageOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(40%, 50%, 75%, 60%)"),
            true
        )
    }

    @Test
    internal fun rgbaRegexMatchPercentageRGBAndDoubleOpacityTest() {
        Assertions.assertEquals(
            Regex(rgbaRegex.pattern, RegexOption.UNIX_LINES).matches("rgba(40%, 50%, 75%, 0.5)"),
            true
        )
    }
}
