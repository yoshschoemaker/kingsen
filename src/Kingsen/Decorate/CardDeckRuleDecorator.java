package Kingsen.Decorate;

import Kingsen.Build.Card;
import Kingsen.Build.Face;

import java.util.ArrayList;
import java.util.List;

public class CardDeckRuleDecorator extends CardDeckDecorator {

    public CardDeckRuleDecorator(CardDeckInterface cardDeckInterface) {
        super(cardDeckInterface);
    }

    @Override
    public ArrayList<Card> generateCardDeck() {
        return addCardRules(super.generateCardDeck());
    }

    // TODO (sometime?): redo implementation with something like JSON or a Game Rule class
    private ArrayList<Card> addCardRules(ArrayList<Card> cards) {

        for (Card card : cards) {
            if (card.isNumberCard()) {
                switch (card.getNumber()) {
                    case 2:
                        card.getRule().setRuleTitle("Slok geven");
                        card.getRule().setDescription("Deel een slok uit aan een andere speler.");
                        break;
                    case 3:
                        card.getProperties().setSelfPenalty(true);
                        card.getRule().setRuleTitle("Slok nemen");
                        card.getRule().setDescription("Neem zelf een slok.");
                        break;
                    case 4:
                        card.getRule().setRuleTitle("Categorie");
                        card.getRule().setDescription("Kies een categorie, zoals automerken. " +
                                "Elke speler noemt een merk uit de categorie. Als een speler geen merk meer weet op te noemen " +
                                "of het duurt te lang, dan moet deze speler een slok nemen.");
                        break;
                    case 5:
                        card.getProperties().setPlayable(true);
                        card.getProperties().setPenaltyEnabled(false);
                        card.getRule().setRuleTitle("Plaskaart");
                        card.getRule().setDescription("De speler die deze kaart pakt mag naar de wc. " +
                                "Deze kaart mag maar 1 keer gebruikt worden tijdens het spel. Deze kaart hoeft niet direct ingezet te worden.");
                        break;
                    case 6:
                        card.getRule().setRuleTitle("Opdracht geven");
                        card.getRule().setDescription("Geef een opdracht aan speler. Voorbeelden: opdrukken, rondjes draaien, etc.");
                        break;
                    case 7:
                        card.getRule().setRuleTitle("TAFELEN!");
                        card.getRule().setDescription("Noem een getal op. " +
                                "Bijvoorbeeld 7: hierbij mogen getallen met een 7 (7,17,27,71,77,etc) en veelvoud van 7 (7,14,21,etc) niet " +
                                "genoemd worden. Wordt een van die getallen wel genoemd, dan neemt de noemer van dat getal een slok.");
                        break;
                    case 8:
                        card.getProperties().setPenaltyEnabled(false);
                        card.getRule().setRuleTitle("Regel maken");
                        card.getRule().setDescription("Verzin een regel. Iedereen moet zich aan die regel houden. Doet iemand dat niet, " +
                                "dan neemt diegene een slok. Voorbeeld: Er mogen geen namen meer worden genoemd.");
                        break;
                    case 9:
                        card.getProperties().setPenaltyEnabled(false);
                        card.getRule().setRuleTitle("Regel afschaffen");
                        card.getRule().setDescription("Er mag 1 regel worden afgeschaft indien er regels zijn.");
                        break;
                    case 10:
                        card.getProperties().setPenaltyEnabled(false);
                        card.getRule().setRuleTitle("QUIZMASTERRRRR!");
                        card.getRule().setDescription("Iedere speler die aan jou vragen stelt, moet een slok nemen. Jij bent geen Quizmaster meer " +
                                "als een andere speler een kaart met nummer 10 pakt.");
                        break;
                }
            }

            if (card.getFace() == Face.JACK) {
                card.getRule().setRuleTitle("Wijzen");
                card.getRule().setDescription("Alle spelers houden hun hand in de lucht en wijzen na 5 seconden een willekeurige speler aan. " +
                        "De speler waar het meest naar gewezen wordt, moet een slok nemen.");
            }

            if (card.getFace() == Face.QUEEN) {
                card.getProperties().setPlayable(true);
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("Rise of the Queen");
                card.getRule().setDescription("Op een willekeurig moment mag jij je hand in de lucht steken terwijl je 'rise of the queen' roept. " +
                        "Elke speler moet jou volgen. De laatste die dit doet, moet een slok nemen.");
            }

            if (card.getFace() == Face.KING) {
                card.getProperties().setPenaltyEnabled(false);
                card.getRule().setRuleTitle("Stapelen");
                card.getRule().setDescription("Leg de Koning op het shotglas. Is dit de laatste Koning? Dan mag jij het shotglaasje leegdrinken " +
                        "en ben jij de winnaar! Het spel is dan ten einde.");
            }

            if (card.getFace() == Face.ACE) {
                card.getProperties().setSelfPenalty(true);
                card.getRule().setRuleTitle("SHOTJUHHHHH!");
                card.getRule().setDescription("Drink een shotje.");
            }
        }

        return cards;
    }
}
