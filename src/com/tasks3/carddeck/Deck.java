package com.tasks3.carddeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class Deck {
    private  Rank rank;
    private  Suit suit;
    private   Card card;
    private  final List<Card> deck = new ArrayList<>();
    private Random randomizer = new Random();

    //Тосовать колоду
    public void shuffle() {
             for (int i=0; i < deck.size(); i++ ) {
             card = deck.get(i);
            int number = randomizer.nextInt(deck.size()-1);
            deck.set( i, deck.get(number));
            deck.set(number, card);

        }


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
        deck.clear();
        int ind=0;
        for(int i = 0; i < 4; i++){
            suit = Suit.values[i];
            for(int n = 0; n < 9; n++) {
                rank = Rank.values[n];
                deck.add(new Card(rank, suit));


            }
        }
    }

    //Повертає true у випадку коли в колоді ще доступні карти
   public  boolean hasNext() {
       if (deck.size() > 0)
           return true;
     else return false;
   }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public  Card drawOne() {
       card = deck.get(deck.size()-1);
       deck.remove(deck.size()-1);
       return card;
   }

}