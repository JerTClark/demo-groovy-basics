package extmodules

class EolPing {
    public static String pingEol(String self) {
        def url = "http://eol.org/api/ping/1.0.json"
        url.toURL().readLines()
    }
}
