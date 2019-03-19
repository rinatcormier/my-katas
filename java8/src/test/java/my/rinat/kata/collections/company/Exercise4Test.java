package my.rinat.kata.collections.company;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.eclipse.collections.impl.utility.Iterate;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * {@link ArrayIterate#collect(Object[], Function)}
 * {@link ArrayIterate#count(Object[], Predicate)}
 * {@link ArrayIterate#detect(Object[], Predicate)}
 * {@link ListIterate#collect(List, Function)}
 * {@link ListIterate#collectDouble(List, DoubleFunction)}
 * {@link ListIterate#select(List, Predicate)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/12">Exercise 4 Slides</a>
 */
class Exercise4Test extends CompanyDomainForKata {
    /**
     * Solve this without changing the return type of {@link Company#getSuppliers()}. Find the appropriate method on
     * {@link ArrayIterate}.
     */
    @Test
    void findSupplierNames() {
        MutableList<String> supplierNames = null;

        MutableList<String> expectedSupplierNames = Lists.mutable.with(
                "Shedtastic",
                "Splendid Crocks",
                "Annoying Pets",
                "Gnomes 'R' Us",
                "Furniture Hamlet",
                "SFD",
                "Doxins");
        Assertions.assertThat(supplierNames).isEqualTo(expectedSupplierNames);
    }

    /**
     * Create a {@link Predicate} for Suppliers that supply more than 2 items. Find the number of suppliers that
     * satisfy that Predicate.
     */
    @Test
    void countSuppliersWithMoreThanTwoItems() {
        Predicate<Supplier> moreThanTwoItems = null;
        int suppliersWithMoreThanTwoItems = 0;
        Assertions.assertThat(suppliersWithMoreThanTwoItems).isEqualTo(5);
    }

    /**
     * Try to solve this without changing the return type of {@link Supplier#getItemNames()}.
     */
    @Test
    void whoSuppliesSandwichToaster() {
        // Create a Predicate that will check to see if a Supplier supplies a "sandwich toaster".
        Predicate<Supplier> suppliesToaster = null;

        // Find one supplier that supplies toasters.
        Supplier toasterSupplier = null;
        Assertions.assertThat(toasterSupplier).isNotNull();
        Assertions.assertThat(toasterSupplier.getName()).isEqualTo("Doxins");
    }

    /**
     * Get the order values that are greater than 1.5.
     */
    @Test
    void filterOrderValues() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableList<Double> orderValues = null;
        MutableList<Double> filtered = null;
        Assertions.assertThat(filtered).isEqualTo(Lists.mutable.with(372.5, 1.75));
    }

    /**
     * Get the order values that are greater than 1.5 using double instead of Double.
     */
    @Test
    void filterOrderValuesUsingPrimitives() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableDoubleList orderValues = null;
        MutableDoubleList filtered = null;
        Assertions.assertThat(filtered).isEqualTo(DoubleLists.mutable.with(372.5, 1.75));
    }

    /**
     * Get the actual orders (not their double values) where those orders have a value greater than 2.0.
     */
    @Test
    void filterOrders() {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        MutableList<Order> filtered = null;
        Assertions.assertThat(filtered).isEqualTo(Lists.mutable.with(Iterate.getFirst(this.company.getMostRecentCustomer().getOrders())));
    }
}
