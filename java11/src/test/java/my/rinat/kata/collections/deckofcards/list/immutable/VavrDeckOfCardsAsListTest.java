package my.rinat.kata.collections.deckofcards.list.immutable;

import org.junit.jupiter.api.Test;

import java.util.Random;

class VavrDeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();
    private VavrDeckOfCardsAsList vavrDeck = new VavrDeckOfCardsAsList();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.vavrDeck.getCards().toJavaList());
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.diamonds(), this.vavrDeck.diamonds().toJavaList());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.hearts(), this.vavrDeck.hearts().toJavaList());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.spades(), this.vavrDeck.spades().toJavaList());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.clubs(), this.vavrDeck.clubs().toJavaList());
    }

    @Test
    void deal() {
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        var vavrShuffle = this.vavrDeck.shuffle(new Random(1));

        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        var vavrHand = this.vavrDeck.deal(vavrShuffle, 5)._1().toJavaSet();
        // fixme:
        // Assert.assertEquals(jdkHand, vavrHand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        var vavrHands = this.vavrDeck.shuffleAndDeal(new Random(1), 5, 5);
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
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var vavrShuffled = this.vavrDeck.shuffle(new Random(1));
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        var vavrHands = this.vavrDeck.dealHands(vavrShuffled, 5, 5);
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
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        var vavrCardsBySuit = this.vavrDeck.getCardsBySuit();
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
