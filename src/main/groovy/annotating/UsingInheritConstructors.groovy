package annotating

import groovy.transform.InheritConstructors

class UsingInheritConstructors {
    def name
    UsingInheritConstructors() {
        this.name = "My Name"
    }
}

//@InheritConstructors
class UsingInheritConstructors2 extends UsingInheritConstructors {
    def number
    UsingInheritConstructors2() {
        this.number = 2
    }
    static void main(String[] args) {
        def using = new UsingInheritConstructors2()
        println "${using.name} ${using.number}"
    }
}
