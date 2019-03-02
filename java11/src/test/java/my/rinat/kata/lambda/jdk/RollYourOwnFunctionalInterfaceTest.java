package my.rinat.kata.lambda.jdk;

import org.junit.jupiter.api.Test;

class RollYourOwnFunctionalInterfaceTest {
    @Test
    void addFourInts() {
        // TODO create a Functional Interface that accepts four ints and write a lambda which adds them together
        FourIntFunction function = () -> 0;
        // fixme:
        // Assert.assertEquals(10, this.applyFourIntFunction(1, 2, 3, 4, function));
    }

    @Test
    void multiplyFourInts() {
        // TODO use the sam Functional Interface and write a lambda which multiplies them together
        FourIntFunction function = () -> 0;
        // fixme:
        // Assert.assertEquals(16, this.applyFourIntFunction(2, 2, 2, 2, function));
    }

    @Test
    void addFirstThreeIntsAndDivideByLast() {
        // TODO use the sam Functional Interface and write a lambda which adds the first three together and divides by last
        FourIntFunction function = () -> 0;
        // fixme:
        // Assert.assertEquals(3, this.applyFourIntFunction(1, 1, 1, 1, function));
    }

    private int applyFourIntFunction(int one, int two, int three, int four, FourIntFunction function) {
        // TODO - Fix this code to call a method on function with the four parameters
        return function.hashCode();
    }

    @FunctionalInterface
    public interface FourIntFunction {
        // TODO - Fix this method signature
        int writeAFourParameterMethod();
    }
}
