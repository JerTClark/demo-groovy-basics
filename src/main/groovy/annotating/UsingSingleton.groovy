package annotating

/**
 * To implement the singleton pattern we would normally create static factory methods and then return
 * the singleton instance. We would have to ensure it was all thread safe and decide whether or not
 * to use lazy creation. However, we can bypass all of this effort by using the @Singleton transformation.
 */
@Singleton(lazy = false, strict = false)
class SingleOne {
    private SingleOne() {println "Instance created"}
    def hello() {println "Hello"}
}

class UsingSingleton {
    static void main(String[] args) {
        /**
         * Here, we use the static method getInstance()
         */
        SingleOne.instance.hello()
        SingleOne.instance.hello()
        SingleOne.instance.hello()
    }
}
