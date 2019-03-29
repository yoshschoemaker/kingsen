package Kingsen.Decorate;

import Kingsen.Build.Card;

import java.util.ArrayList;

public class CardDeckDecorator implements CardDeckInterface {

    private CardDeckInterface wrappee;

    CardDeckDecorator(CardDeckInterface cardDeckInterface) {
        this.wrappee = cardDeckInterface;
    }

    @Override
    public ArrayList<Card> generateCardDeck() {
        return wrappee.generateCardDeck();
    }
}
