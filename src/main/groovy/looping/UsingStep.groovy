package looping

/**
 * Using <b>step</b>, we can skip specific values when looping.
 */
class UsingStep {
    int countBy = 2
    static void main(String[] args) {
        0.step(13, new UsingStep(countBy: 2).countBy) {
            println "${it}"
        }
    }
}
