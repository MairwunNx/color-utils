package colorutils.helpers

private const val defaultColor = "0"
private const val defaultOpacity = "F"

internal fun completeColor(color: String, isHex8: Boolean = false): String {
    when {
        color.matches(Regex("^[A-Fa-f0-9]$")) -> return buildString {
            for (it in 0..7) {
                if (it in 0..1) {
                    this.append(color)
                } else if (it in 2..5) {
                    this.append(defaultColor)
                } else if (it in 6..7 && isHex8) {
                    this.append(defaultOpacity)
                }
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{2}$")) -> return buildString {
            for (it in 0..7) {
                if (it in 0..1) {
                    this.append(color[0])
                } else if (it in 2..3) {
                    this.append(color[1])
                } else if (it in 4..5) {
                    this.append(defaultColor)
                } else if (it in 6..7 && isHex8) {
                    this.append(defaultOpacity)
                }
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{3}$")) -> return buildString {
            for (it in 0..7) {
                if (it in 0..1) {
                    this.append(color[0])
                } else if (it in 2..3) {
                    this.append(color[1])
                } else if (it in 4..5) {
                    this.append(color[2])
                } else if (it in 6..7 && isHex8) {
                    this.append(defaultOpacity)
                }
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{4}$")) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(defaultColor, defaultColor)
            if (isHex8) {
                this.append(defaultOpacity, defaultOpacity)
            }
        }
        color.matches(Regex("^[A-Fa-f0-9]{5}$")) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(color[4], defaultColor)
            if (isHex8) {
                this.append(defaultOpacity, defaultOpacity)
            }
        }
        (color.matches(Regex("^[A-Fa-f0-9]*$")) && color.length >= 6) -> return buildString {
            this.append(color[0], color[1])
            this.append(color[2], color[3])
            this.append(color[4], color[5])
            if (isHex8 && color.length == 6) {
                this.append(defaultOpacity, defaultOpacity)
            } else if (isHex8 && color.length == 7) {
                this.append(color[6], color[6])
            } else if (isHex8 && color.length >= 8) {
                this.append(color[6], color[7])
            }
        }
        else -> return buildString {
            if (color[0].toString().matches(Regex("^[A-Fa-f0-9]$"))) {
                for (it in 0..7) {
                    if (it in 0..5) {
                        this.append(color[0])
                    } else if (it in 6..7 && isHex8) {
                        this.append(defaultOpacity)
                    }

                }
            } else {
                for (it in 0..7) {
                    if (it in 0..5) {
                        this.append(defaultColor)
                    } else if (it in 6..7 && isHex8) {
                        this.append(defaultOpacity)
                    }
                }
            }
        }
    }
}
