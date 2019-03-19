package my.rinat.kata.collections.deckofcards.list.immutable;

import java.util.Random;

import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class JDK8DeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdk1Deck = new JDKImperativeDeckOfCardsAsList();
    private JDK8DeckOfCardsAsList jdk2Deck = new JDK8DeckOfCardsAsList();

    @Test
    void allCards() {
        Assertions.assertThat(this.jdk2Deck.getCards()).isEqualTo(this.jdk1Deck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var jdk2Cards = this.jdk2Deck.getCards();

        Executable remove = () -> jdk2Cards.remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = jdk2Cards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> jdk2Cards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.jdk2Deck.diamonds()).isEqualTo(this.jdk1Deck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.jdk2Deck.hearts()).isEqualTo(this.jdk1Deck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.jdk2Deck.spades()).isEqualTo(this.jdk1Deck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.jdk2Deck.clubs()).isEqualTo(this.jdk1Deck.clubs());
    }

    @Test
    void deal() {
        var jdk1Shuffle = this.jdk1Deck.shuffle(new Random(1));
        var jdk2Shuffle = this.jdk2Deck.shuffle(new Random(1));

        var jdk1Hand = this.jdk1Deck.deal(jdk1Shuffle, 5);
        var jdk2Hand = this.jdk2Deck.deal(jdk2Shuffle, 5);
        Assertions.assertThat(jdk2Hand).isEqualTo(jdk1Hand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdk1Hands = this.jdk1Deck.shuffleAndDeal(new Random(1), 5, 5);
        var jdk2Hands = this.jdk2Deck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(jdk2Hands).isEqualTo(jdk1Hands);
    }

    @Test
    void dealHands() {
        var jdk1Shuffled = this.jdk1Deck.shuffle(new Random(1));
        var jdk2Shuffled = this.jdk2Deck.shuffle(new Random(1));
        var jdk1Hands = this.jdk1Deck.dealHands(jdk1Shuffled, 5, 5);
        var jdk2Hands = this.jdk2Deck.dealHands(jdk2Shuffled, 5, 5);
        Assertions.assertThat(jdk2Hands).isEqualTo(jdk1Hands);
    }

    @Test
    void cardsBySuit() {
        var jdk1CardsBySuit = this.jdk1Deck.getCardsBySuit();
        var jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();
        Assertions.assertThat(jdk2CardsBySuit.get(Suit.CLUBS)).isEqualTo(jdk1CardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();

        Executable remove = () -> jdk2CardsBySuit.remove(Suit.CLUBS);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = jdk2CardsBySuit::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable removeBySuit = () -> jdk2CardsBySuit.get(Suit.CLUBS).remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, removeBySuit);

        Executable add = () -> jdk2CardsBySuit.get(Suit.CLUBS).add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clearBySuit = jdk2CardsBySuit.get(Suit.CLUBS)::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clearBySuit);
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.jdk2Deck.countsBySuit().get(Suit.CLUBS)).isEqualTo(this.jdk1Deck.countsBySuit().get(Suit.CLUBS));
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.jdk2Deck.countsByRank().get(Rank.TEN)).isEqualTo(this.jdk1Deck.countsByRank().get(Rank.TEN));
    }
}
