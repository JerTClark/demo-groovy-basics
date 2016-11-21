package looping

/**
 * Like upto, <b>times</b> can be used to loop. Note that it is zero-indexed.
 */
class UsingTimes {
    int number = 5
    static void main(String[] args) {
        new UsingTimes().number.times {println "${it}"}
    }
}
