package extmodules

class EolSearch {
    public static String getEolData(String self) {
        def apiKey = "?key=10aa63502349df2ac0b1bee0059c70d1f2786270"
        def url = "http://eol.org/api/search/1.0.json?q=" +
                "${self.replace(" ", "+")}" +
                "&page=1&exact=true&filter_by_taxon_concept_id=&filter_by_hierarchy_entry_id=&filter_by_string=&cache_ttl=${apiKey}";
        url.toURL().readLines()
    }
}