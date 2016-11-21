package annotating

import groovy.transform.Canonical

/**
 * If we find ourselves writing a toString() method that simply displays select field
 * values as comma separated, we can let the Groovy compiler work for us by using the
 * @Canonical annotation.
 *
 * Groovy excludes the fields we mention in the excludes parameter.
 */
@Canonical(excludes = "address")
class UsingCanonical {
    def name
    def address
    def city

    static void main(String[] args) {
        UsingCanonical usingCanonical = new UsingCanonical(name: "Name here", address: "Address here", city: "City here")
        println usingCanonical
    }
}
