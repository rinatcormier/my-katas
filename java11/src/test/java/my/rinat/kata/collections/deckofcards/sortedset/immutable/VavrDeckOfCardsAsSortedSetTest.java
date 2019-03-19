package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VavrDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private VavrDeckOfCardsAsSortedSet vavrDeck = new VavrDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        Assertions.assertThat(this.vavrDeck.getCards().toJavaSet()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.vavrDeck.diamonds().toJavaSet()).isEqualTo(this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.vavrDeck.hearts().toJavaSet()).isEqualTo(this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.vavrDeck.spades().toJavaSet()).isEqualTo(this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.vavrDeck.clubs().toJavaSet()).isEqualTo(this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        io.vavr.collection.List<Card> vavrShuffle = this.vavrDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> vavrHand = this.vavrDeck.deal(vavrShuffle, 5)._1().toJavaSet();
        Assertions.assertThat(vavrHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        io.vavr.collection.List<io.vavr.collection.Set<Card>> vavrHands =
                this.vavrDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(vavrHands.get(0).toJavaSet()).isEqualTo(jdkHands.get(0));
        Assertions.assertThat(vavrHands.get(1).toJavaSet()).isEqualTo(jdkHands.get(1));
        Assertions.assertThat(vavrHands.get(2).toJavaSet()).isEqualTo(jdkHands.get(2));
        Assertions.assertThat(vavrHands.get(3).toJavaSet()).isEqualTo(jdkHands.get(3));
        Assertions.assertThat(vavrHands.get(4).toJavaSet()).isEqualTo(jdkHands.get(4));
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        io.vavr.collection.List<Card> vavrShuffled = this.vavrDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        io.vavr.collection.List<io.vavr.collection.Set<Card>> vavrHands =
                this.vavrDeck.dealHands(vavrShuffled, 5, 5);
        Assertions.assertThat(vavrHands.get(0).toJavaSet()).isEqualTo(jdkHands.get(0));
        Assertions.assertThat(vavrHands.get(1).toJavaSet()).isEqualTo(jdkHands.get(1));
        Assertions.assertThat(vavrHands.get(2).toJavaSet()).isEqualTo(jdkHands.get(2));
        Assertions.assertThat(vavrHands.get(3).toJavaSet()).isEqualTo(jdkHands.get(3));
        Assertions.assertThat(vavrHands.get(4).toJavaSet()).isEqualTo(jdkHands.get(4));
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        io.vavr.collection.Map<Suit, ? extends io.vavr.collection.SortedSet<Card>> vavrCardsBySuit =
                this.vavrDeck.getCardsBySuit();
        Assertions.assertThat(vavrCardsBySuit.get(Suit.CLUBS).get().toJavaList()).isEqualTo(jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.vavrDeck.countsBySuit().get(Suit.CLUBS).get()).isEqualTo(this.jdkDeck.countsBySuit().get(Suit.CLUBS));
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.vavrDeck.countsByRank().get(Rank.TEN).get()).isEqualTo(this.jdkDeck.countsByRank().get(Rank.TEN));
    }
}
