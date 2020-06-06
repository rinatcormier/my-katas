package my.rinat.kata.donutkatakotlin

import org.eclipse.collections.api.list.ImmutableList
import java.time.LocalDate

class Delivery(private val order: Order, val donuts: ImmutableList<Donut>) {
    init {
        this.order.customer.addDelivery(this)
    }

    val customer: Customer
        get() = this.order.customer

    fun getOrder(): Order {
        return this.order
    }

    val date: LocalDate
        get() = this.order.date

    fun deliveredOn(date: LocalDate): Boolean {
        return this.date == date
    }

    val totalDonuts: Int
        get() = this.donuts.size()

    val totalPrice: Double
        get() = this.donuts.sumOfDouble { it.price }

    override fun toString(): String {
        return "Delivery(" +
                "order=" + order +
                ", donuts=" + donuts.toBag().toStringOfItemToCount() +
                ')'
    }
}
