package Kingsen.Decorate;

import Kingsen.Build.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDeckRuleDecorator extends CardDeckDecorator {

    CardDeckRuleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public ArrayList<Card> generateCardDeck() {
        return super.generateCardDeck();
    }

    private void addCardRules() {

    }
}
