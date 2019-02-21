package my.rinat.kata.collections.company;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.utility.ListIterate;

import java.util.ArrayList;
import java.util.List;

/**
 * Customers have a name, city and a list of {@link Order}s
 */
public class Customer {

    private final String name;
    private final String city;

    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order anOrder) {
        this.orders.add(anOrder);
    }

    public double getTotalOrderValue() {
        MutableList<Double> orderValues = ListIterate.collect(this.orders, Order::getValue);
        return orderValues.injectInto(0.0, AddFunction.DOUBLE_TO_DOUBLE);
    }
}
