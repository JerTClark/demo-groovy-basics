package truth

/**
 *
 * In addition to enjoying built-in Groovy truths...
 *
 * <b>Type</b>      <b>Condition for Truth</b>
 * Boolean          True
 * Collection       Not empty
 * Character        Value not zero
 * CharSequence     Length greater than zero
 * Enumeration      Has more elements
 * Iterator         Has next
 * Number           Double value not zero
 * Map              Not empty
 * Matcher          At least one match
 * Object[]         Length greater than zero
 * Any other type   Reference not null
 *
 * ...we can write our own <b>boolean</b> conversions easily
 * by implementing the <b>asBoolean()</b> method in any class
 *
 */

def string = "string"
def yarn
def test = {
    if(it) {
        println "$it"
    } else println "..."
}
test string
test yarn
yarn = "oh, yeah! uh, yarn!"
test yarn
string = null
test string
test 123
test ""
test false
test true
test a: "Hello", b: "Hi"
def clo = {def i = 10; i}
test clo.call()

class TestMeForTruth {
    def name
    def asBoolean() {
        if(name) return true
        else return false
    }
}

TestMeForTruth testMeForTruth = new TestMeForTruth()
test testMeForTruth
testMeForTruth.name = "Now I got a name"
test testMeForTruth