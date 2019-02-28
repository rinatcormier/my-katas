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

class VavrDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private VavrDeckOfCardsAsSortedSet vavrDeck = new VavrDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.vavrDeck.getCards().toJavaSet());
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.diamonds(), this.vavrDeck.diamonds().toJavaSet());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.hearts(), this.vavrDeck.hearts().toJavaSet());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.spades(), this.vavrDeck.spades().toJavaSet());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.clubs(), this.vavrDeck.clubs().toJavaSet());
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        io.vavr.collection.List<Card> vavrShuffle = this.vavrDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> vavrHand = this.vavrDeck.deal(vavrShuffle, 5)._1().toJavaSet();
        // fixme:
        // Assert.assertEquals(jdkHand, vavrHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        io.vavr.collection.List<io.vavr.collection.Set<Card>> vavrHands =
                this.vavrDeck.shuffleAndDeal(new Random(1), 5, 5);
        /*
        fixme
        Assert.assertEquals(jdkHands.get(0), vavrHands.get(0).toJavaSet());
        Assert.assertEquals(jdkHands.get(1), vavrHands.get(1).toJavaSet());
        Assert.assertEquals(jdkHands.get(2), vavrHands.get(2).toJavaSet());
        Assert.assertEquals(jdkHands.get(3), vavrHands.get(3).toJavaSet());
        Assert.assertEquals(jdkHands.get(4), vavrHands.get(4).toJavaSet());*/
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        io.vavr.collection.List<Card> vavrShuffled = this.vavrDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        io.vavr.collection.List<io.vavr.collection.Set<Card>> vavrHands =
                this.vavrDeck.dealHands(vavrShuffled, 5, 5);
        /*
        fixme:
        Assert.assertEquals(jdkHands.get(0), vavrHands.get(0).toJavaSet());
        Assert.assertEquals(jdkHands.get(1), vavrHands.get(1).toJavaSet());
        Assert.assertEquals(jdkHands.get(2), vavrHands.get(2).toJavaSet());
        Assert.assertEquals(jdkHands.get(3), vavrHands.get(3).toJavaSet());
        Assert.assertEquals(jdkHands.get(4), vavrHands.get(4).toJavaSet());*/
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        io.vavr.collection.Map<Suit, ? extends io.vavr.collection.SortedSet<Card>> vavrCardsBySuit =
                this.vavrDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), vavrCardsBySuit.get(Suit.CLUBS).get().toJavaList());
    }

    @Test
    void countsBySuit() {
        /*
        fixme
        Assert.assertEquals(
                this.jdkDeck.countsBySuit().get(Suit.CLUBS),
                this.vavrDeck.countsBySuit().get(Suit.CLUBS).get());*/
    }

    @Test
    void countsByRank() {
        /*
        fixme
        Assert.assertEquals(
                this.jdkDeck.countsByRank().get(Rank.TEN),
                this.vavrDeck.countsByRank().get(Rank.TEN).get());*/
    }
}
