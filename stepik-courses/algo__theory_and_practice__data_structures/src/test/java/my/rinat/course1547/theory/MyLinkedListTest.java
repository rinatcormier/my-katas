package my.rinat.course1547.theory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {

    @ParameterizedTest
    @MethodSource("testAddFirstCandidates")
    void testAddFirst(int[] elements, int size, int headValue) {
        // given:
        MyLinkedList myLinkedList = new MyLinkedList();

        // when:
        for (int e : elements) {
            MyLinkedList.Element element = new MyLinkedList.Element();
            element.setValue(e);
            myLinkedList.addFirst(element);
        }

        // then:
        assertThat(myLinkedList.size()).isEqualTo(size);
        assertThat(myLinkedList.get(0).getValue()).isEqualTo(headValue);
    }

    private static Stream<Arguments> testAddFirstCandidates() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 2}, 2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testAddLastCandidates")
    void testAddLast(int[] elements, int size, int tailValue) {
        // given:
        MyLinkedList myLinkedList = new MyLinkedList();

        // when:
        for (int e : elements) {
            MyLinkedList.Element element = new MyLinkedList.Element();
            element.setValue(e);
            myLinkedList.addLast(element);
        }

        // then:
        assertThat(myLinkedList.size()).isEqualTo(size);
        assertThat(myLinkedList.get(size - 1).getValue()).isEqualTo(tailValue);
    }

    private static Stream<Arguments> testAddLastCandidates() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 2}, 2, 2)
        );
    }
}