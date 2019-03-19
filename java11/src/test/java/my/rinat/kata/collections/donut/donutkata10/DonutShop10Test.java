package my.rinat.kata.collections.donut.donutkata10;

import static org.assertj.core.api.Assertions.within;
import static org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples.pair;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

class DonutShop10Test {
    private final Clock clock = Clock.fixed(Instant.now(), ZoneOffset.UTC);
    private final LocalDate today = LocalDate.now(this.clock);
    private final LocalDate tomorrow = this.today.plusDays(1);
    private final LocalDate yesterday = this.today.minusDays(1);
    private DonutShop donutShop;

    @BeforeEach
    void setup() {
        this.donutShop = new DonutShop();
        this.donutShop.makeDonuts(DonutType.BOSTON_CREAM, 10);
        this.donutShop.makeDonuts(DonutType.BAVARIAN_CREAM, 10);
        this.donutShop.makeDonuts(DonutType.BLUEBERRY, 10);
        this.donutShop.makeDonuts(DonutType.GLAZED, 10);
        this.donutShop.makeDonuts(DonutType.OLD_FASHIONED, 10);
        this.donutShop.makeDonuts(DonutType.PUMPKIN, 10);
        this.donutShop.makeDonuts(DonutType.JELLY, 10);
        this.donutShop.makeDonuts(DonutType.VANILLA_FROSTED, 10);

        var delivery1 =
                this.donutShop.deliverOrder("Ted Smith", this.today, "BC:2,BA:1,B:2");
        Assertions.assertThat(delivery1.getTotalPrice()).isEqualTo(6.75d, within(0.001));
        var delivery2 =
                this.donutShop.deliverOrder("Mary Williams", this.today, "BC:1,G:1");
        Assertions.assertThat(delivery2.getTotalPrice()).isEqualTo(2.70d, within(0.001));
        var delivery3 =
                this.donutShop.deliverOrder("Sally Prince", this.tomorrow, "BC:6,P:2,B:2,OF:2");
        Assertions.assertThat(delivery3.getTotalPrice()).isEqualTo(12.0d, within(0.001));
        var delivery4 =
                this.donutShop.deliverOrder("Donnie Dapper", this.yesterday, "BC:6,P:2,B:2,OF:2,G:10");
        Assertions.assertThat(delivery4.getTotalPrice()).isEqualTo(20.9d, within(0.001));

        System.out.println(this.donutShop);
    }

    @AfterEach
    void tearDown() {
        this.donutShop = null;
    }

    @Test
    void getTop2Donuts() {
        var expected = Lists.mutable.empty()
                .with(pair(DonutType.BOSTON_CREAM, 15))
                .with(pair(DonutType.GLAZED, 11));
        Assertions.assertThat(this.donutShop.getTopDonuts(2)).isEqualTo(expected);
    }

    @Test
    void totalDeliveryValueByDate() {
        Assertions.assertThat(this.donutShop.getTotalDeliveryValueFor(this.today)).isEqualTo(9.45d, within(0.001));
        Assertions.assertThat(this.donutShop.getTotalDeliveryValueFor(this.tomorrow)).isEqualTo(12.0d, within(0.001));
        Assertions.assertThat(this.donutShop.getTotalDeliveryValueFor(this.yesterday)).isEqualTo(20.9d, within(0.001));
    }

    @Test
    void getTopCustomer() {
        Assertions.assertThat(this.donutShop.getTopCustomer().getName()).isEqualTo("Donnie Dapper");
    }

    @Test
    void getCustomersByDonutTypesOrdered() {
        // Do you know the type of multimap?
        var multimap = this.donutShop.getCustomersByDonutTypesOrdered();
        Assertions.assertThat(multimap.keySet().size()).isEqualTo(6);
        Assertions.assertThat(multimap.get(DonutType.BAVARIAN_CREAM)).hasSize(1);
        Assertions.assertThat(multimap.get(DonutType.BAVARIAN_CREAM)).allSatisfy(customer -> customer.named("Ted Smith"));
    }

    @Test
    void getDonutPriceStatistics() {
        var stats1 = this.donutShop.getDonutPriceStatistics(this.today, this.today);
        Assertions.assertThat(stats1.getSum()).isEqualTo(9.45d, within(0.01));
        Assertions.assertThat(stats1.getAverage()).isEqualTo(1.35d, within(0.01));
        Assertions.assertThat(stats1.getCount()).isEqualTo(7);

        var stats2 = this.donutShop.getDonutPriceStatistics(this.tomorrow, this.tomorrow);
        Assertions.assertThat(stats2.getSum()).isEqualTo(12.0d, within(0.01));
        Assertions.assertThat(stats2.getAverage()).isEqualTo(1.0d, within(0.01));
        Assertions.assertThat(stats2.getCount()).isEqualTo(12);

        var stats3 = this.donutShop.getDonutPriceStatistics(this.yesterday, this.yesterday);
        Assertions.assertThat(stats3.getSum()).isEqualTo(20.9d, within(0.001));
        Assertions.assertThat(stats3.getAverage()).isEqualTo(0.95d, within(0.01));
        Assertions.assertThat(stats3.getCount()).isEqualTo(22);

        var statsTotal = this.donutShop.getDonutPriceStatistics(this.yesterday, this.tomorrow);
        Assertions.assertThat(statsTotal.getSum()).isEqualTo(42.35d, within(0.01));
        Assertions.assertThat(statsTotal.getAverage()).isEqualTo(1.03d, within(0.01));
        Assertions.assertThat(statsTotal.getCount()).isEqualTo(41);
        Assertions.assertThat(statsTotal.getMin()).isEqualTo(0.95, within(0.01));
        Assertions.assertThat(statsTotal.getMax()).isEqualTo(1.35, within(0.01));
    }
}
