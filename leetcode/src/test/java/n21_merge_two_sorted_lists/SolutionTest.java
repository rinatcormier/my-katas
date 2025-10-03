package n21_merge_two_sorted_lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest(name = "{index}: input({0}), expected({1})")
    @MethodSource("candidates")
    void testCandidates(ListNode list1, ListNode list2, ListNode expectedList) {
        var actualList = new Solution().mergeTwoLists(list1, list2);
        var actual = new StringBuilder();
        while (actualList != null) {
            actual.append(actualList.val).append(", ");
            actualList = actualList.next;
        }
        var expected = new StringBuilder();
        while (expectedList != null) {
            expected.append(expectedList.val).append(", ");
            expectedList = expectedList.next;
        }
        assertThat(actual.toString())
                .isEqualTo(expected.toString());
    }

    private static Stream<Arguments> candidates() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))))
                ),
                Arguments.of(null, null, null),
                Arguments.of(null, new ListNode(0), new ListNode(0))
        );
    }
}
