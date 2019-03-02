package my.rinat.kata.donutkatakotlin

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
        // fixme:
        // Assert.assertEquals(6.75, delivery1.totalPrice, 0.001)
        val delivery2 = this.donutShop!!.deliverOrder("Mary Williams", this.today, "BC:1,G:1")
        // fixme:
        // Assert.assertEquals(2.70, delivery2.totalPrice, 0.001)
        val delivery3 = this.donutShop!!.deliverOrder("Sally Prince", this.tomorrow, "BC:6,P:2,B:2,OF:2")
        // fixme:
        // Assert.assertEquals(12.0, delivery3.totalPrice, 0.001)
        val delivery4 = this.donutShop!!.deliverOrder("Donnie Dapper", this.yesterday, "BC:6,P:2,B:2,OF:2,G:10")
        // fixme:
        // Assert.assertEquals(20.9, delivery4.totalPrice, 0.001)

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
        // fixme:
        // Assert.assertEquals(expected, this.donutShop!!.getTopDonuts(2))
    }

    @Test
    fun totalDeliveryValueByDate() {
        /*
        fixme:
        Assert.assertEquals(9.45, this.donutShop!!.getTotalDeliveryValueFor(this.today), 0.001)
        Assert.assertEquals(12.0, this.donutShop!!.getTotalDeliveryValueFor(this.tomorrow), 0.001)
        Assert.assertEquals(20.9, this.donutShop!!.getTotalDeliveryValueFor(this.yesterday), 0.001)*/
    }

    @Test
    fun getTopCustomer() {
        // fixme:
        // Assert.assertEquals("Donnie Dapper", this.donutShop!!.topCustomer!!.name)
    }

    @Test
    fun getCustomersByDonutTypesOrdered() {
        val multimap = this.donutShop!!.customersByDonutTypesOrdered
        /*
        fixme:
        Assert.assertEquals(6, multimap!!.keySet().size().toLong())
        Verify.assertIterableSize(1, multimap.get(DonutType.BAVARIAN_CREAM))
        Verify.assertAllSatisfy(
            multimap.get(DonutType.BAVARIAN_CREAM),
            { it.named("Ted Smith") })*/
    }

    @Test
    fun getDonutPriceStatistics() {
        val stats1 = this.donutShop!!.getDonutPriceStatistics(this.today, this.today)
        /*
        fixme:
        Assert.assertEquals(9.45, stats1!!.sum, 0.01)
        Assert.assertEquals(1.35, stats1.average, 0.01)
        Assert.assertEquals(7L, stats1.count)*/

        val stats2 = this.donutShop!!.getDonutPriceStatistics(this.tomorrow, this.tomorrow)
        /*
        fixme:
        Assert.assertEquals(12.0, stats2!!.sum, 0.01)
        Assert.assertEquals(1.0, stats2.average, 0.01)
        Assert.assertEquals(12L, stats2.count)*/

        val stats3 = this.donutShop!!.getDonutPriceStatistics(this.yesterday, this.yesterday)
        /*
        fixme:
        Assert.assertEquals(20.9, stats3!!.sum, 0.001)
        Assert.assertEquals(0.95, stats3.average, 0.01)
        Assert.assertEquals(22L, stats3.count)*/

        val statsTotal = this.donutShop!!.getDonutPriceStatistics(this.yesterday, this.tomorrow)
        /*
        fixme:
        Assert.assertEquals(42.35, statsTotal!!.sum, 0.01)
        Assert.assertEquals(1.03, statsTotal.average, 0.01)
        Assert.assertEquals(41L, statsTotal.count)
        Assert.assertEquals(0.95, statsTotal.min, 0.01)
        Assert.assertEquals(1.35, statsTotal.max, 0.01)*/
    }
}
