package chapter1

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")