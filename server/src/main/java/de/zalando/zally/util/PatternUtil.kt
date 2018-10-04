package de.zalando.zally.util

/**
 * Utility library for matching common patterns
 */
object PatternUtil {

    private val CAMEL_CASE_PATTERN = "^[a-z]+(?:[A-Z][a-z]+)*$".toRegex()
    private val PASCAL_CASE_PATTERN = "^[A-Z][a-z]+(?:[A-Z][a-z]+)*$".toRegex()
    private val HYPHENATED_CAMEL_CASE_PATTERN = "^[a-z]+(?:-[A-Z][a-z]+)*$".toRegex()
    private val PATH_VARIABLE_PATTERN = "\\{.+}$".toRegex()
    private val APPLICATION_PROBLEM_JSON_PATTERN = "^application/(problem\\+)?json$".toRegex()
    private val CUSTOM_WITH_VERSIONING_PATTERN = "^\\w+/[-+.\\w]+;v(ersion)?=\\d+$".toRegex()

    fun hasTrailingSlash(input: String): Boolean = input.trim { it <= ' ' }.endsWith("/")

    fun isPathVariable(input: String): Boolean = input.matches(PATH_VARIABLE_PATTERN)

    fun isCamelCase(input: String): Boolean = input.matches(CAMEL_CASE_PATTERN)

    fun isPascalCase(input: String): Boolean = input.matches(PASCAL_CASE_PATTERN)

    fun isHyphenatedCamelCase(input: String): Boolean = input.matches(HYPHENATED_CAMEL_CASE_PATTERN)

    fun isApplicationJsonOrProblemJson(mediaType: String): Boolean =
        mediaType.matches(APPLICATION_PROBLEM_JSON_PATTERN)

    fun isCustomMediaTypeWithVersioning(mediaType: String): Boolean =
        mediaType.matches(CUSTOM_WITH_VERSIONING_PATTERN)
}
