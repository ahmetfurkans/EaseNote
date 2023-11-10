package com.galataapplab.easenote.core.util

import java.util.regex.Pattern

fun removeHtmlTags(htmlContent: String): String {
    val pattern = Pattern.compile("<[^>]+>")
    return pattern.matcher(htmlContent).replaceAll("")
}