package safe

/**
 * The safe navigation operator ?. eliminates the mundane check for null
 * The ?. operator calls the method or property <b>only if</b> the reference is
 * not null
 */
class UsingTheSafeOperator {

    static check(param) {
        param?.toUpperCase()
    }

    static void main(String[] args) {
        println check("hello")
        println check("") ? "Ok" : "No param"
    }

}
