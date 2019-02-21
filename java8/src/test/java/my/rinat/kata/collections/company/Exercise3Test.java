package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link MutableList#flatCollect(Function)}<br>
 * {@link MutableList#collect(Function)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/8">Exercise 3 Slides</a>
 */
class Exercise3Test extends CompanyDomainForKata {
    /**
     * Improve {@link Company#getOrders()} without breaking this test.
     */
    @Test
    void improveGetOrders() {
        // Delete this line - it's a reminder
        Assertions.fail("Improve getOrders() without breaking this test");
        Assertions
                .assertThat(this.company.getOrders())
                .hasSize(5);
    }

    /**
     * Get all items that have been ordered by anybody.
     */
    @Test
    void findItemNames() {
        MutableList<LineItem> allOrderedLineItems = null;
        MutableSet<String> actualItemNames = null;

        Assertions.assertThat(allOrderedLineItems).isExactlyInstanceOf(MutableList.class);
        Assertions.assertThat(allOrderedLineItems.getFirst()).isExactlyInstanceOf(String.class);

        Assertions.assertThat(actualItemNames).isExactlyInstanceOf(MutableSet.class);
        Assertions.assertThat(actualItemNames.getFirst()).isExactlyInstanceOf(String.class);

        MutableSet<String> expectedItemNames = Sets.mutable.with(
                "shed", "big shed", "bowl", "cat", "cup", "chair", "dog",
                "goldfish", "gnome", "saucer", "sofa", "table");
        Assertions.assertThat(actualItemNames).isEqualTo(expectedItemNames);
    }

    @Test
    void findCustomerNames() {
        MutableList<String> names = null;

        MutableList<String> expectedNames = Lists.mutable.with("Fred", "Mary", "Bill");
        Assertions.assertThat(names).isEqualTo(expectedNames);
    }
}
