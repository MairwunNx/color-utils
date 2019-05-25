package colorutils.helpers

private const val defaultColor = "00"

internal fun completeColor(color: String): String {
    when {
        color.matches(Regex("^[A-Fa-f0-9]$")) -> return buildString {
            for (it in 0..5) {
                this.append(color)
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{2}$")) -> return buildString {
            for (it in 0..5) {
                if (it in 0..1) {
                    this.append(color[0])
                }
                if (it in 2..3) {
                    this.append(color[1])
                }
                if (it in 3..4) {
                    this.append(defaultColor)
                }
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{3}$")) -> return buildString {
            for (it in 0..5) {
                if (it in 0..1) {
                    this.append(color[0])
                }
                if (it in 2..3) {
                    this.append(color[1])
                }
                if (it in 3..4) {
                    this.append(color[2])
                }
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{4}$")) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(defaultColor, defaultColor)
        }
        color.matches(Regex("^[A-Fa-f0-9]{5}$")) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(color[4], defaultColor)
        }
        (color.matches(Regex("^[A-Fa-f0-9]*$")) && color.length >= 6) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(color[4], color[5])
        }
        else -> return buildString {
            if (color[0].toString().matches(Regex("^[A-Fa-f0-9]$"))) {
                for (it in 0..5) {
                    this.append(color[0])
                }
            } else {
                for (it in 0..5) {
                    this.append(defaultColor)
                }
            }
        }
    }
}
