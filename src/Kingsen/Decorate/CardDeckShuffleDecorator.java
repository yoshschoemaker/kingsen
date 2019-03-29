package Kingsen.Decorate;

import Kingsen.Build.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeckShuffleDecorator extends CardDeckDecorator {

    private static Random random;

    public CardDeckShuffleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public ArrayList<Card> generateCardDeck() {
        return shuffle(super.generateCardDeck());
    }

    /**
     * This function moves the position of the cards inside the Card list.
     *
     * @param cards the array that contains the cards
     * @return the shuffled Card list
     */
    private ArrayList<Card> shuffle(ArrayList<Card> cards) {
        if (random == null) random = new Random();
        int count = cards.size();
        for (int i = count; i > 1; i--) {
            Collections.swap(cards, i - 1, random.nextInt(i));
        }

        return cards;
    }
}
