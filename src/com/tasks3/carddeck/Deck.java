package com.tasks3.carddeck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterator<Card> {
    private static final int SHUFFLE_ITERATIONS = 1000;
    private final List<Card> deck;
    private Iterator<Card> iterator;

    public Deck() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values) {
            for (Rank rank : Rank.values) {
                deck.add(new Card(rank, suit));
            }
        }
        iterator = deck.iterator();
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < SHUFFLE_ITERATIONS; i++) {
            int first = random.nextInt(deck.size());
            int second = random.nextInt(deck.size());
            Card card = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, card);
        }
        iterator = deck.iterator();
    }

    /* * Впорядкування колоди за мастями та значеннями
     * Порядок сотрування:
     * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
     * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
     * Наприклад
     * HEARTS Ace
     * HEARTS King
     * HEARTS Queen
     * HEARTS Jack
     * HEARTS 10
     * HEARTS 9
     * HEARTS 8
     * HEARTS 7
     * HEARTS 6
     * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
//        List<Suit> suits = Arrays.asList(Suit.values);
//        List<Rank> ranks = Arrays.asList(Rank.values);
//        deck.sort((card1, card2) -> {
//            int compareBySuit = Integer.compare(suits.indexOf(card1.getSuit()), suits.indexOf(card2.getSuit()));
//            if (compareBySuit != 0) return compareBySuit;
//            return Integer.compare(ranks.indexOf(card1.getRank()), ranks.indexOf(card2.getRank()));
//        });
        deck.sort(new FactoryDefaultComparator());
        iterator = deck.iterator();
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Card next() {
        return iterator.next();
    }

    public void resetIterator() {
        iterator = deck.iterator();
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (hasNext()) {
            return next();
        }
        return null;
    }
    //Так правильно?
    public String printDeck() {
        String out = "====The deck====\n";
        for (Card card : deck) {
            out += (card.getSuit().getName() + "-" + card.getRank().getName() + "\n");
        }
        return out;
    }
   /* @Override
    public String toString() {
        String out = "====The deck====\n";
        for (Card card : deck) {
        out += (getSuit().getName() + "-" + getRank().getName() + "\n");
         }
        return out;
    }*/


}