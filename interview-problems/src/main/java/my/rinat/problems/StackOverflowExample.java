package my.rinat.problems;

public class StackOverflowExample {

    public static void main(String[] args) {
        stackOverflow();
    }

    public static void stackOverflow() {
        stackOverflow();
    }
}
