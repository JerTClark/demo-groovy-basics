package annotating

import groovy.transform.Canonical

class Song {
    def artist
    def title
    def album
}

@Canonical
class Instrument {
    String name
    String group
}

/**
 * The @Newify annotation helps us create Python-like and Ruby-like constructors, and Scala-like
 * applicators (whatever). We can do away with new entirely. Just specify the list of types to the
 * @Newify annotation. @Newify can be used on classes and methods. @Newify is helpful when creating DSLs.
 */
@Newify([Song])
class UsingNewify {

    @Newify([Instrument])
    static createInstances(){
        Song.metaClass.testing = "I'm testing"
        println Song.new(artist: "Deely Boppy", title: "Meely Moppy", album: "Wheely Whoppy")
        println Instrument.new(name: "oboe", group: "woodwinds").with {
            setName("violin")
            setGroup("strings")
            delegate
        }
        println Song.new().testing
        println Instrument("cello", "strings").dump()
        println Instrument("piano", "strings").inspect()
    }

    static void main(String[] args) {
        createInstances()
    }
}
