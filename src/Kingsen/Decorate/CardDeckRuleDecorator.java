package Kingsen.Decorate;

public class CardDeckRuleDecorator extends CardDeckDecorator {

    CardDeckRuleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public void generateCardDeck() {
        super.generateCardDeck();
    }

    private void addCardRules() {

    }
}
