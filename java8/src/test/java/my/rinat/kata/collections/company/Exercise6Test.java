package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link MutableList#collect(Function)}
 * {@link MutableList#collectDouble(DoubleFunction)}
 * {@link MutableList#toSortedList()}
 * {@link MutableDoubleList#toSortedList()}
 * {@link MutableList#max()}
 * {@link MutableDoubleList#max()}
 * {@link MutableList#maxBy(Function)}
 * {@link RichIterable#makeString(String)}
 * {@link MutableList#select(Predicate)}
 * {@link MutableList#selectWith(Predicate2, Object)}
 * {@link RichIterable#each(Procedure)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/17">Exercise 6 Slides</a>
 */
class Exercise6Test extends CompanyDomainForKata {
    /**
     * Get a list of the customers' total order values, sorted. Check out the implementation of {@link
     * Customer#getTotalOrderValue()} and {@link Order#getValue()} .
     */
    @Test
    void sortedTotalOrderValue() {
        MutableList<Double> sortedTotalValues = null;

        // Don't forget the handy utility methods getFirst() and getLast()...
        Assertions
                .assertThat(sortedTotalValues.getLast())
                .withFailMessage("Highest total order value")
                .isEqualTo(Double.valueOf(857.0));
        Assertions
                .assertThat(sortedTotalValues.getFirst())
                .withFailMessage("Lowest total order value")
                .isEqualTo(Double.valueOf(71.0));
    }

    /**
     * Get a list of the customers' total order values, sorted. Use primitive doubles instead of boxed Doubles.
     */
    @Test
    void sortedTotalOrderValueUsingPrimitives() {
        MutableDoubleList sortedTotalValues = null;

        // Don't forget the handy utility methods getFirst() and getLast()...
        Assertions
                .assertThat(sortedTotalValues.getLast())
                .withFailMessage("Highest total order value")
                .isEqualTo(857.0, Assertions.within(0.0));
        Assertions
                .assertThat(sortedTotalValues.getFirst())
                .withFailMessage("Lowest total order value")
                .isEqualTo(71.0, Assertions.offset(0.0));
    }

    /**
     * Find the max total order value across all customers.
     */
    @Test
    void maximumTotalOrderValue() {
        Double maximumTotalOrderValue = null;
        Assertions
                .assertThat(maximumTotalOrderValue)
                .withFailMessage("max value")
                .isEqualTo(Double.valueOf(857.0));
    }

    /**
     * Find the max total order value across all customers, but use primitive double instead of boxed Double.
     */
    @Test
    void maximumTotalOrderValueUsingPrimitives() {
        double maximumTotalOrderValue = 0.0;
        Assertions
                .assertThat(maximumTotalOrderValue)
                .withFailMessage("max value")
                .isEqualTo(857.0, Assertions.within(0.0));
    }

    /**
     * Find the customer with the highest total order value.
     */
    @Test
    void customerWithMaxTotalOrderValue() {
        Customer customerWithMaxTotalOrderValue = null;
        Assertions.assertThat(customerWithMaxTotalOrderValue).isEqualTo(this.company.getCustomerNamed("Mary"));
    }

    /**
     * Create some code to get the company's supplier names as a tilde delimited string.
     */
    @Test
    void supplierNamesAsTildeDelimitedString() {
        String tildeSeparatedNames = null;
        Assertions
                .assertThat(tildeSeparatedNames)
                .withFailMessage("tilde separated names")
                .isEqualTo("Shedtastic~Splendid Crocks~Annoying Pets~Gnomes 'R' Us~Furniture Hamlet~SFD~Doxins");
    }

    /**
     * Deliver all orders going to customers from London.
     * <p/>
     * Hint: Use {@link RichIterable#each(Procedure)}.
     *
     * @see Order#deliver()
     */
    @Test
    void deliverOrdersToLondon() {
//        Verify.assertAllSatisfy(this.company.getCustomerNamed("Fred").getOrders(), Order::isDelivered);
//        Verify.assertNoneSatisfy(this.company.getCustomerNamed("Mary").getOrders(), Order::isDelivered);
//        Verify.assertAllSatisfy(this.company.getCustomerNamed("Bill").getOrders(), Order::isDelivered);
    }
}
