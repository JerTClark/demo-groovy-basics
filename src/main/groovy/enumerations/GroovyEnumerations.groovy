package enumerations

/**
 * Groovy is good with enums!
 */
for (book in Books.values()) {
    println "${book.name()} has ${book.chapters} chapters"
}