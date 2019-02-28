package my.rinat.kata.collections.deckofcards.list.immutable;

import org.junit.jupiter.api.Test;

import java.util.Random;

class GoogleGuavaDeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();
    private GoogleGuavaDeckOfCardsAsList ggDeck = new GoogleGuavaDeckOfCardsAsList();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.ggDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var ggCards = this.ggDeck.getCards();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCards.remove(0));
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
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        var ggShuffle = this.ggDeck.shuffle(new Random(1));

        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        var ggHand = this.ggDeck.deal(ggShuffle, 5);
        // fixme:
        // Assert.assertEquals(jdkHand, ggHand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        var ggHands = this.ggDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ggHands);
    }

    @Test
    void dealHands() {
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var ggShuffled = this.ggDeck.shuffle(new Random(1));
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        var ggHands = this.ggDeck.dealHands(ggShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, ggHands);
    }

    @Test
    void cardsBySuit() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        var ggCardsBySuit = this.ggDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), ggCardsBySuit.get(Suit.CLUBS));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var ggCardsBySuit = this.ggDeck.getCardsBySuit();
        /*
        // fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCardsBySuit.removeAll(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                ggCardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> ggCardsBySuit.get(Suit.CLUBS).remove(0));
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
