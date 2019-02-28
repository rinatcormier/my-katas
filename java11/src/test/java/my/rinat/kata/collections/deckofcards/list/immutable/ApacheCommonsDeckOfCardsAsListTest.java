package my.rinat.kata.collections.deckofcards.list.immutable;

import org.junit.jupiter.api.Test;

import java.util.Random;

class ApacheCommonsDeckOfCardsAsListTest {
    private JDKImperativeDeckOfCardsAsList jdkDeck = new JDKImperativeDeckOfCardsAsList();
    private ApacheCommonsDeckOfCardsAsList acDeck = new ApacheCommonsDeckOfCardsAsList();

    @Test
    void allCards() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.getCards(), this.acDeck.getCards());
    }

    @Test
    void cardsAreImmutable() {
        var acCards = this.acDeck.getCards();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCards.remove(0));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                acCards::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCards.add(null));*/
    }

    @Test
    void diamonds() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.diamonds(), this.acDeck.diamonds());
    }

    @Test
    void hearts() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.hearts(), this.acDeck.hearts());
    }

    @Test
    void spades() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.spades(), this.acDeck.spades());
    }

    @Test
    void clubs() {
        // fixme:
        // Assert.assertEquals(this.jdkDeck.clubs(), this.acDeck.clubs());
    }

    @Test
    void deal() {
        var jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        var acShuffle = this.acDeck.shuffle(new Random(1));

        var jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        var acHand = this.acDeck.deal(acShuffle, 5);
        // fixme:
        // Assert.assertEquals(jdkHand, acHand);
    }

    @Test
    void shuffleAndDealHands() {
        var jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        var acHands = this.acDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, acHands);
    }

    @Test
    void dealHands() {
        var jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        var acShuffled = this.acDeck.shuffle(new Random(1));
        var jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        var acHands = this.acDeck.dealHands(acShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, acHands);
    }

    @Test
    void cardsBySuit() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        var acCardsBySuit = this.acDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), new ArrayList<>(acCardsBySuit.get(Suit.CLUBS)));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var acCardsBySuit = this.acDeck.getCardsBySuit();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCardsBySuit.remove(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                acCardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCardsBySuit.get(Suit.CLUBS).remove(0));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCardsBySuit.get(Suit.CLUBS).add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                acCardsBySuit.get(Suit.CLUBS)::clear);*/
    }

    @Test
    void countsBySuit() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue(),
                this.acDeck.countsBySuit().getCount(Suit.CLUBS));*/
    }

    @Test
    void countsByRank() {
        /*
        fixme:
        Assert.assertEquals(
                this.jdkDeck.countsByRank().get(Rank.TEN).intValue(),
                this.acDeck.countsByRank().getCount(Rank.EIGHT));*/
    }
}
