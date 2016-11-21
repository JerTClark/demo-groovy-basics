package beans

/**
 * To access properties created by the <b>def</b> keyword we don't
 * need getter and setter methods. We can make properties <b>read-only</b>
 * by declaring them as <b>final</b>.
 *
 * We can mark fields as private, but Groovy doesn't honor that-- we'd have to
 * make a setter that rejects any change.
 */
class GroovyBean {
    def numbers
    def name
    final something = "Some thing"
    private privacy = "Can\'t set me"

    void setPrivacy(value) {
        throw new IllegalAccessException("Private field \"privacy\" cannot be accessed.")
    }

    def doingStuff(data, stats, info) {
        print "data: ${data} "
        print "stats: ${stats} "
        println "info: ${info}"
    }

    def optionalParam(tag = "my tag", branch = "master") {
        println "${tag} ${branch}"
    }

    def compute(addend, int[] addends) {
        addends.each {
            addend += it
        }
        println addend
    }
    
    def someName(String aName) {
        aName.split(" ")
    }
    
    def myNames() {
        def (firstName, lastName) = someName("Some guy")
        "${lastName}, ${firstName}"
    }

    static void main(String[] args) {
        GroovyBean groovyBean = new GroovyBean(numbers: [2,3,4], name: "Joe")
        println groovyBean.name
        println groovyBean.numbers
        groovyBean.name = "New Name"
        println groovyBean.name
        println groovyBean.something
        println groovyBean.privacy
        /**
         * If the first parameter is a Map, we can float the map's key-values
         * in the arguments list.
         *
         * If the number of arguments we send is greater than the expected parameters
         * and if the excess arguments are name-value pairs, Groovy expects that
         * the first parameter is a Map and groups all the name-value pairs in the
         * arguments together as values for the first parameter. Groovy then takes the
         * rest of the arguments, in the presented order, as values for the remaining
         * parameters as we see in the output.
         *
         * Note: this shouldn't be commonly used in practice
         */
        groovyBean.doingStuff(a: 1, b: 2, c: 3, 100, true)
        groovyBean.doingStuff(100, true, e:1, f:2, g:3)
        groovyBean.doingStuff(true, 100, e:1, f:2, g:3)
        /**
         * Groovy allows for optional parameters
         */
        groovyBean.optionalParam()
        groovyBean.optionalParam("development", "feature")
        /**
         * Groovy treats trailing array parameter as optional-- Optional
         * parameters reduce noise and allow for sensible defaults
         */
        groovyBean.compute(10, 1, 2, 3)
        groovyBean.compute(1)
        /**
         * Groovy lets us return multiple results from a function and assign them
         * to multiple variables in one shot by returning an array and using comma-separated
         * variables wrapped in parenthesis on the left side of an assignment. If we have excess
         * variables on the left, Groovy will set them to null whereas excess values will be
         * discarded.
         */
        println groovyBean.myNames()
        println groovyBean.someName("Name:Joe Age:52 DOB:1840")
        def (word1, word2, word3) = ["apple", "orange", "banana"]
        println "${word1}, ${word2}, ${word3}"
        (word1, word2, word3) = ["Godzilla", "King Kong", "Gamera"]
        println "${word1}, ${word2}, ${word3}"
    }
}
