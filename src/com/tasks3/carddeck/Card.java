package com.tasks3.carddeck;

public class Card {
    private Rank rank;
    private Suit suit;

    //Так правильно?
    @Override
    public String toString() {
       // /String out = "====The deck====\n";
        String out = "====The card====\n";
        //for (Card card : deck) {
            out += (getSuit().getName() + "-" + getRank().getName() + "\n");
       // }
        return out;
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}