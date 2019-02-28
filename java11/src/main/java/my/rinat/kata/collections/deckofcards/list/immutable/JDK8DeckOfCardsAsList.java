package my.rinat.kata.collections.deckofcards.list.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;

import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JDK8DeckOfCardsAsList {

    private List<Card> cards;
    private Map<Suit, List<Card>> cardsBySuit;

    /**
     * TODO Replace the null values below with something more useful.
     * Use Java 8 Streams API with {@link Card#streamCards()} to create an "immutable" List and store that in cards.
     * Group all of the cards by {@link Card#getSuit()} into an "immutable" Map and stored that in cardsBySuit.
     * <p>
     * Hint: Look at {@link Collectors#groupingBy(Function)}, {@link Collections#unmodifiableList(List)}
     * {@link Collectors#collectingAndThen(Collector, Function)}, {@link Collectors#mapping(Function, Collector)}
     */
    public JDK8DeckOfCardsAsList() {
        this.cards = null;
        this.cardsBySuit = null;
    }

    public Deque<Card> shuffle(Random random) {
        // TODO Shuffle the deck 3 times with the Random parameter and push the shuffled cards onto an ArrayDeque
        // Hint: Look at IntStream.range() or IntStream.rangeClosed() and Collections.shuffle().
        return null;
    }

    public Set<Card> deal(Deque<Card> deque, int count) {
        var hand = new HashSet<Card>();
        IntStream.range(0, count).forEach(i -> hand.add(deque.pop()));
        return hand;
    }

    public List<Set<Card>> shuffleAndDeal(Random random, int hands, int cardsPerHand) {
        var shuffled = this.shuffle(random);
        return this.dealHands(shuffled, hands, cardsPerHand);
    }

    public List<Set<Card>> dealHands(Deque<Card> shuffled, int hands, int cardsPerHand) {
        // TODO Deal the number of hands with the cardsPerHand into an "immutable" List<Set<Card>>
        return null;
    }

    public List<Card> diamonds() {
        // TODO return all diamonds as an "Immutable" List
        return null;
    }

    public List<Card> hearts() {
        // TODO return all hearts as an "Immutable" List
        return null;
    }

    public List<Card> spades() {
        // TODO return all spades as an "Immutable" List
        return null;
    }

    public List<Card> clubs() {
        // TODO return all clubs as an "Immutable" List
        return null;
    }

    public Map<Suit, Long> countsBySuit() {
        // TODO return the count of cards by Suit
        // Hint: Look at Collectors.groupingBy() and Collectors.counting()
        return null;
    }

    public Map<Rank, Long> countsByRank() {
        // TODO return the count of cards by Rank
        // Hint: Look at Collectors.groupingBy() and Collectors.counting()
        return null;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Map<Suit, List<Card>> getCardsBySuit() {
        return this.cardsBySuit;
    }
}
