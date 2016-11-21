package annotating
/**
 * We want to defer the construction of time-consuming objects until we
 * need them. We can be lazy and productive at the same time, write less
 * code, and reap all the benefits of lazy initialization.
 */
class Expensive {
    def name = "A"
    Expensive() {println "Created Expensive with name ${name}"}
}

class UsingLazy {

    def value
    /**
     * Groovy defers creation of these fields and marks them as volatile and ensures
     * thread safety during creation. Instances are created on the first access to the
     * fields.
     */
    @Lazy Expensive expensiveA = new Expensive()
    @Lazy Expensive expensiveB = {new Expensive(name: value)}()//This is important-- a closure that returns a call to new

    UsingLazy() {
        println "Created UsingLazy"
    }

    /**
     * The @Lazy annotation is a painless way to implement the "virtual proxy" pattern
     * with the added bonus of thread safety.
     */
    static void main(String[] args) {
        UsingLazy usingLazy = new UsingLazy(value: "Hello")
        println usingLazy.expensiveA.name
        println usingLazy.expensiveA.name
        println usingLazy.expensiveB.name
    }
}
