package interfacing

/**
 * Much like the lambda expressions of Java 8, Groovy lets us pass a Closure
 * <b>as</b> and instance of an interface. The Closure then morphs into the interface
 * using the <b>as</b> operator. Groovy intercepts calls to the any method on the
 * interface and routes it to the block of code we provide.
 */
class ImplementingInterfaces {

    static interface MyInterface {
        void sayHi()
        void sayBye()
    }

    static useMyInterface(MyInterface myInterface) {
        myInterface.sayHi()
        myInterface.sayBye()
    }

    /**
     * Groovy makes registering for events and passing anonymous implementations of interfaces
     * really simple.
     */
    static void main(String[] args) {
        useMyInterface({println "Hi!!!"} as MyInterface)
        println ""
        def implementation = [
                sayHi: {println "I say Hi!"},
                sayBye: {println "I say Bye!"}
        ]
        useMyInterface(implementation as MyInterface)
    }

}
