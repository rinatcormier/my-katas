package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import com.google.common.collect.ImmutableSetMultimap;
import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GoogleGuavaDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private GoogleGuavaDeckOfCardsAsSortedSet ggDeck = new GoogleGuavaDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        Assertions.assertThat(this.ggDeck.getCards()).isEqualTo(this.jdkDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ggCards = this.ggDeck.getCards();

        Executable remove = () -> ggCards.remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = ggCards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> ggCards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.ggDeck.diamonds()).isEqualTo(this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.ggDeck.hearts()).isEqualTo(this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.ggDeck.spades()).isEqualTo(this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.ggDeck.clubs()).isEqualTo(this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> ggShuffle = this.ggDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> ggHand = this.ggDeck.deal(ggShuffle, 5);
        Assertions.assertThat(ggHand).isEqualTo(jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> ggHands = this.ggDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(ggHands).isEqualTo(jdkHands);
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> ggShuffled = this.ggDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        List<Set<Card>> ggHands = this.ggDeck.dealHands(ggShuffled, 5, 5);
        Assertions.assertThat(ggHands).isEqualTo(jdkHands);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        ImmutableSetMultimap<Suit, Card> ggCardsBySuit = this.ggDeck.getCardsBySuit();
        Assertions.assertThat(ggCardsBySuit.get(Suit.CLUBS)).isEqualTo(jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ggCardsBySuit = this.ggDeck.getCardsBySuit();

        Executable removeAll = () -> ggCardsBySuit.removeAll(Suit.CLUBS);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, removeAll);

        Executable clear = ggCardsBySuit::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable remove = () -> ggCardsBySuit.get(Suit.CLUBS).remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable add = () -> ggCardsBySuit.get(Suit.CLUBS).add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clearBySuit = ggCardsBySuit.get(Suit.CLUBS)::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clearBySuit);
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.ggDeck.countsBySuit().count(Suit.CLUBS)).isEqualTo(this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue());
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.ggDeck.countsByRank().count(Rank.NINE)).isEqualTo(this.jdkDeck.countsByRank().get(Rank.TEN).intValue());
    }
}
