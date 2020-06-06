package my.rinat.kata.donutkatakotlin

import org.assertj.core.api.Assertions
import org.eclipse.collections.impl.factory.Lists
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples.pair
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

class DonutShopTest {
    private val clock = Clock.fixed(Instant.now(), ZoneOffset.UTC)
    private val today = LocalDate.now(this.clock)
    private val tomorrow = this.today.plusDays(1)
    private val yesterday = this.today.minusDays(1)
    private var donutShop: DonutShop? = null

    @BeforeEach
    fun setup() {
        this.donutShop = DonutShop()
        this.donutShop!!.makeDonuts(DonutType.BOSTON_CREAM, 10)
        this.donutShop!!.makeDonuts(DonutType.BAVARIAN_CREAM, 10)
        this.donutShop!!.makeDonuts(DonutType.BLUEBERRY, 10)
        this.donutShop!!.makeDonuts(DonutType.GLAZED, 10)
        this.donutShop!!.makeDonuts(DonutType.OLD_FASHIONED, 10)
        this.donutShop!!.makeDonuts(DonutType.PUMPKIN, 10)
        this.donutShop!!.makeDonuts(DonutType.JELLY, 10)
        this.donutShop!!.makeDonuts(DonutType.VANILLA_FROSTED, 10)

        val delivery1 = this.donutShop!!.deliverOrder("Ted Smith", this.today, "BC:2,BA:1,B:2")
        Assertions.assertThat(delivery1.totalPrice).isEqualTo(6.75, Assertions.within(0.001))
        val delivery2 = this.donutShop!!.deliverOrder("Mary Williams", this.today, "BC:1,G:1")
        Assertions.assertThat(delivery2.totalPrice).isEqualTo(2.70, Assertions.within(0.001))
        val delivery3 = this.donutShop!!.deliverOrder("Sally Prince", this.tomorrow, "BC:6,P:2,B:2,OF:2")
        Assertions.assertThat(delivery3.totalPrice).isEqualTo(12.0, Assertions.within(0.001))
        val delivery4 = this.donutShop!!.deliverOrder("Donnie Dapper", this.yesterday, "BC:6,P:2,B:2,OF:2,G:10")
        Assertions.assertThat(delivery4.totalPrice).isEqualTo(20.9, Assertions.within(0.001))

        println(this.donutShop)
    }

    @AfterEach
    fun tearDown() {
        this.donutShop = null
    }

    @Test
    fun getTop2Donuts() {
        val expected = Lists.mutable.with(
                pair(DonutType.BOSTON_CREAM, 15),
                pair(DonutType.GLAZED, 11))
        Assertions.assertThat(this.donutShop!!.getTopDonuts(2)).isEqualTo(expected)
    }

    @Test
    fun totalDeliveryValueByDate() {
        Assertions.assertThat(this.donutShop!!.getTotalDeliveryValueFor(this.today)).isEqualTo(9.45, Assertions.within(0.001))
        Assertions.assertThat(this.donutShop!!.getTotalDeliveryValueFor(this.tomorrow)).isEqualTo(12.0, Assertions.within(0.001))
        Assertions.assertThat(this.donutShop!!.getTotalDeliveryValueFor(this.yesterday)).isEqualTo(20.9, Assertions.within(0.001))
    }

    @Test
    fun getTopCustomer() {
        Assertions.assertThat(this.donutShop!!.topCustomer!!.name).isEqualTo("Donnie Dapper")
    }

    @Test
    fun getCustomersByDonutTypesOrdered() {
        val multimap = this.donutShop!!.customersByDonutTypesOrdered
        Assertions.assertThat(multimap!!.keySet().size().toLong()).isEqualTo(6)
        Assertions.assertThat(multimap.get(DonutType.BAVARIAN_CREAM)).hasSize(1)
        Assertions.assertThat(multimap.get(DonutType.BAVARIAN_CREAM)).allSatisfy { it.named("Ted Smith") }
    }

    @Test
    fun getDonutPriceStatistics() {
        val stats1 = this.donutShop!!.getDonutPriceStatistics(this.today, this.today)
        Assertions.assertThat(stats1!!.sum).isEqualTo(9.45, Assertions.within(0.01))
        Assertions.assertThat(stats1.average).isEqualTo(1.35, Assertions.within(0.01))
        Assertions.assertThat(stats1.count).isEqualTo(7L)

        val stats2 = this.donutShop!!.getDonutPriceStatistics(this.tomorrow, this.tomorrow)
        Assertions.assertThat(stats2!!.sum).isEqualTo(12.0, Assertions.within(0.01))
        Assertions.assertThat(stats2.average).isEqualTo(1.0, Assertions.within(0.01))
        Assertions.assertThat(stats2.count).isEqualTo(12L)

        val stats3 = this.donutShop!!.getDonutPriceStatistics(this.yesterday, this.yesterday)
        Assertions.assertThat(stats3!!.sum).isEqualTo(20.9, Assertions.within(0.001))
        Assertions.assertThat(stats3.average).isEqualTo(0.95, Assertions.within(0.01))
        Assertions.assertThat(stats3.count).isEqualTo(22L)

        val statsTotal = this.donutShop!!.getDonutPriceStatistics(this.yesterday, this.tomorrow)
        Assertions.assertThat(statsTotal!!.sum).isEqualTo(42.35, Assertions.within(0.01))
        Assertions.assertThat(statsTotal.average).isEqualTo(1.03, Assertions.within(0.01))
        Assertions.assertThat(statsTotal.count).isEqualTo(41L)
        Assertions.assertThat(statsTotal.min).isEqualTo(0.95, Assertions.within(0.01))
        Assertions.assertThat(statsTotal.max).isEqualTo(1.35, Assertions.within(0.01))
    }
}
