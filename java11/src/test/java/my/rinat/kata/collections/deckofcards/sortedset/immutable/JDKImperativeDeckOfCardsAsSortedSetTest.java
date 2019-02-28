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

class JDKImperativeDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        /*
        fixme:
        Assert.assertEquals(52, this.jdkDeck.getCards().size());
        Assert.assertEquals(new Card(Rank.ACE, Suit.SPADES), this.jdkDeck.getCards().first());
        Assert.assertEquals(new Card(Rank.KING, Suit.CLUBS), this.jdkDeck.getCards().last());*/
    }

    @Test
    void cardsAreImmutable() {
        var jdkCards = this.jdkDeck.getCards();
        /*
        fixme:
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdkCards.remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdkCards::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdkCards.add(null));*/
    }

    @Test
    void diamonds() {
        /*
        fixme:
        Assert.assertEquals(13, this.jdkDeck.diamonds().size());
        Assert.assertTrue(Iterate.allSatisfy(this.jdkDeck.diamonds(), Card::isDiamonds));*/
    }

    @Test
    void hearts() {
        /*
        fixme
        Assert.assertEquals(13, this.jdkDeck.hearts().size());
        Assert.assertTrue(Iterate.allSatisfy(this.jdkDeck.hearts(), Card::isHearts));*/
    }

    @Test
    void spades() {
        /*
        fixme:
        Assert.assertEquals(13, this.jdkDeck.spades().size());
        Assert.assertTrue(Iterate.allSatisfy(this.jdkDeck.spades(), Card::isSpades));*/
    }

    @Test
    void clubs() {
        /*
        fixme:
        Assert.assertEquals(13, this.jdkDeck.clubs().size());
        Assert.assertTrue(Iterate.allSatisfy(this.jdkDeck.clubs(), Card::isClubs));*/
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        /*
        fixme
        Assert.assertEquals(5, jdkHand.size());
        Assert.assertEquals(47, jdkShuffle.size());*/
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        /*
        fixme:
        Assert.assertEquals(5, jdkHands.size());
        Assert.assertTrue(Iterate.allSatisfy(jdkHands, each -> each.size() == 5));*/
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        /*
        fixme:
        Assert.assertEquals(5, jdkHands.size());
        Assert.assertTrue(Iterate.allSatisfy(jdkHands, each -> each.size() == 5));
        Assert.assertEquals(27, jdkShuffled.size());*/
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        /*
        fixme
        Assert.assertEquals(4, jdkCardsBySuit.size());
        Assert.assertEquals(13, jdkCardsBySuit.get(Suit.CLUBS).size());
        Assert.assertEquals(13, jdkCardsBySuit.get(Suit.DIAMONDS).size());
        Assert.assertEquals(13, jdkCardsBySuit.get(Suit.SPADES).size());
        Assert.assertEquals(13, jdkCardsBySuit.get(Suit.HEARTS).size());*/
    }

    @Test
    void cardsBySuitIsImmutable() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        /*
        fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdkCardsBySuit.remove(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdkCardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdkCardsBySuit.get(Suit.CLUBS).remove(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> jdkCardsBySuit.get(Suit.CLUBS).add(null));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                jdkCardsBySuit.get(Suit.CLUBS)::clear);*/
    }

    @Test
    void countsBySuit() {
        // fixme:
        // Assert.assertEquals(Long.valueOf(13), this.jdkDeck.countsBySuit().get(Suit.CLUBS));
    }

    @Test
    void countsByRank() {
        // fixme:
        // Assert.assertEquals(Long.valueOf(4), this.jdkDeck.countsByRank().get(Rank.TEN));
    }
}
