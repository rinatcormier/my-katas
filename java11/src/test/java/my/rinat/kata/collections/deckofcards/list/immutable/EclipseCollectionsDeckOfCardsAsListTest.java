package my.rinat.kata.collections.deckofcards.list.immutable;

import org.junit.jupiter.api.Test;

import java.util.Random;

class EclipseCollectionsDeckOfCardsAsListTest {
    private EclipseCollectionsDeckOfCardsAsList ecDeck = new EclipseCollectionsDeckOfCardsAsList();
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.ecDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ecCards = this.ecDeck.getCards().castToList();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCards.remove(0));
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
        // Assert.assertEquals(this.jdkDeck.diamonds(), this.ecDeck.diamonds());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.hearts(), this.ecDeck.hearts());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.spades(), this.ecDeck.spades());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.clubs(), this.ecDeck.clubs());
    }

    @Test
    void deal() {
        var ecShuffle = this.ecDeck.shuffle(new Random(1));
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));

        var ecHand = this.ecDeck.deal(ecShuffle, 5);
        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        // fixme:
        // Assert.assertEquals(jdkHand, ecHand);
    }

    @Test
    void shuffleAndDealHands() {
        var ecHands = this.ecDeck.shuffleAndDeal(new Random(1), 5, 5);
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ecHands);
    }

    @Test
    void dealHands() {
        var ecShuffled = this.ecDeck.shuffle(new Random(1));
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var ecHands = this.ecDeck.dealHands(ecShuffled, 5, 5);
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ecHands);
    }

    @Test
    void cardsBySuit() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), ecCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ecCardsBySuit = this.ecDeck.getCardsBySuit();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCardsBySuit.get(Suit.CLUBS).castToList().remove(0));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ecCardsBySuit.get(Suit.CLUBS).castToList().add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ecCardsBySuit.get(Suit.CLUBS).castToList()::clear);*/
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
