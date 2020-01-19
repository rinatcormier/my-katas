package my.rinat.course1547.theory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MyArrayTest {

    @ParameterizedTest
    @MethodSource("testAddCandidates")
    void testAdd(int size, int[] elements, int[] expected) {
        // given:
        MyArray myArray = new MyArray(size);

        // when:
        for (int element : elements) {
            myArray.add(element);
        }

        // then:
        assertThat(myArray.getArray()).containsExactly(expected);
    }

    private static Stream<Arguments> testAddCandidates() {
        return Stream.of(
                Arguments.of(1, new int[]{1}, new int[]{1}),
                Arguments.of(2, new int[]{1}, new int[]{1, 0}),
                Arguments.of(3, new int[]{1}, new int[]{1, 0, 0}),
                Arguments.of(4, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("testInsertCandidates")
    void testInsert(int size, int[] elements, int insertIndex, int insertElement, int[] expected) {
        // given:
        MyArray myArray = new MyArray(size);
        for (int element : elements) {
            myArray.add(element);
        }

        // when:
        myArray.insert(insertIndex, insertElement);

        // then:
        assertThat(myArray.getArray()).containsExactly(expected);
    }

    private static Stream<Arguments> testInsertCandidates() {
        return Stream.of(
                Arguments.of(3, new int[]{2, 3}, 0, 1, new int[]{1, 2, 3}),
                Arguments.of(3, new int[]{1, 3}, 1, 2, new int[]{1, 2, 3}),
                Arguments.of(3, new int[]{1, 2}, 2, 3, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("testDeleteCandidates")
    void testDelete(int size, int[] elements, int deleteIndex, int[] expected) {
        // given:
        MyArray myArray = new MyArray(size);
        for (int element : elements) {
            myArray.add(element);
        }

        // when:
        myArray.delete(deleteIndex);

        // then:
        assertThat(myArray.getArray()).containsExactly(expected);
    }

    private static Stream<Arguments> testDeleteCandidates() {
        return Stream.of(
                Arguments.of(3, new int[]{1, 2, 3}, 0, new int[]{2, 3, 0}),
                Arguments.of(3, new int[]{1, 2, 3}, 1, new int[]{1, 3, 0}),
                Arguments.of(3, new int[]{1, 2, 3}, 2, new int[]{1, 2, 0})
        );
    }
}