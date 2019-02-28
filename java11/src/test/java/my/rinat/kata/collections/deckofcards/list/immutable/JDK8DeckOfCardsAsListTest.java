package my.rinat.kata.collections.deckofcards.list.immutable;

import org.junit.jupiter.api.Test;

import java.util.Random;

class JDK8DeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdk1Deck = new JDKImperativeDeckOfCardsAsList();
    private JDK8DeckOfCardsAsList jdk2Deck = new JDK8DeckOfCardsAsList();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdk1Deck.getCards(), this.jdk2Deck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var jdk2Cards = this.jdk2Deck.getCards();
        /*
        fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2Cards.remove(0));
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
        var jdk1Shuffle = this.jdk1Deck.shuffle(new Random(1));
        var jdk2Shuffle = this.jdk2Deck.shuffle(new Random(1));

        var jdk1Hand = this.jdk1Deck.deal(jdk1Shuffle, 5);
        var jdk2Hand = this.jdk2Deck.deal(jdk2Shuffle, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hand, jdk2Hand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdk1Hands = this.jdk1Deck.shuffleAndDeal(new Random(1), 5, 5);
        var jdk2Hands = this.jdk2Deck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hands, jdk2Hands);
    }

    @Test
    void dealHands() {
        var jdk1Shuffled = this.jdk1Deck.shuffle(new Random(1));
        var jdk2Shuffled = this.jdk2Deck.shuffle(new Random(1));
        var jdk1Hands = this.jdk1Deck.dealHands(jdk1Shuffled, 5, 5);
        var jdk2Hands = this.jdk2Deck.dealHands(jdk2Shuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdk1Hands, jdk2Hands);
    }

    @Test
    void cardsBySuit() {
        var jdk1CardsBySuit = this.jdk1Deck.getCardsBySuit();
        var jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdk1CardsBySuit.get(Suit.CLUBS), jdk2CardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var jdk2CardsBySuit = this.jdk2Deck.getCardsBySuit();
        /*
        fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2CardsBySuit.remove(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdk2CardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdk2CardsBySuit.get(Suit.CLUBS).remove(0));
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
