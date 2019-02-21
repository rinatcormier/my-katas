package my.rinat.kata.collections.company;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.junit.jupiter.api.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 * <p>
 * <p/>
 * {@link MutableList#anySatisfy(Predicate)}<br>
 * {@link MutableList#anySatisfyWith(Predicate2, Object)}<br>
 * {@link MutableList#allSatisfy(Predicate)}<br>
 * {@link MutableList#allSatisfyWith(Predicate2, Object)}<br>
 * {@link MutableList#count(Predicate)}<br>
 * {@link MutableList#countWith(Predicate2, Object)}<br>
 * {@link MutableList#detect(Predicate)}<br>
 * {@link MutableList#detectWith(Predicate2, Object)}<br>
 * {@link MutableList#partition(Predicate)}<br>
 * {@link MutableList#partitionWith(Predicate2, Object)}<br>
 * {@link MutableList#select(Predicate)}<br>
 * {@link MutableList#selectWith(Predicate2, Object)}<br>
 * {@link MutableList#reject(Predicate)}<br>
 * {@link MutableList#rejectWith(Predicate2, Object)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/3">Exercise 2 Slides</a>
 */
class Exercise2Test extends CompanyDomainForKata {
    /**
     * Set up a {@link Predicate} that tests to see if a {@link Customer}'s city is "London".
     */
    @Test
    void customerFromLondonPredicate() {
        Predicate<Customer> predicate = null;
        String predicateClass = predicate.getClass().getSimpleName();
        Assertions
                .assertThat("AttributePredicate".equals(predicateClass) || predicateClass.startsWith("Exercise2Test$$Lambda"))
                .withFailMessage("Solution should use Predicates.attributeEquals() or a lambda but used " + predicateClass)
                .isTrue();

        Customer customerFromLondon = new Customer("test customer", "London");

        Assertions
                .assertThat(predicate.accept(customerFromLondon))
                .withFailMessage("predicate should accept Customers where city is London")
                .isTrue();
    }

    @Test
    void doAnyCustomersLiveInLondon() {
        boolean anyCustomersFromLondon = false;
        Assertions.assertThat(anyCustomersFromLondon).isTrue();
    }

    @Test
    void doAllCustomersLiveInLondon() {
        boolean allCustomersFromLondon = true;
        Assertions.assertThat(allCustomersFromLondon).isFalse();
    }

    @Test
    void howManyCustomersLiveInLondon() {
        int numberOfCustomerFromLondon = 0;
        Assertions
                .assertThat(numberOfCustomerFromLondon)
                .withFailMessage("Should be 2 London customers")
                .isEqualTo(2);
    }

    @Test
    void getLondonCustomers() {
        MutableList<Customer> customersFromLondon = null;
        Assertions
                .assertThat(customersFromLondon)
                .withFailMessage("Should be 2 London customers")
                .hasSize(2);
    }

    @Test
    void getCustomersWhoDontLiveInLondon() {
        MutableList<Customer> customersNotFromLondon = null;
        Assertions
                .assertThat(customersNotFromLondon)
                .withFailMessage("customers not from London")
                .hasSize(1);
    }

    /**
     * Which customers come from London? Which customers do not come from London? Get a collection of both in a single pass.
     */
    @Test
    void getCustomersWhoDoAndDoNotLiveInLondon() {
        PartitionMutableList<Customer> customers = null;
        Assertions
                .assertThat(customers.getSelected())
                .withFailMessage("Should be 2 London customers")
                .hasSize(2);
        Assertions
                .assertThat(customers.getRejected())
                .withFailMessage("customers not from London")
                .hasSize(1);
    }

    /**
     * Implement {@link Company#getCustomerNamed(String)} and get this test to pass.
     */
    @Test
    void findMary() {
        Customer mary = this.company.getCustomerNamed("Mary");
        Assertions
                .assertThat(mary.getName())
                .withFailMessage("customer's name should be Mary")
                .isEqualTo("Mary");
    }

    /**
     * Implement {@link Company#getCustomerNamed(String)} and get this test to pass.
     */
    @Test
    void findPete() {
        Customer pete = this.company.getCustomerNamed("Pete");
        Assertions
                .assertThat(pete)
                .withFailMessage("Should be null as there is no customer called Pete")
                .isNull();
    }
}
