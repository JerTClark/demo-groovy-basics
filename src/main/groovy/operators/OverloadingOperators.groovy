package operators

/**
 * We can use Groovy's support for operator overloading to create
 * DSLs. Each operator has a standard mapping to methods.
 */

/**
 * We can use the ++ operator or the .. operator on char values.
 * Both map to the next() method.
 */
for (ch = 'a'; ch <= 'j'; ch++) {
    print ch
}
println ""
for(ch in 'a'..'j') {
    print ch
}
println ""

/**
 * We can use the << operator to add elements to a collection
 */
def myList = ["Desiree", "Jeremy", "Jacob", "Amelia", "Jubilee"]
println "${myList}"
myList << "Jesus our Lord!"
println "${myList}"

/**
 * We can provide operators for our own classes by adding the mapping methods
 * such as plus() for +
 * We have to remember to honor whether an operation must be commutative, symmetric,
 * or transitive. Be sure that implementations of the overloaded methods adhere
 * to this.
 */
class MyOverloadedPlus {
    def field
    def plus(other){
        field + ", " + other.toLowerCase()
    }
    def multiply(other) {
        field + ", " + other + " " + other + " " + other
    }
    def next() {
        println field + " What's next?"
    }
}
def obj = new MyOverloadedPlus(field: "Hello")
println "${obj+"How are you?"}"
println "${obj*"How are you?"}" 
obj++