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
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.sortedset.ImmutableSortedSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class EclipseCollectionsDeckOfCardsAsSortedSetTest {
    private EclipseCollectionsDeckOfCardsAsSortedSet ecDeck = new EclipseCollectionsDeckOfCardsAsSortedSet();
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        Assertions.assertThat(this.jdkDeck.getCards()).isEqualTo(this.ecDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ecCards = this.ecDeck.getCards().castToSortedSet();

        Executable remove = () -> ecCards.remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = ecCards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> ecCards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.jdkDeck.diamonds()).isEqualTo(this.ecDeck.diamonds());
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.jdkDeck.hearts()).isEqualTo(this.ecDeck.hearts());
    }

    @Test
    void spades() {
        Assertions.assertThat(this.jdkDeck.spades()).isEqualTo(this.ecDeck.spades());
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.jdkDeck.clubs()).isEqualTo(this.ecDeck.clubs());
    }

    @Test
    void deal() {
        MutableStack<Card> ecShuffle = this.ecDeck.shuffle(new Random(1));
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));

        MutableSet<Card> ecHand = this.ecDeck.deal(ecShuffle, 5);
        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Assertions.assertThat(jdkHand).isEqualTo(ecHand);
    }

    @Test
    void shuffleAndDealHands() {
        ImmutableList<Set<Card>> ecHands = this.ecDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(jdkHands).isEqualTo(ecHands);
    }

    @Test
    void dealHands() {
        MutableStack<Card> ecShuffled = this.ecDeck.shuffle(new Random(1));
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        ImmutableList<Set<Card>> ecHands = this.ecDeck.dealHands(ecShuffled, 5, 5);
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        Assertions.assertThat(jdkHands).isEqualTo(ecHands);
    }

    @Test
    void cardsBySuit() {
        ImmutableSortedSetMultimap<Suit, Card> ecCardsBySuit = this.ecDeck.getCardsBySuit();
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        Assertions.assertThat(jdkCardsBySuit.get(Suit.CLUBS)).isEqualTo(ecCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();

        Executable remove = () -> ecCardsBySuit.get(Suit.CLUBS).castToSortedSet().remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable add = () -> ecCardsBySuit.get(Suit.CLUBS).castToSortedSet().add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clear = ecCardsBySuit.get(Suit.CLUBS).castToSortedSet()::clear;
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
