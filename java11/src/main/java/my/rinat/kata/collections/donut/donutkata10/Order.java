package my.rinat.kata.collections.donut.donutkata10;

import java.time.LocalDate;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;

public class Order {
    private Customer customer;
    private LocalDate date;
    private MutableBag<DonutType> counts = Bags.mutable.empty();

    public Order(Customer customer, LocalDate date, String donutTypeCounts) {
        this.customer = customer;
        ArrayAdapter.adapt(donutTypeCounts.split(","))
                .asLazy()
                .collect(pair -> pair.split(":"))
                .collect(pair -> PrimitiveTuples.pair(DonutType.forAbbreviation(pair[0]), Integer.parseInt(pair[1])))
                .each(this::add);
        this.date = date;
    }

    private void add(ObjectIntPair<DonutType> pair) {
        this.counts.addOccurrences(pair.getOne(), pair.getTwo());
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Bag<DonutType> getCounts() {
        return this.counts.asUnmodifiable();
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Order(" +
                "customer=" + this.customer +
                ", date=" + this.date +
                ", counts=" + this.counts.toStringOfItemToCount() +
                ')';
    }
}
