package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Suit;
import org.apache.commons.collections4.MultiValuedMap;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

class ApacheCommonsDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();
    private ApacheCommonsDeckOfCardsAsSortedSet acDeck = new ApacheCommonsDeckOfCardsAsSortedSet();

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
                () -> acCards.remove(null));
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
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> acShuffle = this.acDeck.shuffle(new Random(1));

        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Set<Card> acHand = this.acDeck.deal(acShuffle, 5);
        // fixme:
        // Assert.assertEquals(jdkHand, acHand);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        List<Set<Card>> acHands = this.acDeck.shuffleAndDeal(new Random(1), 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, acHands);
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        Deque<Card> acShuffled = this.acDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        List<Set<Card>> acHands = this.acDeck.dealHands(acShuffled, 5, 5);
        // fixme:
        // Assert.assertEquals(jdkHands, acHands);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        MultiValuedMap<Suit, Card> acCardsBySuit = this.acDeck.getCardsBySuit();
        // fixme:
        // Assert.assertEquals(jdkCardsBySuit.get(Suit.CLUBS), new TreeSet<>(acCardsBySuit.get(Suit.CLUBS)));
    }

    @Test
    void cardsBySuitIsImmutable() {
        var acCardsBySuit = this.acDeck.getCardsBySuit();
        /*
        fixme
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCardsBySuit.remove(Suit.CLUBS));
        Verify.assertThrows(
                UnsupportedOperationException.class,
                acCardsBySuit::clear);
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> acCardsBySuit.get(Suit.CLUBS).remove(null));
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
        fixme
        Assert.assertEquals(
                this.jdkDeck.countsBySuit().get(Suit.CLUBS).intValue(),
                this.acDeck.countsBySuit().getCount(Suit.CLUBS));*/
    }

    @Test
    void countsByRank() {
        /*
        fixme
        Assert.assertEquals(
                this.jdkDeck.countsByRank().get(Rank.TEN).intValue(),
                this.acDeck.countsByRank().getCount(Rank.EIGHT));*/
    }
}
