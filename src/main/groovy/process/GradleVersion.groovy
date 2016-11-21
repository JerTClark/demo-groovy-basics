package process

class GradleVersion {
    String cmd = "cmd /c gradle --version"
    static void main(String[] args) {
        println new GradleVersion().cmd.execute().text
    }
}
