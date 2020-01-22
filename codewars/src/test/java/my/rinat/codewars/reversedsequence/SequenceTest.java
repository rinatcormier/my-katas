package my.rinat.codewars.reversedsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SequenceTest {
    @Test
    public void simpleTest() {
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Sequence.reverse(5));
    }
}