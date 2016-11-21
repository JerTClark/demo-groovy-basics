package annotating

import groovy.transform.Immutable

@Immutable
class UsingImmutable {
    String name
    int number

    static void main(String[] args) {
        UsingImmutable immutable = new UsingImmutable(name: "Jacob", number: 27)
        println immutable
        try {
//            immutable.number = 234
        } catch (ex) {
            System.out.println(ex.getMessage());
        }
    }
}
