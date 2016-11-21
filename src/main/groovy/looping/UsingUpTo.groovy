package looping

/**
 * Groovy has a convenient <b>upto()</b> instance method from the class
 * <b>DefaultGroovyMethods</b> added to {@link Integer}. We can call it on
 * an instance of {@link Number} and loop the numbers of times specified in
 * the parameter passed to <b>upto</b>.
 */
class UsingUpTo {
    int number = 5

    static void main(String[] args) {
        0.upto((new UsingUpTo(number: 8).number)) {println "${it}"}
    }
}
