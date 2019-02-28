package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import com.google.common.collect.ImmutableSetMultimap;
import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Suit;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

class GoogleGuavaDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private GoogleGuavaDeckOfCardsAsSortedSet ggDeck = new GoogleGuavaDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.ggDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ggCards = this.ggDeck.getCards();
        /*
        fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCards.remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ggCards::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCards.add(null));*/
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.diamonds(), this.ggDeck.diamonds());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.hearts(), this.ggDeck.hearts());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.spades(), this.ggDeck.spades());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.clubs(), this.ggDeck.clubs());
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> ggShuffle = this.ggDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> ggHand = this.ggDeck.deal(ggShuffle, 5);
        // fixme:
        // Assert.assertEquals(jdkHand, ggHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> ggHands = this.ggDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ggHands);
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> ggShuffled = this.ggDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        List<Set<Card>> ggHands = this.ggDeck.dealHands(ggShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ggHands);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        ImmutableSetMultimap<Suit, Card> ggCardsBySuit = this.ggDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), ggCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ggCardsBySuit = this.ggDeck.getCardsBySuit();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCardsBySuit.removeAll(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ggCardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCardsBySuit.get(Suit.CLUBS).remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCardsBySuit.get(Suit.CLUBS).add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ggCardsBySuit.get(Suit.CLUBS)::clear);*/
    }

    @Test
    void countsBySuit() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue(),
                this.ggDeck.countsBySuit().count(Suit.CLUBS));*/
    }

    @Test
    void countsByRank() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsByRank().get(Rank.TEN).intValue(),
                this.ggDeck.countsByRank().count(Rank.NINE));*/
    }
}
