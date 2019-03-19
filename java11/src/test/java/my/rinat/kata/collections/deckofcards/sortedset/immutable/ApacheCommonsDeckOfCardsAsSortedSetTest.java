package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.apache.commons.collections4.MultiValuedMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ApacheCommonsDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private ApacheCommonsDeckOfCardsAsSortedSet acDeck = new ApacheCommonsDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        Assertions.assertThat(this.acDeck.getCards()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var acCards = this.acDeck.getCards();

        Executable remove = () -> acCards.remove(null);
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
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> acShuffle = this.acDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> acHand = this.acDeck.deal(acShuffle, 5);
        Assertions.assertThat(acHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> acHands = this.acDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(acHands).isEqualTo(jdkHands);
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> acShuffled = this.acDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        List<Set<Card>> acHands = this.acDeck.dealHands(acShuffled, 5, 5);
        Assertions.assertThat(acHands).isEqualTo(jdkHands);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        MultiValuedMap<Suit, Card> acCardsBySuit = this.acDeck.getCardsBySuit();
        Assertions.assertThat(new TreeSet<>(acCardsBySuit.get(Suit.CLUBS))).isEqualTo(jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var acCardsBySuit = this.acDeck.getCardsBySuit();

        Executable remove = () -> acCardsBySuit.remove(Suit.CLUBS);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = acCardsBySuit::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable removeBySuit = () -> acCardsBySuit.get(Suit.CLUBS).remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, removeBySuit);

        Executable add = () -> acCardsBySuit.get(Suit.CLUBS).add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clearBySuit = acCardsBySuit.get(Suit.CLUBS)::clear;
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
