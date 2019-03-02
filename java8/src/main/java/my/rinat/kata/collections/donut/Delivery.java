package my.rinat.kata.collections.donut;

import java.time.LocalDate;

import org.eclipse.collections.api.list.ImmutableList;

public class Delivery {
    private final Order order;
    private final ImmutableList<Donut> donuts;

    public Delivery(Order order, ImmutableList<Donut> donuts) {
        this.donuts = donuts;
        this.order = order;
        this.order.getCustomer().addDelivery(this);
    }

    public Customer getCustomer() {
        return this.order.getCustomer();
    }

    public Order getOrder() {
        return this.order;
    }

    public ImmutableList<Donut> getDonuts() {
        return this.donuts;
    }

    public LocalDate getDate() {
        return this.order.getDate();
    }

    public boolean deliveredOn(LocalDate date) {
        return this.getDate().equals(date);
    }

    public int getTotalDonuts() {
        return this.getDonuts().size();
    }

    public double getTotalPrice() {
        return this.getDonuts().sumOfDouble(Donut::getPrice);
    }

    @Override
    public String toString() {
        return "Delivery(" +
                "order=" + this.order +
                ", donuts=" + this.donuts.toBag().toStringOfItemToCount() +
                ')';
    }
}
