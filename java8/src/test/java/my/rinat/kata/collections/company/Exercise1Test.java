package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * <p/>
 * {@link MutableList#collect(Function)}<br>
 * {@link MutableList#select(Predicate)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/1">Exercise 1 Slides</a>
 */
class Exercise1Test extends CompanyDomainForKata {
    /**
     * Get the name of each of the company's customers.
     */
    @Test
    void getCustomerNames() {
        Function<Customer, String> nameFunction = Customer::getName;
        MutableList<String> customerNames = null;  // this.company.getCustomers()...

        MutableList<String> expectedNames = Lists.mutable.with("Fred", "Mary", "Bill");
        Assertions.assertThat(customerNames).isEqualTo(expectedNames);
    }

    /**
     * Get the city for each of the company's customers.
     */
    @Test
    void getCustomerCities() {
        MutableList<String> customerCities = null;  // this.company.getCustomers()...

        MutableList<String> expectedCities = Lists.mutable.with("London", "Liphook", "London");
        Assertions.assertThat(customerCities).isEqualTo(expectedCities);
    }

    /**
     * Which customers come from London? Get a collection of those which do.
     */
    @Test
    void getLondonCustomers() {
        MutableList<Customer> customersFromLondon = null; // this.company.getCustomers()...

        Assertions
                .assertThat(customersFromLondon)
                .withFailMessage("Should be 2 London customers")
                .hasSize(2);
    }
}
