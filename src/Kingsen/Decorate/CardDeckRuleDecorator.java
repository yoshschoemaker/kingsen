package Kingsen.Decorate;

import Kingsen.Build.Card;
import Kingsen.Build.Face;

import java.util.ArrayList;

public class CardDeckRuleDecorator extends CardDeckDecorator {

    public CardDeckRuleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public ArrayList<Card> generateCardDeck() {
        return addCardRules(super.generateCardDeck());
    }

    // TODO (sometime?): redo implementation with something like JSON or a Game Rule class
    // Haven't had time to do so, sadly
    private ArrayList<Card> addCardRules(ArrayList<Card> cards) {

        for (Card card : cards) {
            if (card.isNumberCard()) {
                switch (card.getNumber()) {
                    case 2:
                        card.getRule().setRuleTitle("Generosity");
                        card.getRule().setDescription("Give out a penalty point :). Wow you’re so generous!");
                        break;
                    case 3:
                        card.getProperties().setSelfPenalty(true);
                        card.getRule().setRuleTitle("Take one for the team");
                        card.getRule().setDescription("Give yourself a penalty. Such a good guy.");
                        break;
                    case 4:
                        card.getRule().setRuleTitle("Category");
                        card.getRule().setDescription("Choose a category. All players must name something in this category, going clockwise. The player who isn’t able to think of something is the loser.");
                        break;
                    case 5:
                        card.getProperties().setPlayable(true);
                        card.getProperties().setPenaltyEnabled(false);
                        card.getRule().setRuleTitle("Toilet card");
                        card.getRule().setDescription("Congratulations! You may go to the toilet for one time with this card. Use whenever you like.");
                        break;
                    case 6:
                        card.getRule().setRuleTitle("Assignment");
                        card.getRule().setDescription("Choose an action a player has to make before or after drinking. When a player doesn’t perform this action, he gets a penalty.");
                        break;
                    case 7:
                        card.getRule().setRuleTitle("Multiplying!");
                        card.getRule().setDescription("Each player has to say ‘Yeah’ whenever a 7 is in the number or it’s a multiple of 7, going clockwise. For example: 1,2,3,4,5,6, YEAH, 8.. Player to fail first gets a penalty.");
                        break;
                    case 8:
                        card.getRule().setRuleTitle("Pointing");
                        card.getRule().setDescription("All point up! Countdown from 5 and all point at someone random. Player with most people pointing at him/her gets a penalty.");
                        break;
                    case 9:
                        card.getRule().setRuleTitle("Floor");
                        card.getRule().setDescription("Last person to touch the floor gets the penalty!!1!!! PANIC");
                        break;
                    case 10:
                        card.getRule().setRuleTitle("Never have I ever");
                        card.getRule().setDescription("Everyone holds up 3 fingers. The person who drew this card says a sentence starting with ‘Never have I ever..’ and completes with something he/she hasn’t done. Whoever has done it, lowers one finger. First person to lowers all fingers gets the penalty.");
                        break;
                }
            }

            if (card.getFace() == Face.JACK) {
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("QUIZZMASTER!!!");
                card.getRule().setDescription("Until another player draws a jack, nobody can answer your questions. Whenever someone does, they get a penalty.");
            }

            if (card.getFace() == Face.QUEEN) {
                card.getProperties().setPlayable(true);
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("Rise of the Queen");
                card.getRule().setDescription("You can point in the air at any moment (only once). Last person to follow gets the penalty.");
            }

            if (card.getFace() == Face.KING) {
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("Nicknames");
                card.getRule().setDescription("Give someone a nickname. Whenever and whoever someone doesn’t call him/her by his/her nickname gets a penalty.");
            }

            if (card.getFace() == Face.ACE) {
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("Snake eyes");
                card.getRule().setDescription("No one can look you in the eyes until another ace is picked. Whenever someone looks in your eyes, they receive a penalty point. While you would think it sucks to be the out casted snake eyes, it actually provides an opportunity to get the other players very drunk by tricking them into looking at you.");
            }
        }

        return cards;
    }
}
