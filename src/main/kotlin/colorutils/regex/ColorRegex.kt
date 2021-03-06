package colorutils.regex

public val rgbaRegex: Regex = Regex(
    "^rgba\\((?:(?<R>1?\\d?\\d|2[0-4]|25[0-5]|100%|\\d?[0-9]%|\\d?[0].\\d?[0-9]|\\d?[1].[0]|.\\d?[0-9])(?:, ?))(?:(?<G>1?\\d?\\d|2[0-4]|25[0-5]|100%|\\d?[0-9]%|\\d?[0].\\d?[0-9]|\\d?[1].[0]|.\\d?[0-9])(?:, ?))(?:(?<B>1?\\d?\\d|2[0-4]|25[0-5]|100%|\\d?[0-9]%|\\d?[0].\\d?[0-9]|\\d?[1].[0]|.\\d?[0-9])(?:, ?))(?:(?<A>1?\\d?\\d|2[0-4]|25[0-5]|100%|\\d?[0-9]%|\\d?[0].\\d?[0-9]|\\d?[1].[0]|.\\d?[0-9]))\\);?\$",
    RegexOption.IGNORE_CASE
)
