package objextensions

import groovy.transform.Canonical

import java.nio.file.Files
import java.nio.file.Path

@Canonical
class Verse {
    Version version
    BibleBook book
    BibleChapter chapter
    BibleVerse verse
}

@Canonical
class Version {
    String name
    String desc
    String year
}

@Canonical
class BibleBook {
    String codeName
    String properName
    int numberOfChapters
}

@Canonical
class BibleChapter {
    int chapterNumber
    int numberOfVerses
    String chapterSummary
}

@Canonical
class BibleVerse {
    int verseNumber
    String verseText
}

Version version = new Version(name: "kjv", desc: "The authorized King James version", year: "1611")
BibleBook bibleBook = new BibleBook(codeName: "1sam", properName: "1 Samuel", numberOfChapters: 31)
BibleChapter bibleChapter = new BibleChapter(chapterNumber: 2, numberOfVerses: 36, chapterSummary: "Hannah's prayer of thanksgiving. The wickedness of the sons of Eli.")
BibleVerse bibleVerse = new BibleVerse(verseNumber: 1, verseText: "And Hannah prayed, and said, My heart rejoiceth in the LORD, mine horn is exalted in the LORD: my mouth is enlarged over mine enemies; because I rejoice in thy salvation.")
Verse verse = new Verse(version: version, book: bibleBook, chapter: bibleChapter, verse: bibleVerse)

/**
 * We can use the inspect and dump methods to observer an object's state
 */
println verse.inspect()//If unimplemented, simply returns what toString() returns
println verse.dump()

class Pentateuch {
    static bookTitles = ["Genesis", "Exodus", "Leviticus", "Numbers", "Deuteronomy"]
}
/**
 * We can use the with method to have Groovy automatically set the delegate of the closure
 * parameter to the calling object. To access the calling object in the closure, we specify
 * it with the delegate keyword. Recall that delegate has dibs on whatever "this" doesn't handle.
 */
Pentateuch.bookTitles.with {
    println "There are ${size()} books in the Pentateuch."
    println contains("Genesis")
    getClass()
    println delegate.getClass()
    println "${delegate}"
    delegate.each {
        println "$it"
    }
}

/**
 * We can access properties on objects in numerous ways
 */
println verse.chapter.chapterNumber
println verse."chapter".chapterSummary
println verse.properties["chapter"].chapterNumber

/**
 * Invoking methods gets pretty flexible, too
 */
class Speaker {
    def talk() {println "Hello"}
    def talk(String words) {println "Hello, ${words}"}
    def talk(wordList) {
        def s
        wordList.each {
            if(s) s = s + ", $it"
            else s = ", $it"
        }
        println "Hello${s} how are you?"
    }
}
Speaker speaker = new Speaker()
speaker.talk()
speaker.talk("How are you today?")
speaker.talk(["Jim", "Joe", "John", "Jupey"] as ArrayList<String>)