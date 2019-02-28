package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Suit;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

class JDK8DeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdk1Deck = new JDKImperativeDeckOfCardsAsSortedSet();
    private JDK8DeckOfCardsAsSortedSet jdk2Deck = new JDK8DeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.getCards(), this.jdk2Deck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var jdk2Cards = this.jdk2Deck.getCards();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2Cards.remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdk2Cards::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2Cards.add(null));*/
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.diamonds(), this.jdk2Deck.diamonds());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.hearts(), this.jdk2Deck.hearts());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.spades(), this.jdk2Deck.spades());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.clubs(), this.jdk2Deck.clubs());
    }

    @Test
    void deal() {
        Deque<Card> jdk1Shuffle = this.jdk1Deck.shuffle(new Random(1));
        Deque<Card> jdk2Shuffle = this.jdk2Deck.shuffle(new Random(1));

        Set<Card> jdk1Hand = this.jdk1Deck.deal(jdk1Shuffle, 5);
        Set<Card> jdk2Hand = this.jdk2Deck.deal(jdk2Shuffle, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hand, jdk2Hand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdk1Hands = this.jdk1Deck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> jdk2Hands = this.jdk2Deck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hands, jdk2Hands);
    }

    @Test
    void dealHands() {
        Deque<Card> jdk1Shuffled = this.jdk1Deck.shuffle(new Random(1));
        Deque<Card> jdk2Shuffled = this.jdk2Deck.shuffle(new Random(1));
        List<Set<Card>> jdk1Hands = this.jdk1Deck.dealHands(jdk1Shuffled, 5, 5);
        List<Set<Card>> jdk2Hands = this.jdk2Deck.dealHands(jdk2Shuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hands, jdk2Hands);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdk1CardsBySuit = this.jdk1Deck.getCardsBySuit();
        Map<Suit, SortedSet<Card>> jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdk1CardsBySuit.get(Suit.CLUBS), jdk2CardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2CardsBySuit.remove(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdk2CardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2CardsBySuit.get(Suit.CLUBS).remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2CardsBySuit.get(Suit.CLUBS).add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdk2CardsBySuit.get(Suit.CLUBS)::clear);*/
    }

    @Test
    void countsBySuit() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdk1Deck.countsBySuit().get(Suit.CLUBS),
                this.jdk2Deck.countsBySuit().get(Suit.CLUBS));*/
    }

    @Test
    void countsByRank() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdk1Deck.countsByRank().get(Rank.TEN),
                this.jdk2Deck.countsByRank().get(Rank.TEN));*/
    }
}
