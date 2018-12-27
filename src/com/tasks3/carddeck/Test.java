package com.tasks3.carddeck;

public class Test {
    private static Rank rank;
    private static Suit suit;

    public static void main(String[] args) {

        Card curCard=null;

        Deck deck = new Deck();
        deck.order();
        deck.shuffle();
       curCard = deck.drawOne();
       System.out.println(curCard.getRank().getName()+" "+curCard.getSuit().getName());
        System.out.println(deck.hasNext());

        //System.out.println(card.getRank().getName());
       // System.out.println(card.getSuit().getName());




}}
