package process

class AnyCommand {
    String cmd = "cmd /c dir"
    public AnyCommand setCmd(String cmd) {
        this.cmd = "cmd /c " + cmd
        this
    }
    static void main(String[] args) {
        println new AnyCommand().setCmd("echo Hello").cmd.execute().text
    }
}
