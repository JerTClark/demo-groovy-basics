package varargs

def max(int... b) {
    max = 0
    for (i in b) {
        i > max ? max = i : max
    }
    max
}

def receiveArguments(int a, int... b) {
    0.upto(b.size()) {
        a += it
    }
    a
}

def receiveArguments(int a, String... b) {
    for(s in b) {
        println s
    }
}

println receiveArguments(5, 1, 2, 3, 4, 15)

/**
 * We can use the as operator for type safety
 */
receiveArguments(0, [1, 2, 3, 4] as String[])