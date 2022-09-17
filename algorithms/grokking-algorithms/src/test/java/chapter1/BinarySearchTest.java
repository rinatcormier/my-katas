package chapter1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {

  @ParameterizedTest
  @MethodSource("binarySearchCandidates")
  void testBinarySearch(int[] sortedArray, int item, int expected) {
    final var actual = new BinarySearch(sortedArray).indexOf(item);
    assertThat(actual)
        .isEqualTo(expected);
  }

  private static Stream<Arguments> binarySearchCandidates() {
    return Stream.of(
        Arguments.of(new int[] {5}, 5, 0),
        Arguments.of(new int[] {5}, 1, -1),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 4, 3),
        Arguments.of(new int[] {1, 3, 5, 7, 9}, 3, 1),
        Arguments.of(new int[] {1, 3, 5, 7, 9}, 10, -1)
    );
  }
}