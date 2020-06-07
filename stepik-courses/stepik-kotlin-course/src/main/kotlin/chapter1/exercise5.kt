package chapter1

fun containsEven(collection: Collection<Int>): Boolean = collection.any { item -> item % 2 == 0 }