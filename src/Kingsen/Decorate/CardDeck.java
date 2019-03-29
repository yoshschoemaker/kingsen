package Kingsen.Decorate;

import Kingsen.Build.Card;
import Kingsen.Build.CardBuilder;
import Kingsen.Build.Director;
import Kingsen.Build.Type;

import java.util.ArrayList;

public class CardDeck implements CardDeckInterface {

    /**
     * Generate cards based on a common deck (52 cards) with the CardBuilder.
     */
    @Override
    public ArrayList<Card> generateCardDeck() {

        // Making use of the builder pattern
        CardBuilder cardBuilder = new CardBuilder();
        Director director = new Director();

        // Instantiate the ArrayList
        ArrayList<Card> cards = new ArrayList<>();

        // Add the face cards
        for (Type type : Type.values()) {
            director.constructAceCard(cardBuilder, type);
            cards.add(cardBuilder.getCard());

            director.constructKingCard(cardBuilder, type);
            cards.add(cardBuilder.getCard());

            director.constructQueenCard(cardBuilder, type);
            cards.add(cardBuilder.getCard());

            director.constructJackCard(cardBuilder, type);
            cards.add(cardBuilder.getCard());
        }

        // Add the number cards
        for (int number = 2; number < 11; number++) {
            for (Type type : Type.values()) {
                director.constructNumberCard(cardBuilder, type, number);
                cards.add(cardBuilder.getCard());
            }
        }

        // Assign the list to the field
        return cards;
    }
}
