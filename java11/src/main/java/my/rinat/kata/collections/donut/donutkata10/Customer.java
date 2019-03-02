package my.rinat.kata.collections.donut.donutkata10;

import java.util.Objects;

import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.SetIterable;
import org.eclipse.collections.impl.factory.Lists;

public class Customer {
    private String name;
    private MutableList<Delivery> deliveries = Lists.mutable.empty();

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        var customer = (Customer) o;
        return Objects.equals(this.name, customer.name);
    }

    @Override
    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }

    public boolean named(String name) {
        return name.equals(this.name);
    }

    public String getName() {
        return this.name;
    }

    public void addDelivery(Delivery delivery) {
        this.deliveries.add(delivery);
    }

    public ListIterable<Delivery> getDeliveries() {
        return this.deliveries.asUnmodifiable();
    }

    public long getTotalDonutsOrdered() {
        return this.deliveries.sumOfInt(Delivery::getTotalDonuts);
    }

    public SetIterable<DonutType> getDonutTypesOrdered() {
        return this.deliveries
                .flatCollect(Delivery::getDonuts)
                .collect(Donut::getType)
                .toSet();
    }

    @Override
    public String toString() {
        return "Customer(" +
                "name='" + this.name + '\'' +
                ')';
    }
}
