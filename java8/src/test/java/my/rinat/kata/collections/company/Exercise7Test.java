package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link MutableList#groupBy(Function)}
 * {@link MutableList#groupByEach(Function)}
 * {@link ArrayIterate#groupByEach(Object[], Function)}
 * {@link MutableBag#addOccurrences(Object, int)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/19">Exercise 7 Slides</a>
 */
class Exercise7Test extends CompanyDomainForKata {
    /**
     * Create a Multimap where the keys are the names of cities and the values are the Customers from those cities.
     * A Customer is only associated to one city.
     */
    @Test
    void customersByCity() {
        MutableListMultimap<String, Customer> multimap = null;

        Assertions.assertThat(multimap.get("Liphook")).isEqualTo(Lists.mutable.with(this.company.getCustomerNamed("Mary")));
        Assertions
                .assertThat(multimap.get("London"))
                .isEqualTo(Lists.mutable.with(
                        this.company.getCustomerNamed("Fred"),
                        this.company.getCustomerNamed("Bill")));
    }

    /**
     * Create a Multimap where the keys are the names of items and the values are the Suppliers that supply them.
     * A Supplier is associated to many item names.
     */
    @Test
    void itemsBySuppliers() {
        MutableMultimap<String, Supplier> itemsToSuppliers = null;

        Assertions
                .assertThat(itemsToSuppliers.get("sofa"))
                .withFailMessage("should be 2 suppliers for sofa")
                .hasSize(2);
    }

    /**
     * Delete this whole method when you're done. It's just a reminder.
     */
    @Test
    void reminder() {
        Assertions.fail("Refactor setUpCustomersAndOrders() in the super class to not have so much repetition.");
    }
}
