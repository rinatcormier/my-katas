package my.rinat.kata.collections.candy;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.jupiter.api.Test;

class CandyKataTest {
    @Test
    void topCandy() {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        // Hint: Flatten the Bags of Candy into a single Bag
        Bag<Candy> bigBagOfCandy = null;

        // Hint: Find the top occurrence in the bag and convert that to a set.
        MutableSet<Candy> mostCommon = null;
        Assertions.assertThat(mostCommon).isEqualTo(Sets.mutable.with(Candy.REESES_PIECES));
    }

    @Test
    void commonInTop10() {
        MutableList<Bag<Candy>> bagsOfCandy = this.collectBagsOfCandy();

        // Hint: Find the top 10 occurrences of Candy in each of the bags and intersect them.
        MutableSet<Candy> commonInTop10 = null;
        Assertions.assertThat(commonInTop10).isEqualTo(Sets.mutable.with(Candy.REESES_PIECES, Candy.CRUNCH));
    }

    private MutableList<Bag<Candy>> collectBagsOfCandy() {
        return SchoolGroup.all().collect(SchoolGroup::trickOrTreat).toList();
    }
}
