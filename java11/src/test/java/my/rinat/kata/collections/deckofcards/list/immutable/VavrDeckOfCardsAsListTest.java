package my.rinat.kata.collections.deckofcards.list.immutable;

import java.util.Random;

import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VavrDeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();
    private VavrDeckOfCardsAsList vavrDeck = new VavrDeckOfCardsAsList();

    @Test
    void allCards() {
        Assertions.assertThat(this.vavrDeck.getCards().toJavaList()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.vavrDeck.diamonds().toJavaList()).isEqualTo(this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.vavrDeck.hearts().toJavaList()).isEqualTo(this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.vavrDeck.spades().toJavaList()).isEqualTo(this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.vavrDeck.clubs().toJavaList()).isEqualTo(this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        var vavrShuffle = this.vavrDeck.shuffle(new Random(1));

        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        var vavrHand = this.vavrDeck.deal(vavrShuffle, 5)._1().toJavaSet();
        Assertions.assertThat(vavrHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        var vavrHands = this.vavrDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(vavrHands.get(0).toJavaSet()).isEqualTo(jdkHands.get(0));
        Assertions.assertThat(vavrHands.get(1).toJavaSet()).isEqualTo(jdkHands.get(1));
        Assertions.assertThat(vavrHands.get(2).toJavaSet()).isEqualTo(jdkHands.get(2));
        Assertions.assertThat(vavrHands.get(3).toJavaSet()).isEqualTo(jdkHands.get(3));
        Assertions.assertThat(vavrHands.get(4).toJavaSet()).isEqualTo(jdkHands.get(4));
    }

    @Test
    void dealHands() {
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var vavrShuffled = this.vavrDeck.shuffle(new Random(1));
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        var vavrHands = this.vavrDeck.dealHands(vavrShuffled, 5, 5);

        Assertions.assertThat(vavrHands.get(0).toJavaSet()).isEqualTo(jdkHands.get(0));
        Assertions.assertThat(vavrHands.get(1).toJavaSet()).isEqualTo(jdkHands.get(1));
        Assertions.assertThat(vavrHands.get(2).toJavaSet()).isEqualTo(jdkHands.get(2));
        Assertions.assertThat(vavrHands.get(3).toJavaSet()).isEqualTo(jdkHands.get(3));
        Assertions.assertThat(vavrHands.get(4).toJavaSet()).isEqualTo(jdkHands.get(4));
    }

    @Test
    void cardsBySuit() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        var vavrCardsBySuit = this.vavrDeck.getCardsBySuit();
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
