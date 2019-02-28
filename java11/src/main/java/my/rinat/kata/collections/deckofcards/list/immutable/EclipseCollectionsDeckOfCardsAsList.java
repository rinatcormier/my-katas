package my.rinat.kata.collections.deckofcards.list.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.list.ImmutableListMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;

import java.util.Random;
import java.util.Set;

public class EclipseCollectionsDeckOfCardsAsList {
    private ImmutableList<Card> cards;
    private ImmutableListMultimap<Suit, Card> cardsBySuit;

    /**
     * TODO Replace the null values below with something more useful.
     * Use Eclipse Collections APIs with {@link Card#lazyCards()} to create an ImmutableSortedSet and store that in cards.
     * Group all of the cards by {@link Card#getSuit()} into an ImmutableSortedSetMultimap and stored that in cardsBySuit.
     * <p>
     * Hint: Look at {@link ImmutableList#groupBy(Function)}
     */
    public EclipseCollectionsDeckOfCardsAsList() {
        this.cards = null;
        this.cardsBySuit = null;
    }

    public MutableStack<Card> shuffle(Random random) {
        // TODO Shuffle the deck 3 times with the Random parameter and push the shuffled cards onto a MutableStack
        // Hint: Look at MutableList.shuffleThis(Random) and toStack()
        return null;
    }

    public MutableSet<Card> deal(MutableStack<Card> stack, int count) {
        return stack.pop(count).toSet();
    }

    public ImmutableList<Set<Card>> shuffleAndDeal(Random random, int hands, int cardsPerHand) {
        var shuffled = this.shuffle(random);
        return this.dealHands(shuffled, hands, cardsPerHand);
    }

    public ImmutableList<Set<Card>> dealHands(
            MutableStack<Card> shuffled,
            int hands,
            int cardsPerHand) {
        // TODO Deal the number of hands with the cardsPerHand into an ImmutableList<Set<Card>>
        // Hint: Look at IntInterval.collect()
        return null;
    }

    public ImmutableList<Card> diamonds() {
        // TODO Return all of the diamonds as an ImmutableList
        return null;
    }

    public ImmutableList<Card> hearts() {
        // TODO Return all of the hearts as an ImmutableList
        return null;
    }

    public ImmutableList<Card> spades() {
        // TODO Return all of the spades as an ImmutableList
        return null;
    }

    public ImmutableList<Card> clubs() {
        // TODO Return all of the clubs as an ImmutableList
        return null;
    }

    public Bag<Suit> countsBySuit() {
        // TODO return the count of cards by Suit
        // Hint: Look at countBy()
        return null;
    }

    public Bag<Rank> countsByRank() {
        // TODO return the count of cards by Rank
        // Hint: Look at countBy()
        return null;
    }

    public ImmutableList<Card> getCards() {
        return this.cards;
    }

    public ImmutableListMultimap<Suit, Card> getCardsBySuit() {
        return this.cardsBySuit;
    }
}
