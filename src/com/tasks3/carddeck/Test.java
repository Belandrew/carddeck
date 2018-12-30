package com.tasks3.carddeck;

public class Test {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println();
        printDeck(deck);
        deck.shuffle();
        System.out.println(deck);
        deck.order();
        System.out.println(deck);

        // optional print
        printDeck(deck);
    }

    /**
     * Optional way to print the desk (desk.toString() can be used instead)
     *
     * @param deck - deck to print
     */
    private static void printDeck(Deck deck) {
        deck.resetIterator();
        while (deck.hasNext()) {
            Card card = deck.drawOne();
//            Card card = deck.next();  // the same
            System.out.println(card.getSuit().getName() + "-" + card.getRank().getName());
        }
    }
}
