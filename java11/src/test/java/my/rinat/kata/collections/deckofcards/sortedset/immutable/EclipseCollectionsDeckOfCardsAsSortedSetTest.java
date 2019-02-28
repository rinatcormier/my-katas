package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Suit;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.sortedset.ImmutableSortedSetMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

class EclipseCollectionsDeckOfCardsAsSortedSetTest {
    private EclipseCollectionsDeckOfCardsAsSortedSet ecDeck = new EclipseCollectionsDeckOfCardsAsSortedSet();
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.ecDeck.getCards(), this.jdkDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ecCards = this.ecDeck.getCards().castToSortedSet();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCards.remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ecCards::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCards.add(null));*/
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.ecDeck.diamonds(), this.jdkDeck.diamonds());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.ecDeck.hearts(), this.jdkDeck.hearts());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.ecDeck.spades(), this.jdkDeck.spades());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.ecDeck.clubs(), this.jdkDeck.clubs());
    }

    @Test
    void deal() {
        MutableStack<Card> ecShuffle = this.ecDeck.shuffle(new Random(1));
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));

        MutableSet<Card> ecHand = this.ecDeck.deal(ecShuffle, 5);
        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        // fixme:
        // Assert.assertEquals(ecHand, jdkHand);
    }

    @Test
    void shuffleAndDealHands() {
        ImmutableList<Set<Card>> ecHands = this.ecDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(ecHands, jdkHands);
    }

    @Test
    void dealHands() {
        MutableStack<Card> ecShuffled = this.ecDeck.shuffle(new Random(1));
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        ImmutableList<Set<Card>> ecHands = this.ecDeck.dealHands(ecShuffled, 5, 5);
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(ecHands, jdkHands);
    }

    @Test
    void cardsBySuit() {
        ImmutableSortedSetMultimap<Suit, Card> ecCardsBySuit = this.ecDeck.getCardsBySuit();
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(ecCardsBySuit.get(Suit.CLUBS), jdkCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCardsBySuit.get(Suit.CLUBS).castToSortedSet().remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCardsBySuit.get(Suit.CLUBS).castToSortedSet().add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ecCardsBySuit.get(Suit.CLUBS).castToSortedSet()::clear);*/
    }

    @Test
    void countsBySuit() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue(),
                this.ecDeck.countsBySuit().occurrencesOf(Suit.CLUBS));*/
    }

    @Test
    void countsByRank() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsByRank().get(Rank.TEN).intValue(),
                this.ecDeck.countsByRank().occurrencesOf(Rank.SEVEN));*/
    }
}
