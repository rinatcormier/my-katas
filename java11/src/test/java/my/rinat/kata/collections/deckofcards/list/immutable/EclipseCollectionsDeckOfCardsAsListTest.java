package my.rinat.kata.collections.deckofcards.list.immutable;

import java.util.Random;

import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class EclipseCollectionsDeckOfCardsAsListTest {
    private EclipseCollectionsDeckOfCardsAsList ecDeck = new EclipseCollectionsDeckOfCardsAsList();
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();

    @Test
    void allCards() {
        Assertions.assertThat(this.ecDeck.getCards()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ecCards = this.ecDeck.getCards().castToList();

        Executable remove = () -> ecCards.remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = ecCards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> ecCards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.ecDeck.diamonds()).isEqualTo(this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.ecDeck.hearts()).isEqualTo(this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.ecDeck.spades()).isEqualTo(this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.ecDeck.clubs()).isEqualTo(this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        var ecShuffle = this.ecDeck.shuffle(new Random(1));
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));

        var ecHand = this.ecDeck.deal(ecShuffle, 5);
        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Assertions.assertThat(ecHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        var ecHands = this.ecDeck.shuffleAndDeal(new Random(1), 5, 5);
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(ecHands).isEqualTo(jdkHands);
    }

    @Test
    void dealHands() {
        var ecShuffled = this.ecDeck.shuffle(new Random(1));
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var ecHands = this.ecDeck.dealHands(ecShuffled, 5, 5);
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        Assertions.assertThat(ecHands).isEqualTo(jdkHands);
    }

    @Test
    void cardsBySuit() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        Assertions.assertThat(ecCardsBySuit.get(Suit.CLUBS)).isEqualTo(jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();

        Executable remove = () -> ecCardsBySuit.get(Suit.CLUBS).castToList().remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable add = () -> ecCardsBySuit.get(Suit.CLUBS).castToList().add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clear = ecCardsBySuit.get(Suit.CLUBS).castToList()::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.ecDeck.countsBySuit().occurrencesOf(Suit.CLUBS)).isEqualTo(this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue());
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.ecDeck.countsByRank().occurrencesOf(Rank.SEVEN)).isEqualTo(this.jdkDeck.countsByRank().get(Rank.TEN).intValue());
    }
}
