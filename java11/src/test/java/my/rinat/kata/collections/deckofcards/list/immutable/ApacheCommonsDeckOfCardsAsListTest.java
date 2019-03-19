package my.rinat.kata.collections.deckofcards.list.immutable;

import java.util.ArrayList;
import java.util.Random;

import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ApacheCommonsDeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();
    private ApacheCommonsDeckOfCardsAsList acDeck = new ApacheCommonsDeckOfCardsAsList();

    @Test
    void allCards() {
        Assertions.assertThat(this.acDeck.getCards()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var acCards = this.acDeck.getCards();

        Executable remove = () -> acCards.remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = acCards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> acCards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.acDeck.diamonds()).isEqualTo(this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.acDeck.hearts()).isEqualTo(this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.acDeck.spades()).isEqualTo(this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.acDeck.clubs()).isEqualTo(this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        var acShuffle = this.acDeck.shuffle(new Random(1));

        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        var acHand = this.acDeck.deal(acShuffle, 5);
        Assertions.assertThat(acHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        var acHands = this.acDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(acHands).isEqualTo(jdkHands);
    }

    @Test
    void dealHands() {
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var acShuffled = this.acDeck.shuffle(new Random(1));
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        var acHands = this.acDeck.dealHands(acShuffled, 5, 5);
        Assertions.assertThat(acHands).isEqualTo(jdkHands);
    }

    @Test
    void cardsBySuit() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        var acCardsBySuit = this.acDeck.getCardsBySuit();
        Assertions.assertThat(new ArrayList<>(acCardsBySuit.get(Suit.CLUBS))).isEqualTo(jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var acCardsBySuit = this.acDeck.getCardsBySuit();

        Executable remove = () -> acCardsBySuit.remove(Suit.CLUBS);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = acCardsBySuit::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable removeByIndex = () -> acCardsBySuit.get(Suit.CLUBS).remove(0);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, removeByIndex);

        Executable add = () -> acCardsBySuit.get(Suit.CLUBS).add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clearBySuit = () -> acCardsBySuit.get(Suit.CLUBS).clear();
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clearBySuit);
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.acDeck.countsBySuit().getCount(Suit.CLUBS)).isEqualTo(this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue());
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.acDeck.countsByRank().getCount(Rank.EIGHT)).isEqualTo(this.jdkDeck.countsByRank().get(Rank.TEN).intValue());
    }
}
