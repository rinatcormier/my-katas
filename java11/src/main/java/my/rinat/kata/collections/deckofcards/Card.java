package my.rinat.kata.collections.deckofcards;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.impl.factory.Sets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * {@link LazyIterable} and {@link Sets#cartesianProduct(Set, Set, Function2)} are from Eclipse Collections
     */
    public static LazyIterable<Card> lazyCards() {
        return Sets.cartesianProduct(
                EnumSet.allOf(Rank.class),
                EnumSet.allOf(Suit.class),
                Card::new);
    }

    public static Stream<Card> streamCards() {
        return Card.cartesianProduct(
                EnumSet.allOf(Rank.class),
                EnumSet.allOf(Suit.class),
                Card::new);
    }

    private static <A, B, C> Stream<C> cartesianProduct(
            Set<A> set1,
            Set<B> set2,
            Function2<A, B, C> function) {
        // TODO Implement Cartesian Product using Java 8 Streams
        // Hint: Check out flatMap() and map() on Stream
        return Card.imperativeCartesianProductOfCards(set1, set2, function).stream();
    }

    @Deprecated
    private static <A, B, C> List<C> imperativeCartesianProductOfCards(
            Set<A> set1,
            Set<B> set2,
            Function2<A, B, C> function) {
        var result = new ArrayList<C>();
        for (A first : set1) {
            for (B second : set2) {
                result.add(function.value(first, second));
            }
        }
        return result;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card o) {
        return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(this, o);
    }

    public boolean isDiamonds() {
        return this.suit == Suit.DIAMONDS;
    }

    public boolean isHearts() {
        return this.suit == Suit.HEARTS;
    }

    public boolean isSpades() {
        return this.suit == Suit.SPADES;
    }

    public boolean isClubs() {
        return this.suit == Suit.CLUBS;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Card)) {
            return false;
        }
        var card = (Card) object;
        return this.rank == card.rank && this.suit == card.suit;
    }

    public int hashCode() {
        int result = 31 + this.rank.hashCode();
        result = 31 * result + this.suit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
