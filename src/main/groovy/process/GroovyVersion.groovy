package process

class GroovyVersion {
    String cmd = "cmd /c groovy -v"
    static void main(String[] args) {
        println new GroovyVersion().cmd.execute().text
    }
}
