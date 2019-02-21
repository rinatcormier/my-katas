package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.factory.SortedBags;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link RichIterable#aggregateBy(Function, Function0, Function2)}
 * {@link RichIterable#sumByDouble(Function, DoubleFunction)}
 * {@link RichIterable#flatCollect(Function)}
 * {@link MutableList#select(Predicate)}
 * {@link MutableList#anySatisfy(Predicate)}
 * {@link MutableList#toMap(Function, Function)}
 * {@link RichIterable#asLazy()}
 * {@link MutableList#groupBy(Function)}
 * {@link MutableList#collectDouble(DoubleFunction, MutableDoubleCollection)}
 * {@link MutableDoubleList#max()}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/23">Exercise 8 Slides</a>
 */
class Exercise8Test extends CompanyDomainForKata {
    /**
     * Extra credit. Aggregate the total order values by city.
     *
     * @see RichIterable#aggregateBy(Function, Function0, Function2)
     */
    @Test
    void totalOrderValuesByCity() {
        Function0<Double> zeroValueFactory = () -> 0.0;
        Function2<Double, Customer, Double> aggregator = (result, customer) -> result + customer.getTotalOrderValue();

        MutableMap<String, Double> map = null;

        Assertions
                .assertThat(map.size())
                .isEqualTo(2);

        Assertions.assertThat(map.get("London")).isEqualTo(446.25, Assertions.within(0.0));
        Assertions.assertThat(map.get("Liphook")).isEqualTo(857.0, Assertions.within(0.0));
    }

    /**
     * Solve the same problem as above using a more specialized API.
     *
     * @see RichIterable#sumByDouble(Function, DoubleFunction)
     */
    @Test
    void totalOrderValuesByCityUsingPrimitiveValues() {
        Function<Customer, String> cityFunction = Customer::getCity;
        DoubleFunction<Customer> totalOrderValueFunction = Customer::getTotalOrderValue;
        ObjectDoubleMap<String> map = null;

        Assertions
                .assertThat(map.size())
                .isEqualTo(2);

        Assertions.assertThat(map.get("London")).isEqualTo(446.25, Assertions.within(0.0));
        Assertions.assertThat(map.get("Liphook")).isEqualTo(857.0, Assertions.within(0.0));
    }

    /**
     * Extra credit. Aggregate the total order values by item.
     * Hint: Look at {@link RichIterable#aggregateBy(Function, Function0, Function2)} and remember
     * how to use {@link RichIterable#flatCollect(Function)} to get an iterable of all items.
     */
    @Test
    void totalOrderValuesByItem() {
        Function0<Double> zeroValueFactory = () -> 0.0;
        Function2<Double, LineItem, Double> aggregator = (result, lineItem) -> result + lineItem.getValue();

        MutableMap<String, Double> map = null;

        Assertions
                .assertThat(map.size())
                .isEqualTo(12);

        Assertions.assertThat(map.get("shed")).isEqualTo(100.0, Assertions.within(0.0));
        Assertions.assertThat(map.get("cup")).isEqualTo(10.5, Assertions.within(0.0));
    }

    /**
     * Solve the same problem as above using a more specialized API.
     *
     * @see RichIterable#sumByDouble(Function, DoubleFunction)
     */
    @Test
    void totalOrderValuesByItemUsingPrimitiveValues() {
        Function<LineItem, String> nameFunction = LineItem::getName;
        DoubleFunction<LineItem> valueFunction = LineItem::getValue;
        ObjectDoubleMap<String> map = null;

        Assertions
                .assertThat(map.size())
                .isEqualTo(12);

        Assertions.assertThat(map.get("shed")).isEqualTo(100.0, Assertions.within(0.0));
        Assertions.assertThat(map.get("cup")).isEqualTo(10.5, Assertions.within(0.0));
    }

    /**
     * Extra credit. Find all customers' line item values greater than 7.5 and sort them by highest to lowest price.
     */
    @Test
    void sortedOrders() {
        MutableSortedBag<Double> orderedPrices = null;

        MutableSortedBag<Double> expectedPrices = SortedBags.mutable.with(
                Collections.reverseOrder(), 500.0, 150.0, 120.0, 75.0, 50.0, 50.0, 12.5);
        // fixme: Verify.assertSortedBagsEqual(expectedPrices, orderedPrices);
    }

    /**
     * Extra credit. Figure out which customers ordered saucers (in any of their orders).
     */
    @Test
    void whoOrderedSaucers() {
        MutableList<Customer> customersWithSaucers = null;

        Assertions
                .assertThat(customersWithSaucers)
                .withFailMessage("customers with saucers")
                .hasSize(2);
    }

    /**
     * Extra credit. Look into the {@link MutableList#toMap(Function, Function)} method.
     */
    @Test
    void ordersByCustomerUsingAsMap() {
        MutableMap<String, MutableList<Order>> customerNameToOrders =
                this.company.getCustomers().toMap(null, null);

        // fixme: Assert.assertNotNull("customer name to orders", customerNameToOrders);
        // fixme: Verify.assertSize("customer names", 3, customerNameToOrders);
        MutableList<Order> ordersForBill = customerNameToOrders.get("Bill");
        // fixme: Verify.assertSize("Bill orders", 3, ordersForBill);
    }

    /**
     * Extra credit. Create a multimap where the values are customers and the key is the price of
     * the most expensive item that the customer ordered.
     */
    @Test
    void mostExpensiveItem() {
        MutableListMultimap<Double, Customer> multimap = null;
        // fixme: Verify.assertSize(3, multimap);
        // fixme: Verify.assertSize(2, multimap.keysView());

        /* fixme:
        Assert.assertEquals(
                Lists.mutable.with(
                        this.company.getCustomerNamed("Fred"),
                        this.company.getCustomerNamed("Bill")),
                multimap.get(50.0));
         */
    }
}
