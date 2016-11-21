package enumerations

enum Books {
    Genesis(50),
    Exodus(40),
    Leviticus(27),
    Numbers(36),
    Deuteronomy(34)

    final int chapters
    Books(int chapters) {this.chapters = chapters}
}