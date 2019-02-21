package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link MutableList#collect(Function)}
 * {@link MutableList#collectDouble(DoubleFunction)}
 * {@link MutableList#select(Predicate)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/15">Exercise 5 Slides</a>
 */
class Exercise5Test extends CompanyDomainForKata {
    /**
     * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
     * instead.
     * Get the order values that are greater than 1.5.
     */
    @Test
    void filterOrderValues() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableList<Double> orderValues = null;
        MutableList<Double> filtered = orderValues.select(Predicates.greaterThan(1.5));

        Assertions.assertThat(filtered).isEqualTo(Lists.mutable.with(372.5, 1.75));
        Assertions.assertThat(this.company.getMostRecentCustomer().getOrders()).isExactlyInstanceOf(MutableList.class);
        this.company.getMostRecentCustomer().getOrders().add(null);
        Assertions
                .assertThat(this.company.getMostRecentCustomer().getOrders())
                .withFailMessage("Don't return a copy from Customer.getOrders(). The field should be a MutableList.")
                .contains(null);
    }

    /**
     * Same as above exercise, but use primitive doubles instead of boxed Doubles.
     */
    @Test
    void filterOrderValuesUsingPrimitives() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableDoubleList orderValues = null;
        MutableDoubleList filtered = orderValues.select(DoublePredicates.greaterThan(1.5));

        Assertions.assertThat(filtered).isEqualTo(DoubleLists.mutable.with(372.5, 1.75));
    }

    /**
     * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
     * instead.
     * Get the actual orders (not their double values) where those orders have a value greater than 2.0.
     */
    @Test
    void filterOrders() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableList<Order> filtered = null;

        Assertions.assertThat(filtered).isEqualTo(Lists.mutable.with(Iterate.getFirst(this.company.getMostRecentCustomer().getOrders())));
        Assertions.assertThat(this.company.getMostRecentCustomer().getOrders()).isExactlyInstanceOf(MutableList.class);
        this.company.getMostRecentCustomer().getOrders().add(null);
        Assertions.assertThat(this.company.getMostRecentCustomer().getOrders())
                .withFailMessage("Don't return a copy from Customer.getOrders(). The field should be a MutableList.")
                .contains(null);
    }
}
