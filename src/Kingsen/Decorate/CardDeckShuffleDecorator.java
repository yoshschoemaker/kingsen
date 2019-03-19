package Kingsen.Decorate;

public class CardDeckShuffleDecorator extends CardDeckDecorator {

    CardDeckShuffleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public void generateCardDeck() {
        super.generateCardDeck();
    }

    private void shuffle() {

    }
}
