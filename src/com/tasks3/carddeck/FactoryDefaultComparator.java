package com.tasks3.carddeck;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FactoryDefaultComparator implements Comparator<Card> {
    private static List<Suit> suits = Arrays.asList(Suit.values);
    private static List<Rank> ranks = Arrays.asList(Rank.values);

    @Override
    public int compare(Card card1, Card card2) {
        int compareBySuit = Integer.compare(suits.indexOf(card1.getSuit()), suits.indexOf(card2.getSuit()));
        if (compareBySuit != 0) return compareBySuit;

        return Integer.compare(ranks.indexOf(card1.getRank()), ranks.indexOf(card2.getRank()));
    }
}