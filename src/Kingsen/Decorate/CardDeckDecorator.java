package Kingsen.Decorate;

public class CardDeckDecorator implements CardDeckInterface {
    private CardDeckInterface wrappee;

    CardDeckDecorator(CardDeckInterface cardDeckInterface) {
        this.wrappee = cardDeckInterface;
    }

    @Override
    public void generateCardDeck() {

    }
}
